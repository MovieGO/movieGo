package com.movieGo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.movieGo.service.UserService;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetailsService userDetailsServiceBean() {
		return userService;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
	}
	
	@Bean
    public TokenBasedRememberMeServices rememberMeService() {
        return new TokenBasedRememberMeServices("rememberMe", userService);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/signup").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated() 
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.loginProcessingUrl("/authenticate")
				.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll()
				.logoutSuccessUrl("/login?logout")
				.and()
				.rememberMe()
                .rememberMeServices(rememberMeService())
                .key("rememberMe")
			;
		http
		 	.csrf().disable();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
		;
    }
	
}
