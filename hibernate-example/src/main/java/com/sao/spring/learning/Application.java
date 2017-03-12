package com.sao.spring.learning;

import com.sao.spring.learning.dao.PersonDAO;
import com.sao.spring.learning.datasource.MySqlDataSource;
import com.sao.spring.learning.domain.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Connection;
import java.util.List;

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
          System.out.println("Hello World");

          MySqlDataSource mySqlDataSource = ctx.getBean(MySqlDataSource.class);
          Connection connection = mySqlDataSource.getConnection();
          connection.close();

          PersonDAO personDAO = ctx.getBean(PersonDAO.class);
          List<Person> persons = personDAO.list();

          persons.stream().forEach(System.out::println);
        };
    }
}
