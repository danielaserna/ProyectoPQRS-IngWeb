package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.SucursalDAO;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code SucursalDAO}; por otra parte, esta clase hereda indirectamente de
 * clase definida en el framework <b>Spring MVC</b> llamada:
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
public class SucursalDAOHibernate extends HibernateDaoSupport implements
		SucursalDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.SucursalDAO#get()
	 */
	@Override
	public List<Sucursal> get() throws IWDaoException {

		List<Sucursal> sucursal = new ArrayList<Sucursal>();

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Sucursal.class);

			sucursal = criteria.list();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return sucursal;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.SucursalDAO#obtener(java.lang.Integer)
	 */
	@Override
	public Sucursal obtener(Integer idSucursal) throws IWDaoException {

		Sucursal sucursal = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Sucursal.class).add(
					Restrictions.eq("Sucursal", idSucursal));

			sucursal = (Sucursal) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return sucursal;
	}

}
