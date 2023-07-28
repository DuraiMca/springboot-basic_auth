package com.springbootsec.project.springbootsecurityproj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
   public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

   @Bean
     SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()).authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->authorizationManagerRequestMatcherRegistry.anyRequest().authenticated() ).httpBasic(Customizer.withDefaults() );
    return httpSecurity.build();
     }
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("murugan")
                .password(passwordEncoder().encode("murugan"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("durai")
                .password(passwordEncoder().encode("durai"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
