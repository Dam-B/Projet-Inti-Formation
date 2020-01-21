package fr.formation.inti.Iservices;

import java.util.Optional;

import fr.formation.inti.entities.Individual;
import fr.formation.inti.entities.User;

public interface IIndividualsService {
	void save(Individual centre);
	void update(Individual centre);
	void delete(Integer id);
	
	Individual findByUser(User user);
	Individual findByMail(String mail);
	Individual findByPostalCode(int postalCode);
}
