package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by saopr on 7/16/2017.
 */
@Entity
@ToString
public class DomainMapping implements Serializable {

    @Getter
    @Setter
    @EmbeddedId
    private DomainMappingPK domainMappingPK;

    public Integer getParentId() {
        return domainMappingPK.getParentId();
    }

    @Transient
    public void setParentId(Integer parentId) {
        domainMappingPK.setParentId(parentId);
    }

    public Integer getChildId() {
        return domainMappingPK.getChildId();
    }

    @Transient
    public void setChildId(Integer childId) {
        domainMappingPK.setChildId(childId);
    }
}
