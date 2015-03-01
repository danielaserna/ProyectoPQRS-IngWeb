package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.ClientDAO;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code ClientDAO}; por otra parte, esta clase hereda indirectamente de clase
 * definida en el framework <b>Spring MVC</b> llamada:
 * <code>HibernateDaoSupport</code>, dando de ese modo un soporte directo para
 * el acceso y gesti&oacute;n de los datos en el contexto de persistencia
 * definido en la aplicaci&oacute;n.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Alexis-PC
 *
 */
public class ClientDAOHibernate extends HibernateDaoSupport implements
		ClientDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.dao.ClientDAO#insert(co.edu.udea.iw.PQRS.dto.Client)
	 */
	@Override
	public Client insert(Client client) throws IWDaoException {

		Transaction tx = null;
		Session session = null;

		try {
			session = this.getSession();

			tx = session.beginTransaction();
			session.save(client);
			tx.commit();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return client;
	}
	
	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ClientDAO#update(co.edu.udea.iw.PQRS.dto.Client)
	 */
	@Override
	public Client update(Client client) throws IWDaoException {

		Transaction tx = null;
		Session session = null;

		try {
			session = this.getSession();

			tx = session.beginTransaction();
			session.update(client);
			tx.commit();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return client;
	}

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ClientDAO#delete(co.edu.udea.iw.PQRS.dto.Client)
	 */
	@Override
	public Client delete(Client client) throws IWDaoException {

		Transaction tx = null;
		Session session = null;

		try {
			session = this.getSession();

			tx = session.beginTransaction();
			session.update(client);
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
	 * @see co.edu.udea.iw.PQRS.dao.ClientDAO#get()
	 */
	@Override
	public List<Client> get() throws IWDaoException {

		Session session = null;

		List<Client> clients = new ArrayList<Client>();

		try {
			session = getSession();

			Criteria criteria = session.createCriteria(Client.class);

			clients = criteria.list();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		} finally {
			session.close();
		}

		return clients;
	}

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ClientDAO#get(java.lang.Integer)
	 */
	@Override
	public Client get(Integer idNumber) throws IWDaoException {

		Client client = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Client.class).add(
					Restrictions.eq("idNumber", idNumber));

			client = (Client) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return client;
	}
}
