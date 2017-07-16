package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by saopr on 7/15/2017.
 */

@Entity
@ToString
@NamedQueries({
        @NamedQuery(
                name = "DomainIdentityType.findByName",
                query = "select d_type from DomainIdentityType d_type where d_type.name = :name"
        )
})
public class DomainIdentityType implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    private String name;
}
