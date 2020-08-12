package com.example.demo.service.impl;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.model.ExampleModel;
import com.example.demo.service.ExampleService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExampleServiceImplTest extends BaseIntegrationTest {

    @Autowired
    ExampleService exampleService;

    @Test
    void shouldReturnCorrectData() {
        List<ExampleModel> result = exampleService.getAllExampleModels();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(3);

        assertThat(result.get(0)).isNotNull();
        assertThat(result.get(0).getId()).isNotNull();
        assertThat(result.get(0).getName()).isEqualTo("name1");

        assertThat(result.get(1)).isNotNull();
        assertThat(result.get(1).getId()).isNotNull();
        assertThat(result.get(1).getName()).isEqualTo("name2");

        assertThat(result.get(2)).isNotNull();
        assertThat(result.get(2).getId()).isNotNull();
        assertThat(result.get(2).getName()).isEqualTo("name3");
    }

    @Test
    @Disabled("unit for testing failure test")
    void shouldFail() {
        assertThat(true).isFalse();
    }
}