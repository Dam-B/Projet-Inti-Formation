package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;


import fr.formation.inti.Iservices.ICentreService;
import fr.formation.inti.dao.ICentreRepository;
import fr.formation.inti.entities.Centre;

public class CentreServiceImpl implements ICentreService {
	@Autowired
	private ICentreRepository centreRepository;
	
	@Override
	public void save(Centre centre) {
		centreRepository.save(centre);
		
	}

	@Override
	public void update(Centre centre) {
		//A compléter avec les set et get des datas de la BDD
		
	}

	@Override
	public void delete(long id) {
		centreRepository.delete(id);
		
	}

	@Override
	public Centre findByIduser(String iduser) {
		return centreRepository.findByIduser(iduser);
	}

	@Override
	public Centre findByIddept(String iddept) {
		return centreRepository.findByIddept(iddept);
	}

}
