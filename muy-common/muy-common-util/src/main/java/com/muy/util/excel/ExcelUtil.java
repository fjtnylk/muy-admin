package com.muy.util.excel;

import com.muy.util.excel.annotation.ExportField;
import com.muy.util.excel.annotation.ImportField;
import com.muy.util.excel.config.ExcelConfig;
import com.muy.util.excel.config.ExportConfig;
import com.muy.util.excel.config.ImportConfig;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by yanglikai on 2018/5/21.
 */
public final class ExcelUtil {

  public static <T> List<T> read(final HttpServletRequest request, final Class target) {
    List<MultipartFile> multipartFiles = getMultipartFile(request);
    if (CollectionUtils.isEmpty(multipartFiles)) {
      throw new IllegalArgumentException("upload file must not be null");
    }

    MultipartFile file = multipartFiles.get(0);
    try (InputStream inputStream = file.getInputStream()) {
      return _import(inputStream, target);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public static <T> List<T> read(final String path, final Class target) {
    try (InputStream inputStream = new FileInputStream(path)) {
      return _import(inputStream, target);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e.getMessage(), e);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private static <T> List<T> _import(final InputStream inputStream, final Class target) {
    ImportConfig importConfig = new ImportConfig(target);
    importConfig.config(inputStream);

    return _import(importConfig);
  }

  private static <T> List<T> _import(final ImportConfig config) {
    ExcelConfig excelConfig =
        ExcelConfig.create()
            .config(config.getTarget())
            .config(config);

    return _import(excelConfig);
  }

  private static <T> List<T> _import(final ExcelConfig config) {
    try (Workbook workbook = WorkbookFactory.create(config.inputStream())) {
      Sheet sheet = workbook.getSheetAt(0);
      if (sheet == null) {
        return new ArrayList<>(0);
      }

      int start = 1;
      int last = sheet.getLastRowNum();

      List<T> list = new ArrayList<>(last);
      for (int index = start; index <= last; index++) {
        Row row = sheet.getRow(index);
        if (row == null) {
          continue;
        }

        Class target = config.getTarget();
        T obj = (T) target.newInstance();

        Iterator<Cell> iterator = row.cellIterator();
        while (iterator.hasNext()) {
          Cell cell = iterator.next();

          /* 获取导入字段信息 */
          ImportField importField = config.importField(cell.getColumnIndex());

          /* 获取单元格数据 */
          String typeName = importField.type().getSimpleName();
          Object value = obtainCellValue(typeName, cell);

          /* 字段赋值 */
          ReflectUtil.setFieldValue(obj, importField.name(), value);
        }

        list.add(obj);
      }

      return list;
    } catch (Exception ex) {
      throw new IllegalArgumentException("excel import faild");
    }
  }

  public static <T> void write(final HttpServletResponse response, final List<T> rows) {
    try {
      String excelName = "";
      if (StringUtils.isEmpty(excelName)) {
        throw new IllegalArgumentException("Excel name must not be null");
      }

      response.setContentType("application/x-download");
      response.addHeader("Content-Disposition", "attachment;filename=" + excelName);

      OutputStream output = response.getOutputStream();

      _export(output, rows);

      output.close();
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public static <T> void write(final String path, final List<T> rows) {
    try (OutputStream outputStream = new FileOutputStream(path)) {
      _export(outputStream, rows);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e.getMessage(), e);
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private static <T> void _export(final OutputStream outputStream, final List<T> rows) {
    if (CollectionUtils.isEmpty(rows)) {
      throw new IllegalArgumentException("rows must be not null");
    }

    Class target = rows.get(0).getClass();

    ExportConfig exportConfig =
        new ExportConfig(target)
            .config(rows)
            .config(outputStream);

    _export(exportConfig);
  }

  private static void _export(final ExportConfig config) {
    ExcelConfig excelConfig =
        ExcelConfig.create()
            .config(config.getTarget())
            .config(config);

    _export(excelConfig);
  }

  private static void _export(final ExcelConfig config) {
    /* 创建workbook */
    try (Workbook book = new SXSSFWorkbook()) {

      /* 创建sheet */
      Sheet sheet = book.createSheet("sheet1");

        /* 打印标题 */
      List<ExportField> exportFields = config.exportFields();

      Row titleRow = sheet.createRow(0);
      for (ExportField title : exportFields) {
        Cell cell = titleRow.createCell(title.index());
        cell.setCellValue(title.title());
      }

        /* 打印数据 */
      int rowIndex = 1;
      List<Object> rows = config.exportRows();
      for (Object row : rows) {
        Row dataRow = sheet.createRow(rowIndex);

        for (ExportField field : exportFields) {
          Cell dataCell = dataRow.createCell(field.index());

          Object value = FieldUtils.readDeclaredField(row, field.name(), true);

          dataCell.setCellValue((String) value);
        }

        rowIndex++;
      }

      /* 输出excel */
      book.write(config.outputStream());
      book.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public static List<MultipartFile> getMultipartFile(final HttpServletRequest request) {
    List<MultipartFile> result = new ArrayList<>();
    CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
    if (resolver.isMultipart(request)) {
      MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
      Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
      while (iterator.hasNext()) {
        String fileName = iterator.next();
        List<MultipartFile> multipartFiles = multipartHttpServletRequest.getFiles(fileName);
        for (MultipartFile multipartFile : multipartFiles) {
          result.add(multipartFile);
        }
      }
    }
    return result;
  }

  private static Object obtainCellValue(String typeName, Cell cell) {
    if (typeName.equals("Integer")) {
      return BigDecimal.valueOf(cell.getNumericCellValue()).intValue();
    } else if (typeName.equals("Long")) {
      return BigDecimal.valueOf(cell.getNumericCellValue()).longValue();
    } else if (typeName.equals("BigDecimal")) {
      return BigDecimal.valueOf(cell.getNumericCellValue());
    } else if (typeName.equals("String")) {
      if (cell.getCellTypeEnum() == CellType.NUMERIC) {
        long value = BigDecimal.valueOf(cell.getNumericCellValue()).longValue();
        return String.valueOf(value);
      }

      return cell.getStringCellValue();
    } else if (typeName.equals("Double")) {
      return cell.getNumericCellValue();
    } else if (typeName.equals("Date")) {
      return cell.getDateCellValue();
    } else if (typeName.equals("Boolean")) {
      return cell.getBooleanCellValue();
    } else {
      throw new IllegalArgumentException("invalid type");
    }
  }
}
