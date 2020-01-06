package fr.formation.inti.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.formation.inti.entities.Customer;

public class AppJpa2 {

	public static void main(String[] args) {
    	Customer c1 = new Customer("adress","oujda","F","6200","62000","Maroc");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyApp");
		EntityManager em = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Customer c2 = new Customer("adress","oujda","F","6200","62000","Maroc");
		
		System.out.println(c2);
		tx.begin();
		
		//insert customer
		c2.setCity("Paris");
		System.out.println("c2 is managed :"+em.contains(c2));
		c2 = em.find(Customer.class, 70);
		System.out.println("c2 is managed after find:"+em.contains(c2));
		em.refresh(c2);
		System.out.println("c2 is managed after refresh:"+em2.contains(c2));
		System.out.println("c2 is managed after refresh:"+em.contains(c2));
		em.remove(c2);
		System.out.println("c2 is managed after remove:"+em.contains(c2));
		System.out.println(c2);
		tx.commit();
		
		
		
		
	}

}
