package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by saopr on 7/16/2017.
 */
@Embeddable
public class DomainMappingPK implements Serializable {

    @Getter
    @Setter
    @Column(name = "parent_identity_id")
    private Integer parentId;

    @Getter
    @Setter
    @Column(name = "child_identity_id")
    private Integer childId;
}
