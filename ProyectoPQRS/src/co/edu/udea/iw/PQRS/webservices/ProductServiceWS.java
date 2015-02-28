package co.edu.udea.iw.PQRS.webservices;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.ProductService;

@Path("Product")
@Component
public class ProductServiceWS {

	@Autowired
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<ProductType> getAllProductType() throws IWDaoException,
			RemoteException, IWServiceException {

		List<ProductType> productTypeList = new ArrayList<ProductType>();

		try {
			productTypeList = productService.getAllProductType();
		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}

		return productTypeList;
	}
}
