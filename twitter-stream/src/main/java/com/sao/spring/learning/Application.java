package com.sao.spring.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Created by saopr on 4/2/2017.
 */
@SpringBootApplication
@ComponentScan
    public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    public static final String CONSUMER_KEY = "{removed}";
    public static final String CONSUMER_SECRET = "{removed}";
    public static final String ACCESS_TOKEN = "{removed}";
    public static final String ACCESS_TOKEN_SECRET = "{removed}";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            Twitter twitter = new TwitterTemplate(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
            twitter.timelineOperations().getHomeTimeline().stream().forEach(tweet -> logger.info(tweet.getText()));
        };
    }

}
