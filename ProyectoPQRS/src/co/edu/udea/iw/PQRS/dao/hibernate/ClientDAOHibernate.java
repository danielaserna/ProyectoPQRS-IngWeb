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

public class ClientDAOHibernate extends HibernateDaoSupport implements
		ClientDAO {

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
