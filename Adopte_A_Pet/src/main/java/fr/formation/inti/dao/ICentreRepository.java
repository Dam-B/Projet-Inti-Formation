package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Centre;

public interface ICentreRepository extends JpaRepository<Centre, Long>{
	
	@SuppressWarnings("unchecked")
	Centre save(Centre centre);
	void update(Centre centre);
	void delete(long id);
	
	Centre findByIduser(String iduser);
	Centre findByIddept(String iddept);
	//Find by id user
}
