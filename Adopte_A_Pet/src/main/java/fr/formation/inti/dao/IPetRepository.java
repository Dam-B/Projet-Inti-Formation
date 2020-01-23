package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Categorie;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;


public interface IPetRepository extends JpaRepository<Pet, Integer>{
	List<Pet> findByDepartement(Departement departement);
	Pet findByIdpet(Integer idpet);
	List<Pet> findByCategorie(Categorie categorie);
	Pet findByUser(User user);
//Find by dept
//Find by catégorie
//find by IDpet
	
	}

