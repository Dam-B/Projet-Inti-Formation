package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

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
		User userDeBase = userRepository.findByIduser(id);
		userDeBase.setPassword(password);
		userDeBase.setUsername(username);
		userRepository.save(userDeBase);

	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);		
	}

	@Override
	public User findByIduser(Integer iduser) {
		return userRepository.findByIduser(iduser);
	}

	@Override
	public User findByTitle(Title title) {
		return userRepository.findByTitle(title);
	}


	
}
