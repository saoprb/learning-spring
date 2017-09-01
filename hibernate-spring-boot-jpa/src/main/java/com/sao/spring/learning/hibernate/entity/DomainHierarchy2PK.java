package com.sao.spring.learning.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by saopr on 8/3/2017.
 */
@Embeddable
public class DomainHierarchy2PK implements Serializable {

    @Getter
    @Setter
    @ManyToOne
    private DomainIdentity2 parentIdentity;

    @Getter
    @Setter
    @ManyToOne
    private DomainIdentity2 childIdentity;

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainHierarchy2PK that = (DomainHierarchy2PK) o;

        if (parentIdentity != null ? !parentIdentity.equals(that.getParentIdentity()) : that.getParentIdentity() != null) return  false;
        return childIdentity != null ? childIdentity.equals(that.getChildIdentity()) : that.getChildIdentity() == null;
    }

    public int hashCode() {
        int result;
        result = (parentIdentity != null ? parentIdentity.hashCode() : 0);
        result = 31 * result + (childIdentity != null ? childIdentity.hashCode(): 0);
        return result;
    }
}
