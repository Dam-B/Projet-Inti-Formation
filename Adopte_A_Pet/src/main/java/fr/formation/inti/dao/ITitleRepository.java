package fr.formation.inti.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Role;

public interface ITitleRepository extends JpaRepository<Title, Long>{
	Title findByIdtitle(String title);
	//Find by ID
}
