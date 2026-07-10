package com.example.logistics.config;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)
//        throws Exception{
//        http
//            .csrf(csrf -> csrf.disable())
//
//                .authorizeHttpRequests(auth -> auth
//                                // ADD THIS LINE RIGHT HERE:
//                                .requestMatchers("/api/public/**").permitAll()
//
//                                // This keeps the rest of your logistics endpoints secure
//                                .anyRequest().authenticated()
////            // <- Disable CSRF for stateless API usage
////            .authorizeHttpRequests(auth -> auth
////                    // Allow public access to Swagger documentation UI
////                            .requestMatchers("/v3/api-docs/**",
////                                    "/swagger-ui/**", "/swagger-ui.html").permitAll()
////
////            // Allow anyone to check a tracking number status)
////                    .requestMatchers(HttpMethod.GET,
////                            "/shipments/stats")
////                            .authenticated()
////                    // Lock down creation and aggregation stats to authenticated users
////                    .requestMatchers(HttpMethod.POST, "/shipments")
////                    .authenticated()
////
////                            .requestMatchers(HttpMethod.GET,
////                                    "/shipments/**")
////                            .permitAll()
////
////                            .anyRequest().authenticated()
////            )
//                // Use simple Basic Auth for now ->
////                .httpBasic(Customizer.withDefaults()
//                );
//
//        return http.build();
//    }
//
//    @Bean
//   public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
