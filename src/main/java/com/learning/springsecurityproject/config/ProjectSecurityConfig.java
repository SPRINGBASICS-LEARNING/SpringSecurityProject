package com.learning.springsecurityproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                                    .antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                                    .antMatchers("/notices","contact").permitAll()
 //               .anyRequest().denyAll()
                                    .and().formLogin()
                                    .and().httpBasic();
//        http.formLogin();
//        http.httpBasic();
        return http.build();
    }
}
