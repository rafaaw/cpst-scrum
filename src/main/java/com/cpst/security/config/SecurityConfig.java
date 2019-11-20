package com.cpst.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.http.HttpServletResponse;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((req, resp, e) -> resp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers("/**/oauth/token").permitAll()
                .antMatchers("/**/swagger-ui.html").permitAll()
                .antMatchers("/**/swagger-resources/**", "/**/webjars/springfox-swagger-ui/**", "/**/v2/api-docs/**").permitAll()
                .and().authorizeRequests().anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("Cpst@123").authorities("ADMIN");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
