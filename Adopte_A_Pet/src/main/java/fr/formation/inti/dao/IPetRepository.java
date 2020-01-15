package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Pet;


public interface IPetRepository extends JpaRepository<Pet, Long>{
	
//Find by dept
//Find by catégorie
//find by IDpet
	
	}

