package com.jsf.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().anonymous();
		http.authorizeRequests().antMatchers("/secure/**").permitAll().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedPage("/error/accessdenied.xhtml");
		http.formLogin().loginPage("/public/login.xhtml").permitAll().failureUrl("/public/login.xhtml?error=true").defaultSuccessUrl("/");
		http.logout().logoutSuccessUrl("/");
		http.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/javax.faces.resource/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
	}
	
}