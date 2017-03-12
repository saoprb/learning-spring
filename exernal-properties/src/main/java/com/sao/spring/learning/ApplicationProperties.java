package com.sao.spring.learning;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
