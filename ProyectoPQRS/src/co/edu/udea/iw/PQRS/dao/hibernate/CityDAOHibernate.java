package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.*;
import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

public class CityDAOHibernate extends HibernateDaoSupport implements CityDAO {

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
