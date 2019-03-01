package com.msp.impulse;

import com.msp.impulse.nb.listener.ApplicationMessageReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude={MongoAutoConfiguration.class, DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.msp.impulse.*"})
@EnableMongoRepositories
public class ImpulseApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ImpulseApplication.class);
        application.addListeners(new ApplicationMessageReceiver());
        application.run(args);
       // SpringApplication.run(ImpulseApplication.class, args);
    }
}
