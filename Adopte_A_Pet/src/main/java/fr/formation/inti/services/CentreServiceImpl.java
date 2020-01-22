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
		String city = centre.getCity();
		Departement dept = centre.getDepartement();
		String name = centre.getName();
		String postalCode = centre.getPostalCode();
		String tel = centre.getTel();
		User user = centre.getUser();
		
		Centre centre_a_update = centreRepository.findByIdcentre(centre.getIdcentre());
		
		centre_a_update.setCity(city);
		centre_a_update.setDepartement(dept);
		centre_a_update.setName(name);
		centre_a_update.setPostalCode(postalCode);
		centre_a_update.setTel(tel);
		centre_a_update.setUser(user);
		
		centreRepository.saveAndFlush(centre_a_update);
		
	}

	@Override
	public void delete(Integer id) {
		centreRepository.deleteById(id);
		
	}

	@Override
	public Centre findByUser(User user) {
		return centreRepository.findByUser(user);
	}

	@Override
	public Centre findByDepartement(Departement dept) {
		return centreRepository.findByDepartement(dept);
	}

	@Override
	public Centre findByIdcentre(Integer id) {
		return centreRepository.findByIdcentre(id);
	}



}
