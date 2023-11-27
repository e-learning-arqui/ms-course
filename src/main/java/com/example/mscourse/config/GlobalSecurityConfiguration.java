package com.example.mscourse.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {
    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    public GlobalSecurityConfiguration(TokenConverterProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter
                = new KeycloakJwtTokenConverter(
                jwtGrantedAuthoritiesConverter,
                properties);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) -> {
            authorizeHttpRequests
                    .requestMatchers(HttpMethod.POST, "api/v1/courses/{id}/sections").hasRole("CREATE-COURSES")
                    .requestMatchers(HttpMethod.GET, "api/v1/courses/{id}/sections").authenticated()
                    .requestMatchers("/api/v1/sections/{id}/status").hasRole("CREATE-COURSES")
                    .requestMatchers("/api/v1/users/student/{userId}/subscription").hasRole("VIEW-COURSES")
                    .requestMatchers(HttpMethod.POST,"api/v1/courses/classes/{id}/files").hasRole("CREATE-COURSES")
                    .requestMatchers(HttpMethod.POST,"/api/v1/courses/sections/{id}/classes").hasRole("CREATE-COURSES")
                    .requestMatchers("api/v1/courses/students/{keycloakId}").hasRole("VIEW-CONTENT")

                    .requestMatchers("/api/v1/category/**").permitAll()
                    .requestMatchers("/api/v1/courses").permitAll()
                    .requestMatchers("/api/v1/courses/{id}").permitAll()
                    .requestMatchers("/api/v1/courses/{courseId}/**").permitAll()


                    .anyRequest().denyAll();
                    //.requestMatchers("/**").permitAll();
            //.anyRequest().permitAll();
        });
        http.oauth2ResourceServer((oauth2) -> {
            oauth2.jwt((jwt) -> jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter));
        });
        http.csrf(AbstractHttpConfigurer::disable);
        http.cors(withDefaults());
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}

