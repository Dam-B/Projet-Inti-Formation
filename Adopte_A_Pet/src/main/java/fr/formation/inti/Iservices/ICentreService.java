package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Centre;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.User;

public interface ICentreService {
	
	void save(Centre centre);
	void update(Centre centre);
	void delete(Integer id);
	
	Centre findByUser(User user);
	Centre findByDepartement(Departement dept);
	Centre findByIdcentre(Integer id);
}
