package com.rabobank.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author horman
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final String defaultCrossOrigin;

    public WebConfig(final @Value("${allowed.cross.origin}") String crossOriginValue) {
        this.defaultCrossOrigin = crossOriginValue;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToHandConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/game").allowedOrigins(defaultCrossOrigin);
    }
}
