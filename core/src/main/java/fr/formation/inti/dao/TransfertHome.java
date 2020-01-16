package fr.formation.inti.dao;
// Generated 16 janv. 2020 17:12:14 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Transfert;



/**
 * Home object for domain model class Transfert.
 * @see fr.fromation.inti.Transfert
 * @author Hibernate Tools
 */
@Stateless
public class TransfertHome {

	private static final Log log = LogFactory.getLog(TransfertHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Transfert transientInstance) {
		log.debug("persisting Transfert instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Transfert persistentInstance) {
		log.debug("removing Transfert instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Transfert merge(Transfert detachedInstance) {
		log.debug("merging Transfert instance");
		try {
			Transfert result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transfert findById(Integer id) {
		log.debug("getting Transfert instance with id: " + id);
		try {
			Transfert instance = entityManager.find(Transfert.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
