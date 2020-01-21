package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Adoption;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;





public interface IAdoptionRepository extends JpaRepository<Adoption, Integer>{
	Adoption findByUser(User user);
	Adoption findByIdadoption(Integer idadoption);
	Adoption findByPet(Pet pet);
//find by userID
//find by adoption ID
//find by pet ID
}
