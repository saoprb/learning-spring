package com.sao.spring.learning.dao;

import com.sao.spring.learning.domain.Person;

import java.util.List;

/**
 * Created by saoprb on 3/12/17.
 */
public interface PersonDAO {

    void save(Person p);

    List<Person> list();
}
