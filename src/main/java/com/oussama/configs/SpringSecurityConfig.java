package com.oussama.configs;

import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringSecurityConfig  {

	
/*	   @Override
	    protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	          .password("user")
	          .roles("USER");
	    }

	    @Override
	    protected void configure(HttpSecurity http)
	      throws Exception {
	        http.csrf().disable()
	          .authorizeRequests()
	          .antMatchers("/").permitAll()
	          .anyRequest()
	          .authenticated()
	          .and()
	          .httpBasic();
	    }
	    */
}
