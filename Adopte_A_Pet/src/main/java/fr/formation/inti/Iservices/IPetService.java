package fr.formation.inti.Iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.formation.inti.entities.Categorie;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;


public interface IPetService {
	
    Pet save(Pet pet);
    Pet update(Pet pet);
    void delete(Integer id);
    public List<Pet> findAllPet();
    public List<Pet> getAllPet(Integer pageNo, Integer pageSize, String sortBy);
	
	public Page<Pet> getPage(Pageable pageable);
    
    List<Pet> findByDepartement(Departement dept);
    Pet findByUser(User user);
    List<Pet> findByCategorie(Categorie categorie);
    Pet findByIdpet(Integer idpet);
    Pet findByName(String name);
}
