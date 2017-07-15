package com.sao.spring.learning.hibernate.repository;

import com.sao.spring.learning.hibernate.entity.DomainIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by saopr on 7/15/2017.
 */
public interface DomainIdentityReposiotry extends JpaRepository<DomainIdentity, Integer>  {
}
