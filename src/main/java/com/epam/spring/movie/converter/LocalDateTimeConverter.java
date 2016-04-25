package com.epam.spring.movie.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public final class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private final DateTimeFormatter formatter;
    
    public LocalDateTimeConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }
 
    @Override
    public LocalDateTime convert(String source) {
    	
        if (source == null || source.isEmpty()) {
            return null;
        }
        
        System.out.println("val: " + LocalDateTime.parse(source, formatter));
 
        return LocalDateTime.parse(source, formatter);
    }

}