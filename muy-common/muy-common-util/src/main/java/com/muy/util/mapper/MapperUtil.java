package com.muy.util.mapper;

import com.muy.util.mapper.annotation.MapperProperty;
import com.muy.util.mapper.annotation.MapperSource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

/**
 * Created by yanglikai on 2018/5/21.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MapperUtil {
  private static final MapperFactory mapperFactory;

  static {
    mapperFactory = new DefaultMapperFactory.Builder().build();
  }

  public static <T> List<T> map(List source, Class<T> target) {
    Objects.requireNonNull(source, "source must be not null");

    List<T> list = new ArrayList<>(source.size());

    for (Object o : source) {
      T result = map(o, target);

      list.add(result);
    }

    return list;
  }

  public static <T> T map(Object source, Class<T> target) {
    Objects.requireNonNull(source, "source must be not null");

    MapperSource mapperSource = target.getAnnotation(MapperSource.class);
    Class sourceClass;
    if (mapperSource == null) {
      sourceClass = source.getClass();
    } else {
      sourceClass = mapperSource.value();
    }

    ClassMapBuilder classMapBuilder = mapperFactory.classMap(sourceClass, target);

    Field[] fields = target.getDeclaredFields();
    for (Field field : fields) {
      MapperProperty mapperProperty = field.getAnnotation(MapperProperty.class);
      if (mapperProperty == null) {
        continue;
      }

      for (String el : mapperProperty.value()) {
        if (findField(sourceClass, el) == null) {
          continue;
        }

        classMapBuilder.field(el, field.getName());
      }
    }

    classMapBuilder.byDefault().register();

    BoundMapperFacade mapperFacade = mapperFactory.getMapperFacade(sourceClass, target);
    T result = (T) mapperFacade.map(source);
    return result;
  }

  private static Field findField(Class clazz, String fieldName) {
    for (Field field : clazz.getDeclaredFields()) {
      if (field.getName().equals(fieldName)) {
        return field;
      }
    }

    return null;
  }
}
