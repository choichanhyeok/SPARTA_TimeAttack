package com.oauth.securitytest.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests((requests) -> requests.antMatchers("/api/v1/member").permitAll()
                .anyRequest()
                .authenticated());
        http.httpBasic();
    }
}
