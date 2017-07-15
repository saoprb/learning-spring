package com.sao.spring.learning.hibernate.repository;

import com.sao.spring.learning.hibernate.entity.DomainIdentityType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by saopr on 7/15/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = {"test"})
@DataJpaTest
public class DomainIdentityTypeRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DomainIdentityTypeRepository domainIdentityTypeRepository;

    @Test
    public void testSaveThenFindAll() {
        DomainIdentityType trader = new DomainIdentityType();
        trader.setName("Traders");
        entityManager.persist(trader);

        DomainIdentityType deskHead = new DomainIdentityType();
        deskHead.setName("Desk-Head");
        entityManager.persist(deskHead);

        DomainIdentityType portfolio = new DomainIdentityType();
        portfolio.setName("Portfolio");
        entityManager.persist(portfolio);

        List<DomainIdentityType> identityTypeList = domainIdentityTypeRepository.findAll();
        identityTypeList.stream().forEach(System.out::println);
    }
}
