package com.example.production_ready_features.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
