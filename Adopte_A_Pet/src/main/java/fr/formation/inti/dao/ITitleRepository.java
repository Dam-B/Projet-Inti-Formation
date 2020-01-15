package fr.formation.inti.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import fr.formation.inti.entities.Title;

public interface ITitleRepository extends JpaRepository<Title, Long>{
	String findByIdtitle(Integer idtitle);
	//Find by ID
}
