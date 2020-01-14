package fr.formation.inti.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.Employee;


/**
 * interface de la couche service <br/>
 * @author INTIFORMATION
 *
 */
@Transactional
public interface IEmployeService {

	public void ajouterEmploye(Employee pEmploye);

	public void modifierEmploye(Employee pEmploye);

	public void supprimerEmploye(Integer pIdEmploye);

	public Employee findEmployeById(Integer pIdEmploye);
	
	Employee findByMail(String mail);

	public List<Employee> findAllEmployes();
	
	public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
	
	public Page<Employee> getPage(Pageable pageable);
}
