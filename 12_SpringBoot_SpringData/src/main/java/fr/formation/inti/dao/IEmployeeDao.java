package fr.formation.inti.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import fr.formation.inti.entities.Employee;


/**
 * interface de la couche DAO <br/>
 * @author INTIFORMATION
 *
 */

public interface IEmployeeDao extends PagingAndSortingRepository<Employee, Integer> {
//	public List<Employee> findByEmpId(Integer empId);

	
}

