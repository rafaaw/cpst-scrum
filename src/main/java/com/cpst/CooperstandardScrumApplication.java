package com.cpst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@EnableEurekaServer
@SpringBootApplication
public class CooperstandardScrumApplication {

    public static void main(String[] args) {
        SpringApplication.run(CooperstandardScrumApplication.class, args);
    }

}
