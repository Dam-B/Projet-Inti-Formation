package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Pet;


public interface IPetRepository extends JpaRepository<Pet, Long>{
	Pet findByIddept(String iddept);
	Pet findByIdpet(String idpet);
	Pet findByCategorie(String categorie);
	Pet findByIduser(String iduser);
//Find by dept
//Find by catégorie
//find by IDpet
	
	}

