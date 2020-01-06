package fr.formation.inti.jdbc.dao;

import java.util.List;

import fr.formation.inti.entities.Customer;
/**
 * 
 * @author pc
 *
 */
public interface CustomerDao {
	//create Customer and return CustId
	Integer create(Customer c);
	void update(Customer c);
	
	void delete(Customer c);
	void delete(Integer id);
	
	Customer getById(Integer id);
	List<Customer> getAll();
	
	
	
	
	boolean isManaged(Customer c);
	
}
