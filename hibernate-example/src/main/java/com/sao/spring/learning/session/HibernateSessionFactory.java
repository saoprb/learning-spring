package com.sao.spring.learning.session;

import com.sao.spring.learning.datasource.MySqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "session")
public class HibernateSessionFactory extends LocalSessionFactoryBean {

    @Autowired
    public HibernateSessionFactory(MySqlDataSource mySqlDataSource, Properties hibernateProperties, AnnotatedClasses annotatedClasses) {
        this.setDataSource(mySqlDataSource);
        this.setAnnotatedClasses(annotatedClasses.getAnnotatedClasses());
        this.setHibernateProperties(hibernateProperties);
    }
}
