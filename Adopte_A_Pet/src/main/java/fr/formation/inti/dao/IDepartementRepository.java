package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Adoption;
import fr.formation.inti.entities.Departement;





public interface IDepartementRepository extends JpaRepository<Departement, Long>{
	Departement findByDeptid(Integer deptid);
//find by userID
//find by adoption ID
//find by pet ID
}
