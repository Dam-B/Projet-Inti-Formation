package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IIndividualRepository extends JpaRepository<Individual, Long>{
	void save(Individuals centre);
	void update(Individuals centre);
	void delete(long id);
	
	Individuals findByIduser(String iduser);
	Individuals findByIddept(String iddept);
	//Find by id user
}
