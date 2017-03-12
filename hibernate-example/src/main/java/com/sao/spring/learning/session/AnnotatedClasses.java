package com.sao.spring.learning.session;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "session")
public class AnnotatedClasses {

    private Class<?>[] annotatedClasses;

    public Class<?>[] getAnnotatedClasses() {
        return annotatedClasses;
    }

    public void setAnnotatedClasses(Class<String>[] annotatedClasses) throws ClassNotFoundException {
        ArrayList<Class<?>> listClasses = Arrays.stream(annotatedClasses).map(annotatedClass -> {
            try {
                return Class.forName(annotatedClass.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toCollection(ArrayList<Class<?>>::new));
        this.annotatedClasses = listClasses.toArray(annotatedClasses);
    }
}
