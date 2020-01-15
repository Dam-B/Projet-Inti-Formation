package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICentreRepository extends JpaRepository<Centre, Long>{
	
	void save(Centre centre);
	void update(Centre centre);
	void delete(long id);
	
	Centre findByIduser(String iduser);
	Centre findByIddept(String iddept);
	//Find by id user
}
