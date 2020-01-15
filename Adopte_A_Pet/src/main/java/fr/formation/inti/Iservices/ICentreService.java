package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Centre;

public interface ICentreService {
	
	void save(Centre centre);
	void update(Centre centre);
	void delete(long id);
	
	Centre findByIduser(String iduser);
	Centre findByIddept(String iddept);
}
