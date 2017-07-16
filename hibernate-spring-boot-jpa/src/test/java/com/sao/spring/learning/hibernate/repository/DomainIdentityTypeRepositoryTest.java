package com.sao.spring.learning.hibernate.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sao.spring.learning.hibernate.entity.DomainIdentityType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by saopr on 7/15/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(value = {"test"})
@DataJpaTest
public class DomainIdentityTypeRepositoryTest {

    private final String jsonDomainIdentityType = "[{\"name\":\"Traders\"},{\"name\":\"Desk-Head\"},{\"name\":\"Portfolio\"}]";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DomainIdentityTypeRepository domainIdentityTypeRepository;

    @Before
    public void before() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DomainIdentityType[] identityTypeList = objectMapper.readValue(jsonDomainIdentityType, DomainIdentityType[].class);
        Arrays.asList(identityTypeList).forEach(entityManager::persist);
    }

    @Test
    public void testSaveThenFindAll() throws JsonProcessingException {
        List<DomainIdentityType> identityTypeList = domainIdentityTypeRepository.findAll();
        identityTypeList.stream().forEach(System.out::println);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(identityTypeList));
    }
}
