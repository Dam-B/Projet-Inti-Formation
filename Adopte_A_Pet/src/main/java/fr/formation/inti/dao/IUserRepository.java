package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Title;
import fr.formation.inti.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByIduser(Integer iduser);
//    User findByIdtitle(String idtitle);
    User findByTitle(Title title);
    //Find by ID
    //Find by titleid
    //Find by idpet
    
}
