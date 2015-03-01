package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

/**
 * Interfaz definida para establecer los m&eacute;todos que sepodr&acute;n
 * ejecutar sobre los procesos que involucran instancias pertenecientes a la
 * clase {@code Product} y de ese modo, realizar la gesti&oacute;n de los
 * diversos datos sobre el contexto de persistencia para el sistema.
 * <p>
 * Esta interfaz brinda los metodos que debe soportar la logica del negocio de
 * la aplicai&oacute;n y que requieren comunicaci&oacute;n con la capa encargada
 * de traer estos datos.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Yefry Alexis Calderon Yepes
 * @author Daniela Serna Buitrago
 *
 */
public interface IProductService {

	/**
	 * M&eacute;todo encargado de realizar la consulta para obtener todos los
	 * tipos de producto que se encuentran en la base de datos, con el fin de
	 * mostrarle estos al usuario a la hora de realizar la respectiva solicitud
	 * 
	 * @return Lista con todos los tipos de producto existentes
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public List<ProductType> getAllProductType() throws IWDaoException,
			IWServiceException;

	/**
	 * M&eacute;todo encargado de realizar la consulta para obtener todos los
	 * productos que se encuentran en la base de datos, con el fin de mostrarle
	 * estos al usuario a la hora de realizar la respectiva solicitud
	 * 
	 * @return objeto tipo lista con instancias de la clase {@code Product} con
	 *         su respectiva descripci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public List<Product> getAllProducts() throws IWDaoException,
			IWServiceException;
}
