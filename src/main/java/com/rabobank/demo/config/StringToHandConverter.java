package com.rabobank.demo.config;

import com.rabobank.demo.model.Hand;
import org.springframework.core.convert.converter.Converter;

/**
 * @author horman
 */
public class StringToHandConverter implements Converter<String, Hand> {
    @Override
    public Hand convert(String value) {
        return Hand.valueOf(value.toUpperCase());
    }
}
