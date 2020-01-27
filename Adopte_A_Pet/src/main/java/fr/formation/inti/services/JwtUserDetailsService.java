package fr.formation.inti.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
//c'est ici qu'on compare les users avec ceux de la BDD
	@Autowired
	private IUserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return new User(user.getUsername(), user.getPassword(),
					user.getAuthorities());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}