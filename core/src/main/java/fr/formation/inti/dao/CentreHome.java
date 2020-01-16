package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Centre;

/**
 * Home object for domain model class Centre.
 * @see fr.fromation.inti.Centre
 * @author Hibernate Tools
 */
@Stateless
public class CentreHome {

	private static final Log log = LogFactory.getLog(CentreHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Centre transientInstance) {
		log.debug("persisting Centre instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Centre persistentInstance) {
		log.debug("removing Centre instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Centre merge(Centre detachedInstance) {
		log.debug("merging Centre instance");
		try {
			Centre result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Centre findById(Integer id) {
		log.debug("getting Centre instance with id: " + id);
		try {
			Centre instance = entityManager.find(Centre.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
