package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.jpa.dao.EmployeeDaoImpl;

public class EmployeeService implements IEmployeeService {
	
	private static EmployeeDaoImpl dao;
	
	public EmployeeService() {
		dao = new EmployeeDaoImpl();
	}
	@Override
	public void persist(Employee e) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(e);
        dao.closeCurrentSessionwithTransaction();
    }
	@Override
	public Integer save(Employee e) {
		
        dao.openCurrentSessionwithTransaction();
        Integer id = dao.save(e);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    @Override
	public void update(Employee e) {
        dao.openCurrentSessionwithTransaction();
        dao.update(e);
        dao.closeCurrentSessionwithTransaction();
    }
 
    @Override
	public Employee findById(Integer id) {
        dao.openCurrentSession();
        Employee emp = dao.findById(id,Employee.class);
        dao.closeCurrentSession();
        return emp;
    }
 
    @Override
	public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Employee emp = dao.findById(id,Employee.class);
        dao.delete(emp);
        dao.closeCurrentSessionwithTransaction();
    }
    
    @Override
	public void delete(Employee e) {
        dao.openCurrentSessionwithTransaction();
        dao.delete(e);
        dao.closeCurrentSessionwithTransaction();
    }
    @Override
	public List<Employee> findAll() {
        dao.openCurrentSession();
        List<Employee> employees = dao.getAll();
        dao.closeCurrentSession();
        return employees;
    }
 
    
    @Override
	public void update(List<Employee> employees) {
    	dao.openCurrentSessionwithTransaction();
        dao.update(employees);
        dao.closeCurrentSessionwithTransaction();
    }
	
    
}
