package fr.formation.inti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IHistoriqueService;
import fr.formation.inti.dao.ICentreRepository;
import fr.formation.inti.dao.IHistoriqueRepository;
import fr.formation.inti.entities.Historique;
import fr.formation.inti.entities.Pet;

@Service
public class HistoriqueServiceImpl implements IHistoriqueService{
	@Autowired
	private IHistoriqueRepository historiqueRepository;
	
	@Override
	public List<Historique> findByPet(Pet pet) {
		return historiqueRepository.findByPet(pet);
	}

	@Override
	public void save(Historique historique) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Historique historique) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
