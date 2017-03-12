package com.sao.spring.learning.dao;

import com.sao.spring.learning.domain.Person;
import com.sao.spring.learning.session.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private HibernateSessionFactory sessionFactory;

    @Autowired
    public PersonDAOImpl(HibernateSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person p) {
        Session session = sessionFactory.getObject().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(p);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Person> list() {
        Session session = sessionFactory.getObject().openSession();
        List<Person> list = session.createQuery("from Person").list();
        session.close();
        return list;
    }

    public HibernateSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(HibernateSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
