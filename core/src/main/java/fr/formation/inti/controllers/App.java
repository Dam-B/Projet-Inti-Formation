package fr.formation.inti.controllers;

import java.util.List;

import fr.formation.inti.entities.Customer;
import fr.formation.inti.entities.Department;
import fr.formation.inti.jdbc.dao.CustomerDao;
import fr.formation.inti.jdbc.dao.CustomerDaoImpl;
import fr.formation.inti.jpa.dao.GenericDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	// create Customer
//    	Customer c1 = new Customer("adress","oujda","F","6200","62000","Maroc");
//    	CustomerDao dao = new CustomerDaoImpl();
//    	
//    	Integer id = dao.create(c1);
//    	System.out.println("Custumer Id : " +id+" is created");
//    	
//    	// update Customer    	
//    	dao.update(c1);
//    	
//    	
//    	// delete Customer
//    	dao.delete(c1);
//    	
//    	//getById
//    	Customer c2 = dao.getById(15);
//    	System.out.println(c2);
//    	
//    	//getAll Customer
//    	
//    	List<Customer> customers = dao.getAll();
//    	
//    	for(Customer c : customers)
//    		System.out.println(c);
    	String dept = "1";
		Integer deptId = null;
		Department d = new Department();
		GenericDaoImpl<Department, Integer> dao = new GenericDaoImpl<Department, Integer>();
		if (!("".equals(dept))) {
			deptId = Integer.parseInt(dept);
			d = dao.findById(deptId, Department.class);
			} else {
			deptId=null;
			d = null;
			}		
    	
    }
}
