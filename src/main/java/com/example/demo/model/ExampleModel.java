package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ExampleModel {
    private UUID id;
    private String name;
}
