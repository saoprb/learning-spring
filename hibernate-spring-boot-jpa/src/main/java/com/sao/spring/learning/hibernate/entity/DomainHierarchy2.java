package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by saopr on 8/3/2017.
 */
@Entity
@ToString
public class DomainHierarchy2 implements Serializable {

    @Getter
    @Setter
    @EmbeddedId
    DomainHierarchy2PK id = new DomainHierarchy2PK();

    public DomainIdentity2 getParentIdentity() {
        return id.getParentIdentity();
    }

    public void setParentIdentity(DomainIdentity2 parentIdentity) {
        this.id.setParentIdentity(parentIdentity);
    }

    public DomainIdentity2 getChildIdentity() {
        return id.getChildIdentity();
    }

    public void setChildIdentity(DomainIdentity2 childIdentity) {
        this.id.setChildIdentity(childIdentity);
    }
}
