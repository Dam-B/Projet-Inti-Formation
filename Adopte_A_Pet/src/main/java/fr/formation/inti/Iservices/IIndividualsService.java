package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Individual;

public interface IIndividualsService {
	void save(Individual centre);
	void update(Individual centre);
	void delete(Integer id);
	
	Individual findByIduser(Integer iduser);
	Individual findByIddept(Integer iddept);
	Individual findByMail(String mail);
}
