package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	User findByIduser(Integer id);
    User findByUsername(String username);
//    User findByIdtitle(String idtitle);
    List<User> findByTitle(Title title);
    List<User> findByDepartement(Departement departement);
    //Find by ID
    //Find by titleid
    //Find by idpet
    
}
