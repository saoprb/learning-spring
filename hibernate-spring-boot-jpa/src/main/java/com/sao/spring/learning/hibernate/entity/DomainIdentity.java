package com.sao.spring.learning.hibernate.entity;

import lombok.ToString;

import javax.persistence.*;

/**
 * Created by saopr on 7/15/2017.
 */
@Entity
@ToString
public class DomainIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String uniqueKey;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private DomainIdentityType domainIdentityType;

}
