package com.sao.spring.learning.hibernate.repository;

import com.sao.spring.learning.hibernate.entity.DomainIdentityType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saopr on 7/15/2017.
 */
public interface DomainIdentityTypeRepository extends JpaRepository<DomainIdentityType, Integer>  {
}
