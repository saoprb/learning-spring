package com.sao.spring.learning.hibernate.repository;

import com.sao.spring.learning.hibernate.entity.DomainIdentity2;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by saopr on 8/3/2017.
 */
public interface DomainIdentity2Repository extends CrudRepository<DomainIdentity2, Integer> {

    DomainIdentity2 findByUniqueKey(String uniqueKey);
}
