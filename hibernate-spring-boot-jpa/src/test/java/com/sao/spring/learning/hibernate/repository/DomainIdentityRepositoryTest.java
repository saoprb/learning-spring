package com.sao.spring.learning.hibernate.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sao.spring.learning.hibernate.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by saopr on 7/15/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = {"test"})
@DataJpaTest
public class DomainIdentityRepositoryTest {

    private final String jsonDomainIdentityType = "[{\"name\":\"Trader\"},{\"name\":\"Desk-Head\"},{\"name\":\"Portfolio\"}]";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DomainIdentityTypeRepository domainIdentityTypeRepository;

    @Autowired
    private DomainIdentityRepository domainIdentityRepository;

    @Autowired
    private DomainIdentity2Repository domainIdentity2Repository;

/*
    @Before
    public void before() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DomainIdentityType[] identityTypeList = objectMapper.readValue(jsonDomainIdentityType, DomainIdentityType[].class);
        Arrays.asList(identityTypeList).forEach(entityManager::persist);
    }

    @Ignore
    @Test
    public void testSaveThenFindAll() throws JsonProcessingException {
        List<DomainIdentityType> identityTypeList = domainIdentityTypeRepository.findAll();
        identityTypeList.stream().forEach(System.out::println);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(identityTypeList));
    }
*/
    @Test
    public void testWithEntityManager() {
        DomainIdentityType trader = new DomainIdentityType();
        trader.setName("Trader");
        entityManager.persist(trader);

        Query query = entityManager.createNamedQuery("DomainIdentityType.findByName");
        query.setParameter("name","Trader");

        List<DomainIdentityType> traderList = query.getResultList();
        Optional<DomainIdentityType> optional = traderList.stream().findFirst();
        DomainIdentityType traderRet = optional.get();

        assertThat(traderRet.getName(), is("Trader"));
    }

    @Test
    public void test() throws JsonProcessingException {
        DomainIdentityType trader = new DomainIdentityType();
        trader.setName("Trader");
        trader = domainIdentityTypeRepository.save(trader);

        DomainIdentityType deskHead = new DomainIdentityType();
        deskHead.setName("Desk-Head");
        deskHead = domainIdentityTypeRepository.save(deskHead);

        DomainIdentityType portfolio = new DomainIdentityType();
        portfolio.setName("Portfolio");
        portfolio = domainIdentityTypeRepository.save(portfolio);

        DomainIdentity trader01 = new DomainIdentity();
        trader01.setUniqueKey("Trader 01");
        trader01.setDomainIdentityType(trader);
        trader01 = domainIdentityRepository.save(trader01);

        DomainIdentity trader02 = new DomainIdentity();
        trader02.setUniqueKey("Trader 02");
        trader02.setDomainIdentityType(trader);
        trader02 = domainIdentityRepository.save(trader02);

        DomainIdentity trader03 = new DomainIdentity();
        trader03.setUniqueKey("Trader 03");
        trader03.setDomainIdentityType(trader);
        trader03 = domainIdentityRepository.save(trader03);

        DomainIdentity deskHead01 = new DomainIdentity();
        deskHead01.setUniqueKey("Desk-Head 01");
        deskHead01.setDomainIdentityType(deskHead);
        deskHead01 = domainIdentityRepository.save(deskHead01);

        DomainIdentity deskHead02 = new DomainIdentity();
        deskHead02.setUniqueKey("Desk-Head 02");
        deskHead02.setDomainIdentityType(deskHead);
        deskHead02 = domainIdentityRepository.save(deskHead02);

        DomainIdentity deskHead03 = new DomainIdentity();
        deskHead03.setUniqueKey("Desk-Head 03");
        deskHead03.setDomainIdentityType(deskHead);
        deskHead03 = domainIdentityRepository.save(deskHead03);

        DomainIdentity portfolio01 = new DomainIdentity();
        portfolio01.setUniqueKey("Portfolio 01");
        portfolio01.setDomainIdentityType(portfolio);

        Set<DomainIdentity> childIdentities01 = new HashSet<>();
        childIdentities01.add(trader01);
        childIdentities01.add(trader02);
        childIdentities01.add(deskHead01);
        portfolio01.setChildDomainIdentities(childIdentities01);

        portfolio01 = domainIdentityRepository.save(portfolio01);

        DomainIdentity portfolio01Ret = domainIdentityRepository.findByUniqueKey("Portfolio 01");

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("WRITE TO JSON: " + objectMapper.writeValueAsString(portfolio01Ret));

        DomainIdentity portfolio02 = new DomainIdentity();
        portfolio02.setUniqueKey("Portfolio 02");
        portfolio02.setDomainIdentityType(portfolio);
        portfolio02 = domainIdentityRepository.save(portfolio02);

        DomainIdentity portfolio03 = new DomainIdentity();
        portfolio03.setUniqueKey("Portfolio 03");
        portfolio03.setDomainIdentityType(portfolio);
        portfolio03 = domainIdentityRepository.save(portfolio03);

        Query query = entityManager.createNativeQuery("select * from domain_hierarchy", DomainMapping.class);
        List<DomainMapping> list = query.getResultList();
        list.stream().forEach(System.out::println);

        System.out.println("WRITE TO JSON: " + objectMapper.writeValueAsString(list));

        DomainIdentity portfolio01_Dup = new DomainIdentity();
        portfolio01_Dup.setUniqueKey("Portfolio 01");
        portfolio01_Dup.setDomainIdentityType(portfolio);

        childIdentities01 = new HashSet<>();
        childIdentities01.add(trader01);

        portfolio01_Dup.setChildDomainIdentities(childIdentities01);

        portfolio01 = domainIdentityRepository.save(portfolio01);
        System.out.println("WRITE TO JSON: " + objectMapper.writeValueAsString(portfolio01));
    }

    @Test
    public void test1() throws JsonProcessingException {
        DomainIdentityType trader = new DomainIdentityType();
        trader.setName("Trader");
        trader = domainIdentityTypeRepository.save(trader);

        DomainIdentityType deskHead = new DomainIdentityType();
        deskHead.setName("Desk-Head");
        deskHead = domainIdentityTypeRepository.save(deskHead);

        DomainIdentityType portfolio = new DomainIdentityType();
        portfolio.setName("Portfolio");
        portfolio = domainIdentityTypeRepository.save(portfolio);

        DomainIdentity2 trader01 = new DomainIdentity2();
        trader01.setUniqueKey("Trader 01");
        trader01.setDomainIdentityType(trader);
        trader01 = domainIdentity2Repository.save(trader01);

        DomainIdentity2 trader02 = new DomainIdentity2();
        trader02.setUniqueKey("Trader 02");
        trader02.setDomainIdentityType(trader);
        trader02 = domainIdentity2Repository.save(trader02);

        DomainIdentity2 trader03 = new DomainIdentity2();
        trader03.setUniqueKey("Trader 03");
        trader03.setDomainIdentityType(trader);
        trader03 = domainIdentity2Repository.save(trader03);

        DomainIdentity2 deskHead01 = new DomainIdentity2();
        deskHead01.setUniqueKey("Desk-Head 01");
        deskHead01.setDomainIdentityType(deskHead);
        deskHead01 = domainIdentity2Repository.save(deskHead01);

        DomainIdentity2 deskHead02 = new DomainIdentity2();
        deskHead02.setUniqueKey("Desk-Head 02");
        deskHead02.setDomainIdentityType(deskHead);
        deskHead02 = domainIdentity2Repository.save(deskHead02);

        DomainIdentity2 deskHead03 = new DomainIdentity2();
        deskHead03.setUniqueKey("Desk-Head 03");
        deskHead03.setDomainIdentityType(deskHead);
        deskHead03 = domainIdentity2Repository.save(deskHead03);

        DomainIdentity2 portfolio01 = new DomainIdentity2();
        portfolio01.setUniqueKey("Portfolio 01");
        portfolio01.setDomainIdentityType(portfolio);

        Set<DomainHierarchy2> childIdentities01 = new HashSet<>();
        childIdentities01.add(createDomainHierarchy2(portfolio01, trader01));
        childIdentities01.add(createDomainHierarchy2(portfolio01, deskHead01));
        portfolio01.setChildDomainIdentities(childIdentities01);

        portfolio01 = domainIdentity2Repository.save(portfolio01);

        DomainIdentity2 portfolio01Ret = domainIdentity2Repository.findByUniqueKey("Portfolio 01");

        System.out.println(portfolio01Ret);

        DomainIdentity2 portfolio02 = new DomainIdentity2();
        portfolio02.setUniqueKey("Portfolio 02");
        portfolio02.setDomainIdentityType(portfolio);
        portfolio02 = domainIdentity2Repository.save(portfolio02);

        DomainIdentity2 portfolio03 = new DomainIdentity2();
        portfolio03.setUniqueKey("Portfolio 03");
        portfolio03.setDomainIdentityType(portfolio);
        portfolio03 = domainIdentity2Repository.save(portfolio03);

        Query query = entityManager.createNativeQuery("select * from domain_hierarchy2", DomainMapping.class);
        List<DomainMapping> list = query.getResultList();
        list.stream().forEach(System.out::println);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("WRITE TO JSON: " + objectMapper.writeValueAsString(list));

        DomainIdentity2 portfolio01_Dup = domainIdentity2Repository.findByUniqueKey("Portfolio 01");
        portfolio01_Dup.setUniqueKey("Portfolio 01");
        portfolio01_Dup.setDomainIdentityType(portfolio);

        childIdentities01 = new HashSet<>();
        childIdentities01.add(createDomainHierarchy2(portfolio01_Dup,trader01));
        childIdentities01.add(createDomainHierarchy2(portfolio01_Dup,deskHead02));
        portfolio01_Dup.setChildDomainIdentities(childIdentities01);

        portfolio01_Dup = domainIdentity2Repository.save(portfolio01_Dup);

        DomainIdentity2 portfolio01Ret_Dup = domainIdentity2Repository.findByUniqueKey("Portfolio 01");

        System.out.println(portfolio01Ret_Dup);

        query = entityManager.createNativeQuery("select * from domain_hierarchy2", DomainMapping.class);
        list = query.getResultList();
        list.stream().forEach(System.out::println);

        System.out.println("WRITE TO JSON: " + objectMapper.writeValueAsString(list));
    }

    private DomainHierarchy2 createDomainHierarchy2(DomainIdentity2 parent, DomainIdentity2 child) {
        DomainHierarchy2 link = new DomainHierarchy2();
        link.setParentIdentity(parent);
        link.setChildIdentity(child);
        return link;
    }
}
