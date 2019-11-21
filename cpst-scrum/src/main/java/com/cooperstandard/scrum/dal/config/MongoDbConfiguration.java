package com.cooperstandard.scrum.dal.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoDbConfiguration extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI("mongodb+srv://cooper:VzcZVwDMzMet5t2U@cooperstandardscrum-e258a.mongodb.net/test?retryWrites=true&w=majority"));
    }

    @Override
    protected String getDatabaseName() {
        return "cooperstandardScrum";
    }
}
