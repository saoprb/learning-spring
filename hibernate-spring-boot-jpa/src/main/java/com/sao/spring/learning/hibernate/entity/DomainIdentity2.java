package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by saopr on 8/3/2017.
 */
@Entity
@ToString
public class DomainIdentity2 implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @Column(updatable = false)
    private String uniqueKey;

    @Getter
    @Setter
    @OneToOne()
    @JoinColumn(name = "id", updatable = false)
    private DomainIdentityType domainIdentityType;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.parentIdentity", cascade = CascadeType.ALL)
    private Set<DomainHierarchy2> parentDomainIdentities;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.childIdentity", cascade = CascadeType.ALL)
    private Set<DomainHierarchy2> childDomainIdentities;
}
