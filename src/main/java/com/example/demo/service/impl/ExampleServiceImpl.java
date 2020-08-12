package com.example.demo.service.impl;

import com.example.demo.model.ExampleModel;
import com.example.demo.service.ExampleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public List<ExampleModel> getAllExampleModels() {
        return asList(new ExampleModel(UUID.randomUUID(), "name1"), new ExampleModel(UUID.randomUUID(), "name2"),
                new ExampleModel(UUID.randomUUID(), "name3"));
    }
}
