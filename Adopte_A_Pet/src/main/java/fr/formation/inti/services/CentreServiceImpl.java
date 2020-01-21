package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.ICentreService;
import fr.formation.inti.dao.ICentreRepository;
import fr.formation.inti.entities.Centre;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.User;

@Service
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
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Centre findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Centre findByDepartement(Departement dept) {
		// TODO Auto-generated method stub
		return null;
	}



}
