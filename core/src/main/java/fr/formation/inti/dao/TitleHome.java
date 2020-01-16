package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Title;



/**
 * Home object for domain model class Title.
 * @see fr.fromation.inti.Title
 * @author Hibernate Tools
 */
@Stateless
public class TitleHome {

	private static final Log log = LogFactory.getLog(TitleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Title transientInstance) {
		log.debug("persisting Title instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Title persistentInstance) {
		log.debug("removing Title instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Title merge(Title detachedInstance) {
		log.debug("merging Title instance");
		try {
			Title result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Title findById(Integer id) {
		log.debug("getting Title instance with id: " + id);
		try {
			Title instance = entityManager.find(Title.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
