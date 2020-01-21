package fr.formation.inti.Iservices;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Adoption;
import fr.formation.inti.entities.Centre;
import fr.formation.inti.entities.Departement;





public interface IDepartementService {
	void save(Departement departement);
	void update(Departement departement);
	void delete(long id);
	Departement findByDeptid(Integer deptid);
//find by userID
//find by adoption ID
//find by pet ID
}
