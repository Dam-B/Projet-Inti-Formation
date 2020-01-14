package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualRepository extends JpaRepository<Individual, Long>{
	//Find by id user
}
