package fr.campusacad.wsappli2;


import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@SpringBootApplication
public class Wsappli2Application {



    public static void main(String[] args) throws UnknownHostException {

        SpringApplication.run(Wsappli2Application.class, args);
    }

}
