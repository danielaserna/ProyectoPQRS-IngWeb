package co.edu.udea.iw.PQRS.services.impl;

import java.util.List;

import co.edu.udea.iw.PQRS.dao.ProductTypeDAO;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.IProductService;

public class ProductService implements IProductService {

	private ProductTypeDAO productTypeDAO;

	public ProductTypeDAO getProductTypeDAO() {
		return productTypeDAO;
	}

	public void setProductTypeDAO(ProductTypeDAO productTypeDAO) {
		this.productTypeDAO = productTypeDAO;
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

}
