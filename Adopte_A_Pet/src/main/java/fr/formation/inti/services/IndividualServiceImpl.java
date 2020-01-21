package fr.formation.inti.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IIndividualsService;
import fr.formation.inti.dao.IIndividualRepository;
import fr.formation.inti.entities.Individual;
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
	public Optional<Individual> findByIduser(Integer iduser) {
		// TODO Auto-generated method stub
		return individualRepository.findById(iduser);
	}

	@Override
	public Individual findByMail(String mail) {
		// TODO Auto-generated method stub
		return individualRepository.findByMail(mail);
	}


	
	
}
