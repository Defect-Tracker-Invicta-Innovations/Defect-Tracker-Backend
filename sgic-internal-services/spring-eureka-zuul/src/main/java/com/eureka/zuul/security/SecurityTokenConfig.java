package com.eureka.zuul.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.eureka.common.security.JwtConfig;

@EnableWebSecurity 	// Enable security config. This annotation denotes config for spring security.
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtConfig jwtConfig;
 
	@Override
  	protected void configure(HttpSecurity http) throws Exception {
    	   http
    	   .cors().and()
		.csrf().disable()
		    // make sure we use stateless session; session won't be used to store user's state.
	 	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	
		.and()
		    // handle an authorized attempts 
		    .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)) 	
		.and()
		   // Add a filter to validate the tokens with every request
		   .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
		// authorization requests config
		.authorizeRequests()
			.requestMatchers(CorsUtils:: isPreFlightRequest).permitAll()
		   // allow all who are accessing "auth" service
//		   .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()  
		   // must be an admin if trying to access admin area (authentication is also required here),
			
			.antMatchers("/defectservices" + "/defectservices/updateprojectprivilege/**").hasAuthority("ROLE_ADMIN")
//			.antMatchers("/defectservices" + "/defectservices/saveDeveloperPrivilege/**").hasAuthority("ROLE_ADMIN")
			.antMatchers("/defectservices" + "/defectservices/updateHRPrivilege/**").hasAuthority("ROLE_ADMIN")
		   .antMatchers("/loginservice"+"/loginservice/api/auth/**").permitAll()
		   .antMatchers("/employeeservice" + "/employeeservice/**").permitAll()
		   .antMatchers("/defectservices" + "/defectservices/**").permitAll()
		   .antMatchers("/productservice" + "/productservice/**").permitAll()
		   
		   // Any other request must be authenticated
		   
		   .anyRequest().authenticated()
		   .and()
           .httpBasic(); 
	}
	
	@Bean
  	public JwtConfig jwtConfig() {
    	   return new JwtConfig();
  	}
}