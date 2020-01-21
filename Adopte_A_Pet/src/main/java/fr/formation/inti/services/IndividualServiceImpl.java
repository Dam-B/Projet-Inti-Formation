package fr.formation.inti.services;

import java.util.Optional;

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
	public void save(Individual centre) {
		individualRepository.save(centre);
		
	}

	@Override
	public void update(Individual centre) {
		individualRepository.save(centre);
		
	}

	@Override
	public void delete(Integer id) {
		individualRepository.deleteById(id);
		
	}


	@Override
	public Individual findByMail(String mail) {
		// TODO Auto-generated method stub
		return individualRepository.findByMail(mail);
	}

	@Override
	public Individual findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Individual findByPostalCode(int postalCode) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
