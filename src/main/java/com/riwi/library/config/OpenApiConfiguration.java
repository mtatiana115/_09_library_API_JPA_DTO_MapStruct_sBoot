package com.riwi.library.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import 
io.swagger.v3.oas.annotations.info.Info
;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Api to manage Riwi's library",
        version = "1.0",
        description = "EndPoints documentation of Riwi's library application"
    )
)
public class OpenApiConfiguration {
    
} 
