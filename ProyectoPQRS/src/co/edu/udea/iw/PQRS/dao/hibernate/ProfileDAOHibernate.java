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

public class ProfileDAOHibernate extends HibernateDaoSupport implements ProfileDAO {

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
