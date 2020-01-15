package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Individual;

public interface IIndividualsService {
	void save(Individual centre);
	void update(Individual centre);
	void delete(long id);
	
	Individual findByIduser(String iduser);
	Individual findByIddept(String iddept);
}
