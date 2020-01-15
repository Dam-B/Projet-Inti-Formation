package fr.formation.inti.Iservices;

import fr.formation.inti.entities.User;

public interface IUserService {
	
    void save(User user);
    void update(User user);
    void delete(long id);
    
    User findByUsername(String username);
    User findByIduser(String iduser);
    User findByIdtitle(String idtitle);
    User findByIdpet(String idpet);
}
