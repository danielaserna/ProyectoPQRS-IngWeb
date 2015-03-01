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

import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.ProductService;

/**
 * Clase que establece los m&eacute;todos que podran ejecutar los procesos que
 * involucran los servicios web que estan relacionados con instancias de la
 * clase {@code Product} y de ese modo, podr&aacute;n realizar paso de
 * informaci&oacute;n y de mensajes y poder cumplir asi con los procesos
 * negocios definidos para el sistema.
 * 
 * @since JDK 1.7
 * @since Jersey 1.4
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
@Path("Product")
@Component
public class ProductServiceWS {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos y
	 * procesos de negocio para las instancias {@code Product} con respecto a
	 * las reglas de negocio definidas
	 */
	@Autowired
	private ProductService productService;

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar los
	 * procesos correspondientes a la gesti&oacute;n de los datos.
	 * 
	 * @return instancia de tipo {@code ProductService}
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * M&eacute;todo para establecer una nueva instancia que sirve para realizar
	 * los procesos correspondientes a la gesti&oacute;n de los datos
	 * correspondiente a la logica del negocio definida
	 * 
	 * @param productService
	 *            objeto de tipo {@code ProductService}
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * M&eacute;todo encargado de proveer un servicio web que puede ser
	 * consumido por los usuarios, el cual consiste en obtener todos los tipo de
	 * producto existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code ProductType} en formato JSON
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 */
	@Path("allProducType")
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

	/**
	 * M&eacute;todo encargado de proveer un servicio web que puede ser
	 * consumido por los usuarios, el cual consiste en obtener todos los
	 * productos existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Product} en formato JSON
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	@Path("allProducts")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Product> getAllProducts() throws IWDaoException,
			IWServiceException, RemoteException {

		List<Product> productList = new ArrayList<Product>();

		try {

			productList = productService.getAllProducts();

		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}

		return productList;
	}
}
