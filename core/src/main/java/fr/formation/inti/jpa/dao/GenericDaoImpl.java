package fr.formation.inti.jpa.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Notre classe EmployeeDaoImpl suit le modèle de conception Singleton qui
 * garantit qu'une seule instance de cette classe sera créée dans l'application.
 * Lors de la première création de classe, la méthode getEntityManager () est
 * chargée de créer une instance de EntityManager.
 * 
 * @author
 * @param <T>
 * @param <I>
 *
 */
public class GenericDaoImpl<T, I extends Serializable> implements IGenericDao<T, I> {
	private final static Log log = LogFactory.getLog(GenericDaoImpl.class);
	private Session currentSession;
	private Transaction currentTransaction;
	private Class<T> clazz;
	
	public final void setClazz( Class<T> clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public GenericDaoImpl() {
		getSessionFactory();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		log.info("from " + clazz.getSimpleName());
		return getCurrentSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	@Override
	public void persist(T e) {
		getCurrentSession().persist(e);
	}

	@Override
	public I save(T e) {

		return (I) getCurrentSession().save(e);
	}

	@Override
	public void update(T e) {
		getCurrentSession().update(e);
	}
	
	public void update(List<T> list) {		
		for(T e : list) {
			update(e);
		}
	}

	@Override
	public void delete(T e) {
		getCurrentSession().delete(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(I id, Class<?> persistClass) {
		return (T) getCurrentSession().get(persistClass, id);
	}

	@Override
	public void deleteByID(I id, Class<?> persistClass) {
		try {
			T e = findById(id, persistClass);
			delete(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void close() {
		getSessionFactory().close();
	}

}
