package com.rainsho.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.rainsho.entity.Logs;

/**
 * A data access object (DAO) providing persistence and search support for Logs
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.rainsho.entity.Logs
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class LogsDAO {
	private static final Logger log = LoggerFactory.getLogger(LogsDAO.class);
	// property constants
	public static final String TXT1 = "txt1";
	public static final String TXT2 = "txt2";
	public static final String TXT3 = "txt3";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Logs transientInstance) {
		log.debug("saving Logs instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Logs persistentInstance) {
		log.debug("deleting Logs instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Logs findById(java.lang.Integer id) {
		log.debug("getting Logs instance with id: " + id);
		try {
			Logs instance = (Logs) getCurrentSession().get(
					"com.rainsho.entity.Logs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Logs> findByExample(Logs instance) {
		log.debug("finding Logs instance by example");
		try {
			List<Logs> results = (List<Logs>) getCurrentSession()
					.createCriteria("com.rainsho.entity.Logs")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Logs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Logs as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Logs> findByTxt1(Object txt1) {
		return findByProperty(TXT1, txt1);
	}

	public List<Logs> findByTxt2(Object txt2) {
		return findByProperty(TXT2, txt2);
	}

	public List<Logs> findByTxt3(Object txt3) {
		return findByProperty(TXT3, txt3);
	}

	public List findAll() {
		log.debug("finding all Logs instances");
		try {
			String queryString = "from Logs";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Logs merge(Logs detachedInstance) {
		log.debug("merging Logs instance");
		try {
			Logs result = (Logs) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Logs instance) {
		log.debug("attaching dirty Logs instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Logs instance) {
		log.debug("attaching clean Logs instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static LogsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (LogsDAO) ctx.getBean("LogsDAO");
	}
}