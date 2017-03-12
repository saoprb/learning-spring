package com.sao.spring.learning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by saoprb on 3/12/17.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return x -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            ApplicationProperties applicationProperties = ctx.getBean(ApplicationProperties.class);
            System.out.format("Application Name: %s%nApplication Version: %s%n", applicationProperties.getName(), applicationProperties.getVersion());

            GlobalProperties globalProperties = ctx.getBean(GlobalProperties.class);
            System.out.format("Global Email: %s%nGlobal Username: %s%n", globalProperties.getEmail(), globalProperties.getUsername());
        };
    }
}
