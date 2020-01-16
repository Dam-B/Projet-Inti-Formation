package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Categorie;

/**
 * Home object for domain model class Categorie.
 * @see fr.fromation.inti.Categorie
 * @author Hibernate Tools
 */
@Stateless
public class CategorieHome {

	private static final Log log = LogFactory.getLog(CategorieHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Categorie transientInstance) {
		log.debug("persisting Categorie instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Categorie persistentInstance) {
		log.debug("removing Categorie instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Categorie merge(Categorie detachedInstance) {
		log.debug("merging Categorie instance");
		try {
			Categorie result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Categorie findById(Integer id) {
		log.debug("getting Categorie instance with id: " + id);
		try {
			Categorie instance = entityManager.find(Categorie.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
