package com.zaloni.hackathon.zaloniautometadata.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperService {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
