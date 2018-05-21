package com.muy.util.excel.config;

import com.muy.util.excel.annotation.ExportField;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by yanglikai on 2018/5/21.
 */
public class ExportConfig<T> {
  private OutputStream stream;
  private Class target;
  private List<ExportField> exportFields;
  private List<T> rows;

  public ExportConfig(Class target) {
    this.target = target;
    this.rows = new ArrayList<>();

    init();
  }

  public void init() {
    exportFields = new ArrayList<>();

    Field[] fields = target.getDeclaredFields();
    for (Field field : fields) {
      ExportField annotation = field.getAnnotation(ExportField.class);
      if (annotation == null) {
        continue;
      }

      exportFields.add(annotation);
    }
  }

  public ExportConfig config(OutputStream outputStream) {
    this.stream = outputStream;
    return this;
  }

  public ExportConfig config(List<T> rows) {
    this.rows = rows;
    return this;
  }

  public List<ExportField> fields() {
    return this.exportFields;
  }

  public List<T> rows() {
    return this.rows;
  }

  public OutputStream stream() {
    Objects.requireNonNull(stream, "InputStream must be not null");
    return stream;
  }

  public Class getTarget() {
    return target;
  }
}
