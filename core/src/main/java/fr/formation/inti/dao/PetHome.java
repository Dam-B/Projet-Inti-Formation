package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Pet;



/**
 * Home object for domain model class Pet.
 * @see fr.fromation.inti.Pet
 * @author Hibernate Tools
 */
@Stateless
public class PetHome {

	private static final Log log = LogFactory.getLog(PetHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Pet transientInstance) {
		log.debug("persisting Pet instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Pet persistentInstance) {
		log.debug("removing Pet instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Pet merge(Pet detachedInstance) {
		log.debug("merging Pet instance");
		try {
			Pet result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pet findById(Integer id) {
		log.debug("getting Pet instance with id: " + id);
		try {
			Pet instance = entityManager.find(Pet.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
