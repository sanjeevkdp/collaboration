/*package com.niit.backend.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;




@Configuration
@EnableWebSecurity
public class LoginConfigure extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
    @Autowired
	public void cofigureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
		.jdbcAuthentication().dataSource(dataSource)				
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?")
		.usersByUsernameQuery("select username,password,enabled from users where username=?");

	
}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/*")
			.access("hasRole('ROLE_ADMIN')").antMatchers("/*").access("hasRole('ROLE_STUDENT')")
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/j_spring_security_check")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password")				
			    .and()
				.logout()
				.logoutSuccessUrl("/login?logout"); 
		
	}

}
*/