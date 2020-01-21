package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.inti.Iservices.ICategorieService;
import fr.formation.inti.dao.ICategorieRepository;
import fr.formation.inti.entities.Categorie;

public class CategorieServiceImpl implements ICategorieService {
	@Autowired
	private ICategorieRepository categorieRepository;

	@Override
	public void save(Categorie centre) {
		categorieRepository.save(centre);
		
	}

	@Override
	public void update(Categorie categorie) {
		categorieRepository.findById((long)categorie.getIdcat());
		
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	
}
