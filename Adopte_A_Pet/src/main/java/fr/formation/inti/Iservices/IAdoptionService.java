package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Adoption;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;





public interface IAdoptionService {
	
	void save(Adoption adoption);
	void update(Adoption adoption);
	void delete(Integer id);
	
	
	Adoption findByUser(User user);
	Adoption findByIdadoption(Integer idadoption);
	Adoption findByPet(Pet pet);
//find by userID
//find by adoption ID
//find by pet ID
}
