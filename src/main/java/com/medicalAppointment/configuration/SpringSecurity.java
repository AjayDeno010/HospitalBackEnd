package com.medicalAppointment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

@Configuration
public class SpringSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().authorizeHttpRequests((authorize)-> {
        authorize.requestMatchers(HttpMethod.POST,"/api/create").permitAll();
        authorize.requestMatchers(HttpMethod.POST,"/api/login").permitAll();
        authorize.requestMatchers(HttpMethod.POST,"/doctor/create").hasRole("ADMIN");
        authorize.anyRequest().authenticated();
            }).httpBasic(Customizer.withDefaults());

//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    httpSecurity.addFilterBefore(, UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();
}
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeHttpRequests((authorize) -> {
//                    authorize.requestMatchers(HttpMethod.POST, "/api/create").permitAll();
//                    authorize.anyRequest().authenticated();
//                }).httpBasic(Customizer.withDefaults());
//
//        return httpSecurity.build();
//    }

}
