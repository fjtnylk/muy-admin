package com.muy.util.converter;

/**
 * Created by yanglikai on 2018/6/1.
 */
public interface Converter<I, O> {

  O convert(I source);
}
