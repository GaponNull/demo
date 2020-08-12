package com.example.demo.controller;

import com.example.demo.dto.ExampleDto;
import com.example.demo.mapper.ExampleMapper;
import com.example.demo.service.ExampleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;
    private final ExampleMapper exampleMapper;

    @GetMapping("/examples")
    public List<ExampleDto> findAllExamples() {
        return exampleService.getAllExampleModels().stream()
                .map(exampleMapper::map)
                .collect(toList());
    }
}
