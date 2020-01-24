package fr.formation.inti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IUserService;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));       
        return userRepository.save(user); 
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public User update(User user) {
		String password = user.getPassword();
		String username = user.getUsername();
		Integer id = user.getIduser();
		User userDeBase = userRepository.findByIduser(id);
		userDeBase.setPassword(password);
		userDeBase.setUsername(username);
		return userRepository.save(userDeBase);

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
	public List<User> findByTitle(Title title) {
		return userRepository.findByTitle(title);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findByDepartement(Departement departement) {
		return userRepository.findByDepartement(departement);
	}


	
}
