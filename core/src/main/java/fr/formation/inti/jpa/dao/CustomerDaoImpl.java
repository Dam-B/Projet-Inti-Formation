package fr.formation.inti.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.inti.entities.Customer;
import fr.formation.inti.jdbc.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	private EntityManager em;
	private EntityManagerFactory emf;
	
	public CustomerDaoImpl() {
		emf = Persistence.createEntityManagerFactory("MyApp");
		em = emf.createEntityManager();
	}
	@Override
	public Integer create(Customer c) {
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return c.getCustId();
	}

	@Override
	public void update(Customer c) {
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	@Override
	public void delete(Customer c) {
		em.getTransaction().begin();
		em.remove(c);;
		em.getTransaction().commit();
	}

	@Override
	public void delete(Integer id) {
		em.getTransaction().begin();
		Customer c = getById(id);
		em.remove(c);
		em.getTransaction().commit();		
	}

	@Override
	public Customer getById(Integer id) {
		em.getTransaction().begin();
		Customer c = em.find(Customer.class, id);
		em.getTransaction().commit();
		return c;
	}

	@Override
	public List<Customer> getAll() {
		em.getTransaction().begin();
		List<Customer> costumers = em.createQuery("select y from Customer y").getResultList();
		em.getTransaction().commit();
		return costumers;
	}
	
	public void close() {
		em.close();
		emf.close();
	}
	@Override
	public boolean isManaged(Customer c) {
		return em.contains(c);
	}
	
	public void flush() {
		em.flush();
	}

}
