package com.better.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "documents.folder")
public class ConfigProperties {

    private String input;
    private String output;
    private String error;
    private int interval;

}