package fr.formation.inti.Iservices;

import fr.formation.inti.dao.Title;

public interface ITitleService {
	void save(Title title);
	void update(Title title);
	void delete(Title title);
	
	Title findByIdtitle(String title);
}
