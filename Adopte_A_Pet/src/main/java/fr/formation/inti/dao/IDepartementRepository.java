package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Departement;





public interface IDepartementRepository extends JpaRepository<Departement, Integer>{
	Departement findByDeptid(Integer deptid);
	Departement findByName(String dept);
//find by userID
//find by adoption ID
//find by pet ID
}
