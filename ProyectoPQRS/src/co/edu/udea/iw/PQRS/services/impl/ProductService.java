package co.edu.udea.iw.PQRS.services.impl;

import java.util.List;

import co.edu.udea.iw.PQRS.dao.ProductTypeDAO;
import co.edu.udea.iw.PQRS.dao.hibernate.ProductDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.IProductService;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos que sirven de apoyo para efectuar los procesos definidos en la
 * capa de negocio con respecto a la gesti&oacute;n de la entidad
 * {@code Product}
 * 
 * <p>
 * Los m&eacute;todos expuestos para la gesti&oacute;n de los procesos de
 * negocio con respecto a las entidades perteneceientes a la clase
 * {@code Client} son aquellos que fueron definidos en la interfaz
 * {@code IProductService}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Yefry Alexis Calderon Yepes
 * @author Daniela Serna Buitrago
 *
 */
public class ProductService implements IProductService {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos de
	 * las instancias {@code ProductType} con respecto a la capa que define el
	 * contexto de persistencia de la aplicaci&oacute;n
	 */
	private ProductTypeDAO productTypeDAO;

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos de
	 * las instancias {@code Product} con respecto a la capa que define el
	 * contexto de persistencia de la aplicaci&oacute;n
	 */
	private ProductDAOHibernate productDAOHibernate;

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar la
	 * gesti&oacute;n de los datos con respecto a la capa que define el contexto
	 * de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code ProductTypeDAO}.
	 * 
	 * @return Instancia de tipo {@code ProductTypeDAO} para acceder a los datos
	 *         de la capa de persistencia
	 */
	public ProductTypeDAO getProductTypeDAO() {
		return productTypeDAO;
	}

	/**
	 * M&eacute;todo para establecer una instancia que servir&aacute; para
	 * realizar la gesti&oacute;n de los datos con respecto a la capa que define
	 * el contexto de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code ProductTypeDAO}.
	 * 
	 * @param productTypeDAO
	 *            instacia de tipo {@code ProductTypeDAOHibernate} que servira
	 *            para el acceso a loa datos de persistencia
	 */
	public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
		this.productTypeDAO = productTypeDAO;
	}

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar la
	 * gesti&oacute;n de los datos con respecto a la capa que define el contexto
	 * de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code ProductDAOHibernate}.
	 * 
	 * @return Instancia de tipo {@code ProductDAOHibernate} para acceder a los
	 *         datos de la capa de persistencia
	 */
	public ProductDAOHibernate getProductDAOHibernate() {
		return productDAOHibernate;
	}

	/**
	 * M&eacute;todo para establecer una instancia que servir&aacute; para
	 * realizar la gesti&oacute;n de los datos con respecto a la capa que define
	 * el contexto de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code ProductDAOHibernate}.
	 * 
	 * @param productDAOHibernate
	 *            instacia de tipo {@code ProductDAOHibernate} que servira
	 *            para el acceso a loa datos de persistencia
	 */
	public void setProductDAOHibernate(ProductDAOHibernate productDAOHibernate) {
		this.productDAOHibernate = productDAOHibernate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.services.IProductService#getAllProductType()
	 */
	@Override
	public List<ProductType> getAllProductType() throws IWDaoException,
			IWServiceException {

		List<ProductType> productTypeList = productTypeDAO.get();

		if (productTypeList == null || productTypeList.size() == 0) {
			throw new IWServiceException(
					"No existen tipos de producto en la base de datos");
		}

		return productTypeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.services.IProductService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() throws IWDaoException,
			IWServiceException {

		List<Product> productList = productDAOHibernate.get();

		if (productList == null || productList.size() == 0) {

			throw new IWServiceException(
					"No existen productos en la base de datos");
		}

		return productList;
	}

}
