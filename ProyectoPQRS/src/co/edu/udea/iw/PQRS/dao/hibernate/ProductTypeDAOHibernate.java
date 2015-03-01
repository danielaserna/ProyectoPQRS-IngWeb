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

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos de acceso al repositorio de datos y definidos en la interfaz
 * {@code ProductTypeDAO}; por otra parte, esta clase hereda indirectamente de clase
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

public class ProductTypeDAOHibernate extends HibernateDaoSupport implements ProductTypeDAO {

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ProductTypeDAO#get()
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * @see co.edu.udea.iw.PQRS.dao.ProductTypeDAO#obtener(java.lang.String)
	 */
	@Override
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
