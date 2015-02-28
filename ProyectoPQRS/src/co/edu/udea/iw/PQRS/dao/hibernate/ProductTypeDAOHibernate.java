package co.edu.udea.iw.PQRS.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.PQRS.dao.ProductTypeDAO;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

public class ProductTypeDAOHibernate extends HibernateDaoSupport implements ProductTypeDAO {

	public List<ProductType> get() throws IWDaoException {
		
		
			List<ProductType> productType = new ArrayList<ProductType>();

			try {
				Session session = getSession();

				Criteria criteria = session.createCriteria(ProductType.class);

				productType = criteria.list();

			} catch (HibernateException e) {
				throw new IWDaoException(e);
			}

			return productType;
	}

	public ProductType obtener(String type) throws IWDaoException {
		
		ProductType productType = null;

		try {
			Session session = getSession();

			Criteria criteria = session.createCriteria(ProductType.class).add(
					Restrictions.eq("Tipo", type));

			productType = (ProductType) criteria.uniqueResult();

		} catch (HibernateException e) {
			throw new IWDaoException(e);
		}

		return productType;
	}

}
