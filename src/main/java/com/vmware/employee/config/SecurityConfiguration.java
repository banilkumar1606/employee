package com.vmware.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vmware.employee.constants.EmployeeConstants;

/**
 * The Class SecurityConfiguration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MdcFilter filter;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("pass")).roles(EmployeeConstants.USER).and()
				.withUser("admin").password(encoder.encode("vmware")).roles(EmployeeConstants.ADMIN);
	}

	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		/*http.authorizeRequests().antMatchers(EmployeeConstants.EMPLOYEES).hasRole(EmployeeConstants.ADMIN).and().httpBasic();
		http.authorizeRequests().antMatchers(EmployeeConstants.EMPLOYEES_ID).hasRole(EmployeeConstants.ADMIN).and().httpBasic();
		http.authorizeRequests().antMatchers(EmployeeConstants.STATUS_TRANSACTIONID).hasRole(EmployeeConstants.ADMIN).and().httpBasic();*/
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		
	}

}
