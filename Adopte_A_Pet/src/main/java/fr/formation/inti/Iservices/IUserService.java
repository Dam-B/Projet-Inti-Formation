package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

public interface IUserService {
	
    void save(User user);
    void update(User user);
    void delete(Integer id);
    
    User findByUsername(String username);
    User findByIduser(Integer iduser);
    User findByTitle(Title title);

}
