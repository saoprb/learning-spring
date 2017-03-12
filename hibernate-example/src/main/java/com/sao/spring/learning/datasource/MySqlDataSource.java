package com.sao.spring.learning.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "datasource")
public class MySqlDataSource extends org.apache.commons.dbcp.BasicDataSource {
}
