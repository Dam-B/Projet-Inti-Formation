package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.ICategorieService;
import fr.formation.inti.dao.ICategorieRepository;
import fr.formation.inti.entities.Categorie;
@Service
public class CategorieServiceImpl implements ICategorieService {
	@Autowired
	private ICategorieRepository categorieRepository;

	@Override
	public void save(Categorie centre) {
		categorieRepository.save(centre);
		
	}

	@Override
	public void update(Categorie categorie) {
		String nom_categorie = categorie.getCategorie();
		Categorie categorie_a_update = categorieRepository.findByIdcat(categorie.getIdcat());
		categorie_a_update.setCategorie(nom_categorie);
		categorieRepository.saveAndFlush(categorie_a_update);
		
	}

	@Override
	public void delete(Integer id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public Categorie findByIdcat(Integer id) {
		return categorieRepository.findByIdcat(id);
	}

	@Override
	public Categorie findByCategorie(String categorie) {
		return categorieRepository.findByCategorie(categorie);
	}



	
}
