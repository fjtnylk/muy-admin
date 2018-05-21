package com.muy.util.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by yanglikai on 2018/5/21.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class XmlUtil {
  private static final XmlMapper OBJECT_MAPPER = new XmlMapper();

  public static String toXml(Object object) {
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T toBean(String xml, Class<T> clazz) {
    try {
      return OBJECT_MAPPER.readValue(xml, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  static {
    OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
  }
}
