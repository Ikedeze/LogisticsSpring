package com.example.logistics;

import com.example.logistics.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
@EnableMongoAuditing
public class LogisticsApplication {

private  final UserRepository userRepository;

// Spring will automatically inject your repository here

    public LogisticsApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // .username("logistics_admin")
    //                .password("SecurePass123")
    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class, args);
    }

    // Your root mapping
    @GetMapping("/")
    public String index() {
        return "Welcome to Logistics API";
    }
    @GetMapping("/api/public/test-users")
    public List<String> testUsers() {
        return userRepository.findAll().stream()
                .map(user -> user.getUsername())
                .toList();
    }


//    ALSO PLS CHANGE THIS REPOSITORY TO BE MORE DETAILED: https://github.com/Ikedeze/LogisticsSpring.git. WHAT I WANT YOU TO ADD IS THE SIGN IN PASSWORD AND USER, AND ALSO TO ADD THE URL OF RENDER: logisticsspring.onrender.com

}
