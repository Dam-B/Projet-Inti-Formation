package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Title;

public interface ITitleService {
	void save(Title title);
	void update(Title title);
	void delete(Title title);
	
	
	String findByIdtitle(Integer idtitle);
}
