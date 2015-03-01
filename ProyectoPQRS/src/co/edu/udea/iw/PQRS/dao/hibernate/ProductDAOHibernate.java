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

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code ProductDAO}; por otra parte, esta clase hereda indirectamente de clase
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
public class ProductDAOHibernate extends HibernateDaoSupport implements
		ProductDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.ProductDAO#get()
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.dao.ProductDAO#get(java.lang.Integer)
	 */
	@Override
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
