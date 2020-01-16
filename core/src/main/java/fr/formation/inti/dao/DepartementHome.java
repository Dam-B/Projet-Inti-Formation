package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Departement;



/**
 * Home object for domain model class Departement.
 * @see fr.fromation.inti.Departement
 * @author Hibernate Tools
 */
@Stateless
public class DepartementHome {

	private static final Log log = LogFactory.getLog(DepartementHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Departement transientInstance) {
		log.debug("persisting Departement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Departement persistentInstance) {
		log.debug("removing Departement instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Departement merge(Departement detachedInstance) {
		log.debug("merging Departement instance");
		try {
			Departement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Departement findById(int id) {
		log.debug("getting Departement instance with id: " + id);
		try {
			Departement instance = entityManager.find(Departement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
