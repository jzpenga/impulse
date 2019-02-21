package com.msp.impulse.configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class MongoConfig {
    // 注入配置实体
    @Autowired
    private MongodbProperties mongodbProperties;
    @Bean
    @ConfigurationProperties(
            prefix = "spring.data.mongodb.custom")
    MongodbProperties mongodbProperties() {
        return new MongodbProperties();
    }

    // 覆盖默认的MongoDbFactory
    @Bean
    MongoDbFactory mongoDbFactory() {
        //客户端配置（连接数、副本集群验证）
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(mongodbProperties.getConnectionsPerHost());
        builder.minConnectionsPerHost(mongodbProperties.getMinConnectionsPerHost());
        if (mongodbProperties.getReplicaSet() != null) {
            builder.requiredReplicaSetName(mongodbProperties.getReplicaSet());
        }
        MongoClientOptions mongoClientOptions = builder.build();


        // MongoDB地址列表
        List<ServerAddress> serverAddresses = new ArrayList<>();
        for (String host : mongodbProperties.getHosts()) {
            Integer index = mongodbProperties.getHosts().indexOf(host);
            Integer port = mongodbProperties.getPorts().get(index);


            ServerAddress serverAddress = new ServerAddress(host, port);
            serverAddresses.add(serverAddress);
        }
        System.out.println("serverAddresses:" + serverAddresses.toString());


        // 连接认证
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        if (mongodbProperties.getUsername() != null) {
            mongoCredentialList.add(MongoCredential.createScramSha1Credential(
                    mongodbProperties.getUsername(),
                    mongodbProperties.getAuthenticationDatabase() != null ? mongodbProperties.getAuthenticationDatabase() : mongodbProperties.getDatabase(),
                    mongodbProperties.getPassword().toCharArray()));
        }
        System.out.println("mongoCredentialList:" + mongoCredentialList.toString());


        //创建客户端和Factory
        MongoClient mongoClient = new MongoClient(serverAddresses, mongoCredentialList, mongoClientOptions);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, mongodbProperties.getDatabase());


        return mongoDbFactory;
    }
}