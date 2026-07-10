package com.example.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableMongoAuditing
public class LogisticsApplication {


    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui.html");
    }

    // Your root mapping
    @GetMapping("/")
    public String index() {
        return "Welcome to Logistics API";
    }



//    ALSO PLS CHANGE THIS REPOSITORY TO BE MORE DETAILED: https://github.com/Ikedeze/LogisticsSpring.git. WHAT I WANT YOU TO ADD IS THE SIGN IN PASSWORD AND USER, AND ALSO TO ADD THE URL OF RENDER: logisticsspring.onrender.com

}
