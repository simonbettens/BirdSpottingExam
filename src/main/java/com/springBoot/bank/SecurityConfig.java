package com.springBoot.bank;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

		//NoOpPasswordEncoder
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	                .inMemoryAuthentication()
	                .withUser("spotter").password("{noop}RedDuck007").roles("SPOTTER").and()
	                .withUser("admin").password("{noop}eagle").roles("SPOTTER", "ADMIN");
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        
	        http
	                .authorizeRequests()
	                .antMatchers("/403*").permitAll()
	                .antMatchers("/birds-spotted/**").permitAll()
	                .antMatchers("/**/**/newbirdspotting").hasRole("ADMIN")
	                .antMatchers("/**").hasRole("SPOTTER");
	        
	        http.formLogin().defaultSuccessUrl("/birdspotting", true).loginPage("/login").permitAll()
	        .usernameParameter("username").passwordParameter("password").and()
	        .exceptionHandling().accessDeniedPage("/403").and().csrf();
	        
	        http.logout().permitAll();
	    }
}
