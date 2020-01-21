package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Categorie;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;


public interface IPetService {
	
    void save(Pet pet);
    void update(Pet pet);
    void delete(Integer id);
    
    Pet findByDepartement(Departement dept);
    Pet findByUser(User user);
    Pet findByCategorie(Categorie categorie);
    Pet findByIdpet(Integer idpet);
}
