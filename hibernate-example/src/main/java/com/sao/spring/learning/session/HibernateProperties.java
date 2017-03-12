package com.sao.spring.learning.session;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "hibernate")
public class HibernateProperties {

    private String dialect;
    private String currentSessionContextClass;
    private Boolean showSql;

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getCurrentSessionContextClass() {
        return currentSessionContextClass;
    }

    public void setCurrentSessionContextClass(String currentSessionContextClass) {
        this.currentSessionContextClass = currentSessionContextClass;
    }

    public Boolean getShowSql() {
        return showSql;
    }

    public void setShowSql(Boolean showSql) {
        this.showSql = showSql;
    }
}
