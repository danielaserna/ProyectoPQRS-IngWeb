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

public class SolicitudeTypeDAOHibernate extends HibernateDaoSupport implements SolicitudeTypeDAO {

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

	public SolicitudeType obtener(String idSolicitudType) throws IWDaoException {
		
		SolicitudeType solicitudeType = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(SolicitudeType.class).add(
					Restrictions.eq("Tipo", idSolicitudType));

			solicitudeType = (SolicitudeType) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return solicitudeType;
		
	}

}
