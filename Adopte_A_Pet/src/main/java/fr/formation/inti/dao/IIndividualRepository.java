package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.IndividualId;

public interface IIndividualRepository extends JpaRepository<IndividualId, Long>{
	IndividualId save(IndividualId centre);
	void update(IndividualId centre);
	void delete(long id);
	
	IndividualId findByIduser(String iduser);
	IndividualId findByIddept(String iddept);
	//Find by id user
}
