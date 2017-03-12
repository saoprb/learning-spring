package com.sao.spring.learning;

import com.sao.spring.learning.domain.Company;
import com.sao.spring.learning.domain.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by saoprb on 3/12/17.
 */
@SpringBootApplication
@ComponentScan
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            Employee directEmployeeAnother = ctx.getBean("employeeAnother", Employee.class);
            directEmployeeAnother.setName("Employee Another");

            Employee directEmployeeAnotherOne = ctx.getBean("employeeAnotherOne", Employee.class);
            directEmployeeAnotherOne.setName("Employee Another One");

            Employee directEmployee = ctx.getBean("employee", Employee.class);
            directEmployee.setName("Employee");

            Company company = ctx.getBean(Company.class);
            company.setName("My Company");
            System.out.println(company.getName());

            Employee employee = company.getEmployee();
            System.out.println(employee.getName());

            Employee employeeAnother = company.getEmployeeAnother();
            System.out.println(employeeAnother.getName());

            Employee employeeAnotherOne = company.getEmployeeAnotherOne();
            System.out.println(employeeAnotherOne.getName());
        };
    }

//    @Bean
//    public Company company(ApplicationContext ctx) {
//        return new Company();
//    }

    @Bean
    @Qualifier("employeeAnother")
    Employee employeeAnother(ApplicationContext ctx) {
        return new Employee();
    }

    @Bean
    @Qualifier("employeeAnotherOne")
    Employee employeeAnotherOne(ApplicationContext ctx) {
        return new Employee();
    }
}
