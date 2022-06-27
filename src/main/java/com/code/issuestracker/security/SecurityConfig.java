package com.code.issuestracker.security;

import com.code.issuestracker.filter.CustomAuthenticationFilter;
import com.code.issuestracker.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
        super.configure(auth);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        log.info("inside configure method before filters");
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        //CustomAuthorizationFilter customAuthorizationFilter = new CustomAuthorizationFilter();
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.cors().and().authorizeRequests().antMatchers("/api/login/**").permitAll();
        http.authorizeRequests().antMatchers( HttpMethod.GET , "/api/project/**").hasAnyAuthority("ROLE_ADMIN", "Role_SUPER_ADMIN")
        .antMatchers( HttpMethod.POST , "/api/project/**").hasAnyAuthority("ROLE_ADMIN", "Role_SUPER_ADMIN")
        .antMatchers( HttpMethod.PUT , "/api/project/**").hasAnyAuthority("ROLE_ADMIN", "Role_SUPER_ADMIN");

        http.authorizeRequests().antMatchers( HttpMethod.POST , "/api/issue/**").hasAnyAuthority("ROLE_ADMIN", "Role_SUPER_ADMIN")
        .antMatchers( HttpMethod.GET , "/api/issue/**").hasAnyAuthority("ROLE_ADMIN", "Role_SUPER_ADMIN")
        .antMatchers( HttpMethod.GET , "/api/issue/**").hasAnyAuthority("ROLE_ADMIN", "Role_SUPER_ADMIN");
        http.authorizeRequests().antMatchers( HttpMethod.GET , "/api/user/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user/save/**").hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
