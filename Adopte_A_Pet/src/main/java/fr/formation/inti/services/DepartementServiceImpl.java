package fr.formation.inti.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import fr.formation.inti.Iservices.ICategorieService;
import fr.formation.inti.Iservices.IDepartementService;
import fr.formation.inti.dao.ICategorieRepository;
import fr.formation.inti.dao.IDepartementRepository;
import fr.formation.inti.entities.Categorie;
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
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByDeptid(Integer deptid) {
		departementRepository.findByDeptid(deptid);
		
	}

	
}
