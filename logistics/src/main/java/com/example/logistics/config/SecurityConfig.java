package com.example.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception{
        http
            .csrf(csrf -> csrf.disable())
            // <- Disable CSRF for stateless API usage
            .authorizeHttpRequests(auth -> auth
                    // Allow public access to Swagger documentation UI
                            .requestMatchers("/v3/api-docs/**",
                                    "/swagger-ui/**", "/swagger-ui.html").permitAll()

            // Allow anyone to check a tracking number status)
                    .requestMatchers(HttpMethod.GET,
                            "/shipments/stats")
                            .authenticated()
                    // Lock down creation and aggregation stats to authenticated users
                    .requestMatchers(HttpMethod.POST, "/shipments")
                    .authenticated()

                            .requestMatchers(HttpMethod.GET,
                                    "/shipments/**")
                            .permitAll()

                            .anyRequest().authenticated()
            )
                // Use simple Basic Auth for now ->
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
   public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
