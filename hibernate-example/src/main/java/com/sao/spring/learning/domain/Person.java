package com.sao.spring.learning.domain;

import javax.persistence.*;

/**
 * Created by saoprb on 3/12/17.
 */
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append("Person row: ")
                .append("id=").append(id)
                .append(", name=").append(name)
                .append(", country=").append(country)
                .toString();
    }
}
