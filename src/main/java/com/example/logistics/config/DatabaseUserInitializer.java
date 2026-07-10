package com.example.logistics.config;

import com.example.logistics.user.User;
import com.example.logistics.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

// Startup component that runs immediately after the application boots up.
// Checks MongoDB Atlas for default admin accounts and automatically seeds them
// if they do not already exist.
@Component
public class DatabaseUserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseUserInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Executes the initial database check and uses the password encoder
     * to safely insert the 'logistics_admin' and 'sibling_admin' user credentials.
     */
    @Override
    public void run(String... args) throws Exception {
        // First Admin
        if (userRepository.findByUsername("logistics_admin")
                .isEmpty()) {
            User admin1 = new User();
            admin1.setUsername("logistics_admin");
            admin1.setPassword(passwordEncoder.encode(
                    "SecurePass123"
            ));
            admin1.setRoles(Set.of("ROLE_ADMIN"));
            userRepository.save(admin1);
            System.out.println("---> Persistent Admin 1 Created!");
        }

        // Second Admin
        if (userRepository.findByUsername("sibling_admin")
                .isEmpty()){
            User admin2 = new User();
            admin2.setUsername("sibling_admin");
            admin2.setPassword(passwordEncoder.encode(
                    "SibPass456"
            ));
            admin2.setRoles(Set.of("ROLE_ADMIN"));
            userRepository.save(admin2);
            System.out.println("--> Persistent Admin 2 Created!");
        }

    }
}
