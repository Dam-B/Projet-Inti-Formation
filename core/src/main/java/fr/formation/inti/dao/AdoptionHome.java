package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Adoption;



/**
 * Home object for domain model class Adoption.
 * @see fr.fromation.inti.Adoption
 * @author Hibernate Tools
 */
@Stateless
public class AdoptionHome {

	private static final Log log = LogFactory.getLog(AdoptionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Adoption transientInstance) {
		log.debug("persisting Adoption instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Adoption persistentInstance) {
		log.debug("removing Adoption instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Adoption merge(Adoption detachedInstance) {
		log.debug("merging Adoption instance");
		try {
			Adoption result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Adoption findById(Integer id) {
		log.debug("getting Adoption instance with id: " + id);
		try {
			Adoption instance = entityManager.find(Adoption.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
