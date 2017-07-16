package com.sao.spring.learning.hibernate.repository;

import com.sao.spring.learning.hibernate.entity.DomainIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by saopr on 7/15/2017.
 */
public interface DomainIdentityReposiotry extends CrudRepository<DomainIdentity, Integer> {

    DomainIdentity findByUniqueKey(String uniqueKey);
}
