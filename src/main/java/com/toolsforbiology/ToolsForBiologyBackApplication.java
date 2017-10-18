package com.toolsforbiology;

import com.toolsforbiology.configuration.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableConfigurationProperties({SecurityProperties.class})
public class ToolsForBiologyBackApplication {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplication(ToolsForBiologyBackApplication.class).run(args);
    }
}
