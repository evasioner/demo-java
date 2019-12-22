package com.example.demo.config;

import com.example.demo.services.MembersService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final MembersService membersService;
    private PasswordEncoder passwordEncoder;

    public WebSecurityConfig(final DataSource dataSource, MembersService membersService) {
        this.dataSource = dataSource;
        this.membersService = membersService;
    }


    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/css/**",
                "/js/**", "/img/**", "/lib/**",
                "/swagger-resources/**",
                "/swagger-ui.html**",
                "/webjars/**",
                "favicon.ico");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.formLogin().usernameParameter("username").passwordParameter("password");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        if (passwordEncoder == null) {
            passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
        return passwordEncoder;
    }
}