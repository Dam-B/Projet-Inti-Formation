package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Individual;

public interface IIndividualRepository extends JpaRepository<Individual, Long>{
	Individual save(Individual centre);
	void update(Individual centre);
	void delete(long id);
	
	Individual findByIduser(String iduser);
	Individual findByIddept(String iddept);
	//Find by id user
}
