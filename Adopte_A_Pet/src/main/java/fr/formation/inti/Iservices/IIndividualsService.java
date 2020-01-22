package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Individual;
import fr.formation.inti.entities.User;

public interface IIndividualsService {
	void save(Individual indiv);
	void update(Individual indiv);
	void delete(Integer id);
	
	Individual findByUser(User user);
	Individual findByMail(String mail);
	Individual findByPostalCode(int postalCode);
	Individual findByIdindividual(Integer id);
}
