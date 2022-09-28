package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.inMemoryAuthentication()
          .withUser("anil")
          .password("buddodu")
          .roles("ceo")
          .and()
        .withUser("hamrish")
          .password("baa")
          .roles("Anthakuminchi");
        
      
  }
  protected void configure(HttpSecurity http) throws Exception
  {
	  http.httpBasic().and()
	  .authorizeRequests().
	  antMatchers("/admin").hasRole("Anthakuminchi").
	  antMatchers("/user").hasAnyRole("Anthakuminchi","ceo").
	  antMatchers("/home").permitAll()
      .and()
      .headers().frameOptions().disable()
      .and()
      .cors().disable()
      .formLogin();
	  
  }
  
  @Bean
  public PasswordEncoder getPasswordEncoder() {
      return NoOpPasswordEncoder.getInstance();
  }



}
