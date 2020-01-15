package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Adoption;





public interface IAdoptionRepository extends JpaRepository<Adoption, Long>{
//find by userID
//find by adoption ID
//find by pet ID
}
