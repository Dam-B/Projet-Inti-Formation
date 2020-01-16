package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByIduser(String iduser);
//    User findByIdtitle(String idtitle);
    User findByIdpet(String idpet);
    User findByIdtitle(String idtitle);
    //Find by ID
    //Find by titleid
    //Find by idpet
    
}
