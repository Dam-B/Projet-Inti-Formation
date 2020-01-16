package fr.formation.inti.services;

import java.util.Optional;

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
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public void update(User user) {
		String password = user.getPassword();
		String username = user.getUsername();
		Integer id = user.getIduser();
		User userDeBase = userRepository.findByIduser(Integer.toString(id));
		userDeBase.setPassword(password);
		userDeBase.setUsername(username);
		userRepository.save(userDeBase);

	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);		
	}

	@Override
	public User findByIduser(String iduser) {
		return userRepository.findByIduser(iduser);
	}


	@Override
	public User findByIdpet(String idpet) {
		return userRepository.findByIduser(idpet);
	}

	@Override
	public User findByIdtitle(String idtitle) {
		return userRepository.findByIdtitle(idtitle);
	}
}
