package fr.formation.inti.Iservices;

import java.util.List;
import java.util.Optional;

import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

public interface IUserService {
	
    User save(User user);
    User update(User user);
    void delete(Integer id);
    Optional<User> findById(Integer id);
    User findByUsername(String username);
    User findByIduser(Integer id);
    List<User> findByTitle(Title title);
	List<User> findByDepartement(Departement departement);

}
