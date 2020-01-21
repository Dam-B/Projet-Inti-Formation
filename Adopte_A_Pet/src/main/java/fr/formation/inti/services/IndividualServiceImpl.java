package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;


import fr.formation.inti.Iservices.ICentreService;
import fr.formation.inti.Iservices.IIndividualsService;
import fr.formation.inti.dao.ICentreRepository;
import fr.formation.inti.dao.IIndividualRepository;
import fr.formation.inti.entities.Centre;
import fr.formation.inti.entities.Individual;

public class IndividualServiceImpl implements IIndividualsService {
	@Autowired
	private IIndividualRepository individualRepository;

	@Override
	public void save(Individual centre) {
		individualRepository.save(centre);
		
	}

	@Override
	public void update(Individual centre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		individualRepository.delete(id);
		
	}

	@Override
	public Individual findByIduser(String iduser) {
		return individualRepository.findByIduser(iduser);
	}

	@Override
	public Individual findByIddept(String iddept) {
		return individualRepository.findByIddept(iddept);
	}

	@Override
	public Individual findByMail(String mail) {
		return individualRepository.findByMail(mail);
	}
	
	
}
