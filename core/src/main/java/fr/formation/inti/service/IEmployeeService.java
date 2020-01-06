package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entities.Employee;

public interface IEmployeeService {

	public void persist(Employee e);

	public Integer save(Employee e);

	public void update(Employee e);

	public Employee findById(Integer id);

	public void delete(Integer id);

	public void delete(Employee e);

	public List<Employee> findAll();

	public void update(List<Employee> employees);

}