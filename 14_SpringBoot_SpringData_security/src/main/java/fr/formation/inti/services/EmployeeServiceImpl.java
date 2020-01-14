package fr.formation.inti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entities.Employee;




/**
 * implémentation de la couche service <br/>
 * @author INTIFORMATION
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeService{

	//déclaration de la DAO 
	/**
	 * NB : la dao sera injectée par spring 
	 */
	@Autowired
	private IEmployeeDao employeDAO;
	
	/**
	 * setter de la dao pour permettre au conteneur spring d'injecter le 
	 * bean dao <br/>
	 * @param employeDAO
	 */
	public void setEmployeDAO(IEmployeeDao employeDAO) {
		this.employeDAO = employeDAO;
	}

	@Override
	public void ajouterEmploye(Employee pEmploye) {
		employeDAO.save(pEmploye);
	}

	@Override
	public void modifierEmploye(Employee pEmploye) {	
		employeDAO.save(pEmploye);
	}

	@Override
	public void supprimerEmploye(Integer pIdEmploye) {
		employeDAO.deleteById(pIdEmploye);
	}

	@Override
	public Employee findEmployeById(Integer pIdEmploye) {
		return employeDAO.findById(pIdEmploye).get();
	}

	@Override
	public List<Employee> findAllEmployes() {
		Iterable<Employee> it = employeDAO.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		it.forEach(employees:: add);
		return employees;
	}
	
	public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Employee> pagedResult = employeDAO.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }
	
	public Page<Employee> getPage(Pageable pageable){
        return employeDAO.findAll(pageable);
    }
	
	public Employee findByMail(String username) {
        return employeDAO.findByEmail(username);
    }

}//end class 
