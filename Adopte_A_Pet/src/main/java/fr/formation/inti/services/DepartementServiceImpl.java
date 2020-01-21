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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departement findByDeptid(Integer deptid) {
		departementRepository.findByDeptid(deptid);
		return null;
	}


	
}
