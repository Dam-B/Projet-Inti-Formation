package fr.formation.inti.Iservices;

import java.util.Optional;

import fr.formation.inti.entities.Individual;

public interface IIndividualsService {
	void save(Individual centre);
	void update(Individual centre);
	void delete(Integer id);
	
	Optional<Individual> findByIduser(Integer iduser);
	Individual findByMail(String mail);
}
