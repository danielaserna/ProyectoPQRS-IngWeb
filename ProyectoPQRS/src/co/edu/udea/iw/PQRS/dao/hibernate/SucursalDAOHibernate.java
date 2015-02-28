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

public class SucursalDAOHibernate extends HibernateDaoSupport implements SucursalDAO {

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
