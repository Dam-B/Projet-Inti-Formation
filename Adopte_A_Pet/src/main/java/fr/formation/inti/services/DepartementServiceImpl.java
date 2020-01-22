package fr.formation.inti.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.inti.Iservices.IDepartementService;
import fr.formation.inti.dao.IDepartementRepository;
import fr.formation.inti.entities.Departement;

public class DepartementServiceImpl implements IDepartementService {
	@Autowired
	private IDepartementRepository departementRepository;

	@Override
	public void save(Departement departement) {
		departementRepository.save(departement);
		
	}

	@Override
	public void update(Departement departement) {
		String name = departement.getName();
		
		Departement departement_a_update = departementRepository.findByDeptid(departement.getDeptid());
		
		departement_a_update.setName(name);
		
		departementRepository.saveAndFlush(departement_a_update);
		
	}

	@Override
	public void delete(Integer id) {
		departementRepository.deleteById(id);
		
	}

	@Override
	public Departement findByDeptid(Integer deptid) {	
		return departementRepository.findByDeptid(deptid);
	}


	
}
