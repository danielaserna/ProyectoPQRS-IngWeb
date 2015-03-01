package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.SolicitudeTypeDAO;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code SolicitudeTypeDAO}; por otra parte, esta clase hereda indirectamente
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
public class SolicitudeTypeDAOHibernate extends HibernateDaoSupport implements
		SolicitudeTypeDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeTypeDAO#get()
	 */
	@Override
	public List<SolicitudeType> get() throws IWDaoException {

		List<SolicitudeType> solicitudeType = new ArrayList<SolicitudeType>();

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(SolicitudeType.class);

			solicitudeType = criteria.list();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return solicitudeType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.SolicitudeTypeDAO#obtener(java.lang.String)
	 */
	@Override
	public SolicitudeType obtener(String idSolicitudType) throws IWDaoException {

		SolicitudeType solicitudeType = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(SolicitudeType.class)
					.add(Restrictions.eq("Tipo", idSolicitudType));

			solicitudeType = (SolicitudeType) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return solicitudeType;

	}

}
