package com.example.demo.mapper;

import com.example.demo.dto.ExampleDto;
import com.example.demo.model.ExampleModel;
import org.springframework.stereotype.Component;

@Component
public class ExampleMapper {
    public ExampleDto map(ExampleModel exampleModel) {
        return ExampleDto.builder()
                .id(exampleModel.getId().toString())
                .name(exampleModel.getName())
                .build();
    }
}
