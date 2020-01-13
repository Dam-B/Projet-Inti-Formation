package fr.formation.inti.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.Employee;


/**
 * interface de la couche service <br/>
 * @author INTIFORMATION
 *
 */
@Transactional
public interface IEmployeService {
	public List<Employee> findByFirstNameLike(String firstName);
	public void ajouterEmploye(Employee pEmploye);

	public void modifierEmploye(Employee pEmploye);

	public void supprimerEmploye(Integer pIdEmploye);

	public Employee findEmployeById(Integer pIdEmploye);

	public List<Employee> findAllEmployes();
	
	List<Employee> getAllEmployees(Integer pagello, Integer pageSize, String Sortby);
}
