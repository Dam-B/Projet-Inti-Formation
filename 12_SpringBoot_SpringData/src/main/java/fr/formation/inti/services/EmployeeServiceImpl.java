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
import fr.formation.inti.pageable.PaginationResult;



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
		List<Employee> list = new ArrayList<Employee>();
		Iterable<Employee> it = employeDAO.findAll();
		it.forEach(list::add);
		return list;
	}
	@Override
	public List<Employee> getAllEmployees(Integer pagello, Integer pageSize, String Sortby){
		Pageable paging = PageRequest.of(pagello, pageSize, Sort.by(Sortby));
		Page<Employee> pagegResult = employeDAO.findAll(paging);
		if(pagegResult.hasContent()) {
			return pagegResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}
	
//	 public PaginationResult<Employee> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
//	        return new PaginationResult<Employee>(employeDAO.findAll(), page, maxResult, maxNavigationPage);
//	    }

	@Override
	public List<Employee> findByFirstNameLike(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}//end class 
