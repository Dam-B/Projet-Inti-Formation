package fr.formation.inti.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.ITitleRepository;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {
//c'est ici qu'on compare les users avec ceux de la BDD
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private ITitleRepository titleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        List<Title> title = titleRepository.findAll();
        if (user == null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Title title1 : title){
            grantedAuthorities.add(new SimpleGrantedAuthority(title1.getTitle()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

	}
}