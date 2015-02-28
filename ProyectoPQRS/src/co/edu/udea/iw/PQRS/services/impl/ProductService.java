package co.edu.udea.iw.PQRS.services.impl;

import java.util.List;

import co.edu.udea.iw.PQRS.dao.ProductTypeDAO;
import co.edu.udea.iw.PQRS.dao.hibernate.ProductDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.IProductService;

public class ProductService implements IProductService {

	private ProductTypeDAO productTypeDAO;
	private ProductDAOHibernate productDAOHibernate;

	public ProductTypeDAO getProductTypeDAO() {
		return productTypeDAO;
	}

	public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
		this.productTypeDAO = productTypeDAO;
	}

	public ProductDAOHibernate getProductDAOHibernate() {
		return productDAOHibernate;
	}

	public void setProductDAOHibernate(ProductDAOHibernate productDAOHibernate) {
		this.productDAOHibernate = productDAOHibernate;
	}

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

	@Override
	public List<Product> getAllProducts() throws IWDaoException,
			IWServiceException {
		
		List<Product>productList = productDAOHibernate.get();
		
		if (productList == null || productList.size() == 0) {
			
			throw new IWServiceException("No existen productos en la base de datos");
		}
		
		return productList;
	}

}
