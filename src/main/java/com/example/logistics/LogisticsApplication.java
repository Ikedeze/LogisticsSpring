package com.example.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class LogisticsApplication {

//    @Bean
//    public org.springframework.boot.CommandLineRunner checkConnection(org.springframework.data.mongodb.core.MongoTemplate mongoTemplate) {
//        return args -> {
//            System.out.println("--------------------------------------------------");
//            System.out.println("CONNECTED TO DATABASE NAME: " + mongoTemplate.getDb().getName());
//            System.out.println("TOTAL SHIPMENTS FOUND: " + mongoTemplate.getCollection("shipment").countDocuments());
//            System.out.println("Tap this link: http://localhost:8080/swagger-ui.html");
//            System.out.println("--------------------------------------------------");
//        };
//    }
    // .username("logistics_admin")
    //                .password("SecurePass123")
    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class, args);
    }
//    @Bean
//    public MongoClient mongoClient() {
//        // This explicitly forces Spring Boot's internal auto-configuration to use you cloud cluster!
//        return MongoClients.create("mongodb+srv://ikechuudeze14_db_user:bojXpLtDxEPzWE6M@cluster0.6wdjyen.mongodb.net/logistics?appName=Cluster0");
//    }

}
