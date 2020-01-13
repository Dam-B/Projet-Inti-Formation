package fr.formation.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class AppAuthProvider extends DaoAuthenticationProvider {
	    @Autowired
	    public UserDetailsService userDetailsService;
	    
	    public UserDetailsService getUserDetailsService() {
			return userDetailsService;
		}
		public void setUserDetailsService(UserDetailsService userDetailsService) {
			this.userDetailsService = userDetailsService;
		}
		@Override
	    @PostMapping("/register")
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
	        String name = auth.getName();
	        String password = auth.getCredentials()
	                .toString();
	        UserDetails user = userDetailsService.loadUserByUsername(name);
	        if (user == null) {
	            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
	        }
	        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	    }
	    @Override
	    public boolean supports(Class<?> authentication) {
	        return true;
	    }
	}

