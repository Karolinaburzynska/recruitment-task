package com.example.task;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {
    @Bean
    public GroupedOpenApi api() {
        String[] packagesToScan = {"com.example.task"};
        return GroupedOpenApi.builder()
                .packagesToScan(packagesToScan)
                .group("api")
                .build();
    }
}
