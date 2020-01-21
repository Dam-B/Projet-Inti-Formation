package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Title;

public interface ITitleService {
	void save(Title title);
	void update(Title title);
	void delete(Integer idtitle);
	
	
	Title findByIdtitle(Integer idtitle);
}
