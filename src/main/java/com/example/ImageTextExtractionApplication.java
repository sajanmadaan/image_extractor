package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ImageTextExtractionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageTextExtractionApplication.class, args);
    }

    @Configuration
    @MapperScan("com.example.imageupload")
    public class MyBatisConfig {

    }

}
