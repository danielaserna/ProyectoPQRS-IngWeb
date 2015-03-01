package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.CityDAO;
import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code CityDAO}; por otra parte, esta clase hereda indirectamente de clase
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
public class CityDAOHibernate extends HibernateDaoSupport implements CityDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.CityDAO#get()
	 */
	@Override
	public List<City> get() throws IWDaoException {

		List<City> cities = new ArrayList<City>();

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(City.class);

			cities = criteria.list();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return cities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.CityDAO#obtener(java.lang.Integer)
	 */
	@Override
	public City obtener(Integer code) throws IWDaoException {

		City city = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(City.class).add(
					Restrictions.eq("code", code));

			city = (City) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return city;

	}

}
