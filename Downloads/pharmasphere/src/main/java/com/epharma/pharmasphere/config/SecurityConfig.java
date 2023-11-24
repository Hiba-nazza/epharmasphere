// package com.epharma.pharmasphere.config;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     // ... existing code ...

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/", "/home").permitAll()
//                 .antMatchers("/dashboard").authenticated() // Access to the dashboard requires authentication
//                 .anyRequest().authenticated()
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .permitAll();
//     }
// }

