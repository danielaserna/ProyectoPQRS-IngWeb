package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.SolicitudeDAO;
import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

public class SolicitudeDAOHibernate extends HibernateDaoSupport implements
		SolicitudeDAO {

	public Solicitude insert(Solicitude solicitude) throws IWDaoException {
		Transaction tx = null;
		Session session = null;

		try {
			session = getSession();

			tx = session.beginTransaction();
			session.save(solicitude);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return solicitude;
	}

	public Solicitude update(Solicitude solicitude) throws IWDaoException {
		Transaction tx = null;
		Session session = null;

		try {
			session = getSession();

			tx = session.beginTransaction();
			session.update(solicitude);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return solicitude;
	}

	public Solicitude delete(Solicitude solicitude) throws IWDaoException {
		Transaction tx = null;
		Session session = null;

		try {
			session = getSession();

			tx = session.beginTransaction();
			session.update(solicitude);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return null;
	}

	public List<Solicitude> get() throws IWDaoException {

		Session session = null;

		List<Solicitude> solicitude = new ArrayList<Solicitude>();

		try {
			session = getSession();

			Criteria criteria = session.createCriteria(Solicitude.class);

			solicitude = criteria.list();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return solicitude;
	}

	public Solicitude get(Integer idSolicitude) throws IWDaoException {

		Solicitude solicitude = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Solicitude.class).add(
					Restrictions.eq("idSolicitud", idSolicitude));

			solicitude = (Solicitude) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return solicitude;
	}

}
