package sto.spb.auth.basic.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import sto.spb.auth.basic.entity.UserRepository;
import sto.spb.auth.basic.entity.Users;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        //TODO :: BCrypt encoding needs to be done here, and passwords should not be saved in the DB as plain text
        Users u = userRepository.getUser(name,password);
        
        if (u!=null) {
        	//TODO :: What is this parts necessity
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
            return null;
        }
        
	}
	
	//TODO :: What does this piece of code do???
	@Override
	public boolean supports(Class<?> authentication) {
        return authentication.equals( UsernamePasswordAuthenticationToken.class );
	}

}
