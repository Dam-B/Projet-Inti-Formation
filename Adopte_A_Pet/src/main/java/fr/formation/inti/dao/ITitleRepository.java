package fr.formation.inti.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import fr.formation.inti.entities.Title;

public interface ITitleRepository extends JpaRepository<Title, Integer>{
	Title findByIdtitle(Integer idtitle);
	//Find by ID
}
