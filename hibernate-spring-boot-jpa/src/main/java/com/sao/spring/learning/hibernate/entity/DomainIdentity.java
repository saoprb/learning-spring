package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by saopr on 7/15/2017.
 */
@Entity
@ToString
public class DomainIdentity implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    private String uniqueKey;

    @Getter
    @Setter
    @OneToOne()
    @JoinColumn(name = "id")
    private DomainIdentityType domainIdentityType;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "domain_hierarchy",
            joinColumns = @JoinColumn(name = "parent_identity_id"),
            inverseJoinColumns = @JoinColumn(name = "child_identity_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"parent_identity_id","child_identity_id"})
    )
    private Set<DomainIdentity> childDomainIdentities;
}
