package com.sao.spring.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.connect.TwitterServiceProvider;

/**
 * Created by saopr on 4/2/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    Configuration configuration;

    @Autowired
    TwitterServiceProvider serviceProvider;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public TwitterServiceProvider newBean(Configuration configuration) {
        return new TwitterServiceProvider(configuration.getAppId(), configuration.getAppSecret());
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            Twitter twitter = serviceProvider.getApi(configuration.getAccessToken(), configuration.getAccessTokenSecret());
            twitter.timelineOperations().getHomeTimeline()
                    .stream()
                    .map(tweet -> String.format("user: %s, tweet: %s", tweet.getFromUser(), tweet.getText()))
                    .forEach(logger::info);

//            Twitter twitterTemplate = new TwitterTemplate(configuration.getAppId(), configuration.getAppSecret(),
//                    configuration.getAccessToken(), configuration.getAccessTokenSecret());
//            twitterTemplate.timelineOperations().getHomeTimeline().stream().forEach(tweet -> logger.info(tweet.getText()));
        };
    }

}
