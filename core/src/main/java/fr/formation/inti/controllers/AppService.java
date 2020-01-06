package fr.formation.inti.controllers;

import java.util.List;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.IEmployeeService;

public class AppService {

	public static void main(String[] args) {
		
		IEmployeeService service = new EmployeeService();
		
		List<Employee> employees = service.findAll();
		
		for(Employee e : employees)
			System.out.println(e);

	}

}
