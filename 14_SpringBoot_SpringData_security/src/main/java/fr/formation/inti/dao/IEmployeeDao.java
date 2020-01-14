package fr.formation.inti.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.formation.inti.entities.Employee;


public interface IEmployeeDao extends PagingAndSortingRepository<Employee, Integer> {
	Employee findByEmail(String mail);
}
