package com.sao.spring.learning.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
public class Company {

    private String name;

    private Employee employee;

    @Autowired
    @Qualifier("employeeAnother")
    private Employee employeeAnother;

    @Autowired
    @Qualifier("employeeAnotherOne")
    private Employee employeeAnotherOne;

    @Autowired
    public Company(Employee employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployeeAnother() {
        return employeeAnother;
    }

    public void setEmployeeAnother(Employee employeeAnother) {
        this.employeeAnother = employeeAnother;
    }

    public Employee getEmployeeAnotherOne() {
        return employeeAnotherOne;
    }

    public void setEmployeeAnotherOne(Employee employeeAnotherOne) {
        this.employeeAnotherOne = employeeAnotherOne;
    }
}
