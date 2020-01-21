package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Centre;

public interface ICentreService {
	
	void save(Centre centre);
	void update(Centre centre);
	void delete(Integer id);
	
	Centre findByIduser(Integer iduser);
	Centre findByIddept(Integer iddept);
}
