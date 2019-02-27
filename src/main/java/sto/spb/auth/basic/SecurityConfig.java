package sto.spb.auth.basic;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.context.annotation.Bean;
import sto.spb.auth.basic.config.CustomAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//Note :: Extended WebSecurityConfigurerAdapter to override spring features with our custom security settings
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Approach 01 :: Start
    @Autowired
    private CustomAuthenticationProvider authProvider;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.anyRequest().authenticated()
        	.and()
        	.httpBasic();
    }
    //Approach 01 :: End

	/*
	//Approach 02 :: Start
	//TODO :: What is the use of this??
	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	//Spring boot 2, need to Bcrypt the password. Adding bean negate error
	//"PasswordEncoder mapped for the id null "
	@Bean
	public BCryptPasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

    //@Autowired addition could be done in many constructs (eg. instance variable reference, setter methods, constructors..)
	//Check Spring reference documentation for more details.
	//https://www.baeldung.com/spring-autowire
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	//User object is created in memory, Springboot 2 requires to have a BCryptEncoder as a bean for this to work
    	//and the password should be BCrypt encoded password. That is what is done below.
		auth.inMemoryAuthentication().withUser("john123")
			.password("$2a$06$84zrqA6QvwVzl1XCHHvjQexmTowQgcRGi3kvdePE6e/lkBbzR/nVm")
			.roles("USER");
	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic().authenticationEntryPoint(customAuthenticationEntryPoint);
	}
	//Approach 02 :: End
	*/
}
