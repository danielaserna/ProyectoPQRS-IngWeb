package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.ProductDAO;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

public class ProductDAOHibernate extends HibernateDaoSupport implements
		ProductDAO {

	public List<Product> get() throws IWDaoException {

		List<Product> product = new ArrayList<Product>();

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Product.class);

			product = criteria.list();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return product;
	}

	public Product get(Integer idProduct) throws IWDaoException {

		Product product = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(Product.class).add(
					Restrictions.eq("codigo", idProduct));

			product = (Product) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return product;

	}

}
