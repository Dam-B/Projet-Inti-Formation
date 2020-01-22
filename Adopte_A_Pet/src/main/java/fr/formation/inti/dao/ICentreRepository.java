package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Centre;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.User;

public interface ICentreRepository extends JpaRepository<Centre, Integer>{
	Centre findByUser(User user);
	Centre findByDepartement(Departement dept);
	Centre findByIdcentre(Integer id);
	//Find by id user
}
