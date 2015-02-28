package co.edu.udea.iw.PQRS.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class HibernateSessionFactory {

	private HibernateSessionFactory() {
		// TODO Auto-generated constructor stub
	}

	private static HibernateSessionFactory instancia = null;
	private static SessionFactory sessionFactory = null;
	private static Configuration configuration = new Configuration();

	public static HibernateSessionFactory getInstancia() {
		if (instancia == null) {
			instancia = new HibernateSessionFactory();
		}
		return instancia;
	}

	public Session getSession() throws IWDaoException {

		try {
			if (sessionFactory == null) {
				configuration
						.configure("co/edu/udea/IW/PQRS/dao/cnf/hibernate.cfg.xml");

				sessionFactory = configuration.buildSessionFactory();
			}

			return sessionFactory.openSession();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

	}
}
