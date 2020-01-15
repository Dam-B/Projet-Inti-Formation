package fr.formation.inti.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.ITitleRepository;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.User;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ITitleRepository titleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(titleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public void update(User user) {
		String password = user.getPassword();
		String passwordConfirm = user.getPasswordConfirm();
		String username = user.getUsername();
		long id = user.getId();
		userRepository.findById(id);
		user.setPassword(password);
		user.setPasswordConfirm(passwordConfirm);
		user.setUsername(username);
		
		
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User findByIduser(String iduser) {
		return userRepository.findByIduser(iduser);
	}

//	@Override
//	public User findByIdtitle(String idtitle) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public User findByIdpet(String idpet) {
		return userRepository.findByIduser(idpet);
	}
}
