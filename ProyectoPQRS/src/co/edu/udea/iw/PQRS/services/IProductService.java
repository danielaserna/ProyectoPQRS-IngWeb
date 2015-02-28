package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

public interface IProductService {

	/**
	 * 
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<ProductType> getAllProductType() throws
	IWDaoException, IWServiceException;
	
}
