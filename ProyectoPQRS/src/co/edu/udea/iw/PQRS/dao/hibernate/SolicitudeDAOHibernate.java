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

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code SolicitudeDAO}; por otra parte, esta clase hereda indirectamente
 * de clase definida en el framework <b>Spring MVC</b> llamada:
 * <code>HibernateDaoSupport</code>, dando de ese modo un soporte directo para
 * el acceso y gesti&oacute;n de los datos en el contexto de persistencia
 * definido en la aplicaci&oacute;n.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class SolicitudeDAOHibernate extends HibernateDaoSupport implements
		SolicitudeDAO {

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeDAO#insert(co.edu.udea.iw.PQRS.dto.Solicitude)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeDAO#update(co.edu.udea.iw.PQRS.dto.Solicitude)
	 */
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
	
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeDAO#delete(co.edu.udea.iw.PQRS.dto.Solicitude)
	 */
	public Solicitude delete(Solicitude solicitude) throws IWDaoException {
		Transaction tx = null;
		Session session = null;

		try {
			session = getSession();

			tx = session.beginTransaction();
			session.delete(solicitude);
			tx.commit();
		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeDAO#get()
	 */
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

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeDAO#get(java.lang.Integer)
	 */
	public Solicitude get(Integer idSolicitude) throws IWDaoException {

		Solicitude solicitude = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Solicitude.class).add(
					Restrictions.eq("idSolicitude", idSolicitude));

			solicitude = (Solicitude) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return solicitude;
	}

}
