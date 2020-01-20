package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Categorie;


public interface ICategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByUsername(String username);
    Categorie findByIduser(String iduser);
//    User findByIdtitle(String idtitle);
    Categorie findByIdpet(String idpet);
    Categorie findByIdtitle(String idtitle);
    //Find by ID
    //Find by titleid
    //Find by idpet
    
}
