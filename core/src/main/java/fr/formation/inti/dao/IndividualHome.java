package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Individual;

/**
 * Home object for domain model class Individual.
 * @see fr.formation.inti.entities.Individual
 * @author Hibernate Tools
 */
@Stateless
public class IndividualHome {

	private static final Log log = LogFactory.getLog(IndividualHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Individual transientInstance) {
		log.debug("persisting Individual instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Individual persistentInstance) {
		log.debug("removing Individual instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Individual merge(Individual detachedInstance) {
		log.debug("merging Individual instance");
		try {
			Individual result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Individual findById(Integer id) {
		log.debug("getting Individual instance with id: " + id);
		try {
			Individual instance = entityManager.find(Individual.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
