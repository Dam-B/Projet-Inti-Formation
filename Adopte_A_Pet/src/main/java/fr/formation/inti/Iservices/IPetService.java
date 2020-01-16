package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Pet;


public interface IPetService {
	
    void save(Pet pet);
    void update(Pet pet);
    void delete(long id);
    
    Pet findByIddept(String iddept);
    Pet findByIduser(String iduser);
    Pet findByCategorie(String categorie);
    Pet findByIdpet(String idpet);
}
