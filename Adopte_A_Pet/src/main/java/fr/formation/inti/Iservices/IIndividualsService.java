package fr.formation.inti.Iservices;

import fr.formation.inti.dao.Individuals;

public interface IIndividualsService {
	void save(Individuals centre);
	void update(Individuals centre);
	void delete(long id);
	
	Individuals findByIduser(String iduser);
	Individuals findByIddept(String iddept);
}
