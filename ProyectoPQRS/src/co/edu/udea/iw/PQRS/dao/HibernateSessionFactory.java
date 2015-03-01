package co.edu.udea.iw.PQRS.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Clase encargada de abrir una conexi&oacute;n activa con la base de datos,
 * para realizar las respectivas consultas contra la base de datos, haciendo uso
 * de Hibernate
 * 
 * @since JDK 1.8
 * @since Hibernate 3.0
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class HibernateSessionFactory {

	/**
	 * Implementaci&oacute;n del patr&oacute;n Singleton, por lo que su
	 * constructor debe ser privada, y se retornara una &uacute;nica instancia
	 * de esta clase.
	 */
	private HibernateSessionFactory() {
		super();
	}

	/**
	 * Instancia &uacute;nica de tipo {@code HibernateSessionFactory} que se
	 * retornara a las clases que hagan uso de este recurso
	 */
	private static HibernateSessionFactory instancia = null;
	private static SessionFactory sessionFactory = null;
	private static Configuration configuration = new Configuration();

	/**
	 * M&eacute;todo encargado de crear y retornar una &uacute;nica instancia de
	 * esta clase.
	 * 
	 * @return instancia de tipo {@code HibernateSessionFactory}
	 */
	public static HibernateSessionFactory getInstancia() {
		if (instancia == null) {
			instancia = new HibernateSessionFactory();
		}
		return instancia;
	}

	/**
	 * M&eacute;todo encargado de retornar una sesion activa de Hibernate para
	 * la conexi&oacute;n con la base de datos
	 * 
	 * @return
	 * @throws IWDaoException
	 */
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
