package com.muy.util.excel.config;

import com.muy.util.excel.annotation.ExportField;
import com.muy.util.excel.annotation.ImportField;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;

/**
 * Created by yanglikai on 2018/5/21.
 */
public class ExcelConfig {
  private ImportConfig importConfig;
  private ExportConfig exportConfig;
  private Class target;

  private ExcelConfig() {
  }

  public static ExcelConfig create() {
    return new ExcelConfig();
  }

  public ExcelConfig config(Class target) {
    this.target = target;
    return this;
  }

  public ExcelConfig config(ImportConfig importConfig) {
    this.importConfig = importConfig;
    return this;
  }

  public ExcelConfig config(ExportConfig exportConfig) {
    this.exportConfig = exportConfig;
    return this;
  }

  public InputStream inputStream() {
    return this.importConfig.stream();
  }

  public OutputStream outputStream() {
    return this.exportConfig.stream();
  }

  public ImportField importField(int index) {
    return this.importConfig.field(index);
  }

  public List<ExportField> exportFields() {
    return this.exportConfig.fields();
  }

  public List<Object> exportRows() {
    return this.exportConfig.rows();
  }

  public Class getTarget() {
    Objects.requireNonNull(target, "target class must be not null");
    return target;
  }
}
