package fr.formation.inti.services;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		individualRepository.delete(id);
		
	}

	@Override
	public Individual findByIduser(Integer iduser) {
		return individualRepository.findByIduser(iduser);
	}

	@Override
	public Individual findByIddept(Integer iddept) {
		return individualRepository.findByIddept(iddept);
	}

	@Override
	public Individual findByMail(String mail) {
		return individualRepository.findByMail(mail);
	}
	
	
}
