package fr.formation.inti.Iservices;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Historique;
import fr.formation.inti.entities.Pet;

public interface IHistoriqueService{
	void save(Historique historique);
	void update(Historique historique);
	void delete(Integer id);
	
	
	List<Historique> findByPet(Pet pet);
	
	//Find by id user
}
