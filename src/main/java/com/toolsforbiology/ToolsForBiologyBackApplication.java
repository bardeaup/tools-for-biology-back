package com.toolsforbiology;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ToolsForBiologyBackApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplication(ToolsForBiologyBackApplication.class).run(args);
    }
}
