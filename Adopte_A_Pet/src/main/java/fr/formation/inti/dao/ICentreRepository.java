package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Centre;

public interface ICentreRepository extends JpaRepository<Centre, Integer>{
	
	@SuppressWarnings("unchecked")
	Centre save(Centre centre);
	void update(Centre centre);
	void delete(Integer id);
	
	Centre findByIduser(Integer iduser);
	Centre findByIddept(Integer iddept);
	//Find by id user
}
