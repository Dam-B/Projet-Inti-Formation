package fr.formation.inti.Iservices;

import fr.formation.inti.entities.Categorie;


public interface ICategorieService {
	void save(Categorie categorie);
	void update(Categorie categorie);
	void delete(Integer id);
	
	Categorie findByIdcat(Integer id);
	Categorie findByCategorie(String categorie);
}
