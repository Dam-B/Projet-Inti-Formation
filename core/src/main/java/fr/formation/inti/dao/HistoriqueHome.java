package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Historique;



/**
 * Home object for domain model class Historique.
 * @see fr.fromation.inti.Historique
 * @author Hibernate Tools
 */
@Stateless
public class HistoriqueHome {

	private static final Log log = LogFactory.getLog(HistoriqueHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Historique transientInstance) {
		log.debug("persisting Historique instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Historique persistentInstance) {
		log.debug("removing Historique instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Historique merge(Historique detachedInstance) {
		log.debug("merging Historique instance");
		try {
			Historique result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Historique findById(Integer id) {
		log.debug("getting Historique instance with id: " + id);
		try {
			Historique instance = entityManager.find(Historique.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
