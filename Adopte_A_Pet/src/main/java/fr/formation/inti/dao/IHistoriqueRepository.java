package fr.formation.inti.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Historique;
import fr.formation.inti.entities.Pet;

public interface IHistoriqueRepository extends JpaRepository<Historique, Integer>{

	List<Historique> findByPet(Pet pet);
	
	//Find by id user
}
