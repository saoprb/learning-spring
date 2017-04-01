package com.sao.spring.learning;


import com.sao.spring.learning.domain.Customer;
import com.sao.spring.learning.domain.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by saopr on 4/1/2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindByLastName() {
        Customer customer = new Customer("firstName", "lastName");
        entityManager.persist(customer);

        List<Customer> findByLastName = customerRepository.findByLastName("lastName");
        assertThat(findByLastName).extracting(Customer::getLastName).containsOnly(customer.getLastName());
    }
}
