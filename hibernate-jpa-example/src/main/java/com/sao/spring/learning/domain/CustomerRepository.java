package com.sao.spring.learning.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by saopr on 4/1/2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
