package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IIndividualsService;
import fr.formation.inti.dao.IIndividualRepository;
import fr.formation.inti.entities.Individual;
import fr.formation.inti.entities.User;
@Service
public class IndividualServiceImpl implements IIndividualsService {
	@Autowired
	private IIndividualRepository individualRepository;

	@Override
	public void save(Individual indiv) {
		individualRepository.save(indiv);
		
	}

	@Override
	public void update(Individual indiv) {
		
		String address = indiv.getAdress();
		String city = indiv.getCity();
		String firstName = indiv.getFirstName();
		String lastName = indiv.getLastName();
		String mail = indiv.getMail();
		String tel = indiv.getTel();
		
		Individual indiv_a_update = individualRepository.findByIdindvidual(indiv.getIdindvidual());
		
		indiv_a_update.setAdress(address);
		indiv_a_update.setCity(city);
		indiv_a_update.setFirstName(firstName);
		indiv_a_update.setLastName(lastName);
		indiv_a_update.setMail(mail);
		indiv_a_update.setTel(tel);
		
		individualRepository.saveAndFlush(indiv_a_update);
	}

	@Override
	public void delete(Integer id) {
		individualRepository.deleteById(id);
		
	}


	@Override
	public Individual findByMail(String mail) {
		return individualRepository.findByMail(mail);
	}

	@Override
	public Individual findByUser(User user) {
		return individualRepository.findByUser(user);
	}

	@Override
	public Individual findByPostalCode(int postalCode) {
		return individualRepository.findByPostalCode(postalCode);
	}

	@Override
	public Individual findByIdindvidual(Integer id) {
		return individualRepository.findByIdindvidual(id);
	}


	
	
}
