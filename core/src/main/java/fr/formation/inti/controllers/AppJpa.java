package fr.formation.inti.controllers;

import java.util.List;

import fr.formation.inti.entities.Customer;
import fr.formation.inti.jpa.dao.CustomerDaoImpl;

public class AppJpa {
	
	
    
	public static void main(String[] args) {
		System.out.println("******************* Test Create JPA ********************");
		System.out.println("********************************************************");
		Customer c1 = new Customer("adress","oujda","F","6200","62000","Maroc");
    	CustomerDaoImpl dao = new CustomerDaoImpl();
    	
    	Integer id = dao.create(c1);
    	System.out.println("Custumer Id : " +id+" is created");
		System.out.println("******************* Test Update JPA ********************");
		System.out.println("********************************************************");
				
		System.out.println("******************* Test find by Id JPA ********************");
		System.out.println("********************************************************");
		Customer c2 = dao.getById(c1.getCustId());
		System.out.println("c1 is Managed :"+dao.isManaged(c1));

		System.out.println(c2);
		
		c1.setCity("Fes");
		dao.update(c1);
		System.out.println(c1);
		System.out.println("******************* Test remove JPA ********************");
		System.out.println("********************************************************");
		dao.delete(c1);
		System.out.println("c1 is Managed :"+dao.isManaged(c1));
		System.out.println("******************* Test find by Id JPA ********************");
		System.out.println("********************************************************");
		Customer c3 = dao.getById(42);
//		dao.flush();
		System.out.println(c3);
		System.out.println("c3 is Managed :"+dao.isManaged(c3));
		System.out.println("******************* Test find All JPA ********************");
		System.out.println("********************************************************");
		List<Customer> customers = dao.getAll();
		for(Customer c : customers)
			System.out.println(c);
		dao.close();
		
		
	}

}
