package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Individual;
import fr.formation.inti.entities.User;

public interface IIndividualRepository extends JpaRepository<Individual, Integer>{

	Individual findByUser(User user);
	Individual findByPostalCode(int postalCode);
	Individual findByMail(String mail);
	Individual findByIdindvidual(Integer id);
	//Find by id user
}
