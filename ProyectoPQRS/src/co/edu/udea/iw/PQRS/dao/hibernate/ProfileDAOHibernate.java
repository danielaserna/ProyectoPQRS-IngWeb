package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.ProfileDAO;
import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code ProfileDAO}; por otra parte, esta clase hereda indirectamente de clase
 * definida en el framework <b>Spring MVC</b> llamada:
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

public class ProfileDAOHibernate extends HibernateDaoSupport implements ProfileDAO {

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ProfileDAO#get()
	 */
	@Override
	public List<Profile> get() throws IWDaoException {

			List<Profile> profile = new ArrayList<Profile>();

			try {
				Session session = getSession();

				Criteria criteria = session.createCriteria(Profile.class);

				profile = criteria.list();

			} catch (HibernateException e) {
				throw new IWDaoException(e);
			}

			return profile;
	}

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ProfileDAO#obtener(java.lang.String)
	 */
	@Override
	public Profile obtener(String profile) throws IWDaoException {
		
		Profile profiles = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(City.class).add(
					Restrictions.eq("codigo", profile));

			profiles = (Profile) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return profiles;
		
	}

}
