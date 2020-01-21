package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Departement;





public interface IDepartementService {
	void save(Departement departement);
	void update(Departement departement);
	void delete(Integer id);
	Departement findByDeptid(Integer deptid);
//find by userID
//find by adoption ID
//find by pet ID
}
