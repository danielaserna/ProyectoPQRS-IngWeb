package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

/**
 * Interfaz definida para establecer los m&eacute;todos que sepodr&acute;n
 * ejecutar sobre los procesos que involucran instancias pertenecientes a la
 * clase {@code Sucursal} y de ese modo, realizar la gesti&oacute;n de los
 * diversos datos sobre el contexto de persistencia para el sistema.
 * <p>
 * Esta interfaz brinda los metodos que debe soportar la logica del negocio de
 * la aplicai&oacute;n y que requieren comunicaci&oacute;n con la capa encargada
 * de traer estos datos.
 * 
 * @since JDK 1.7
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ISucursalService {

	/**
	 * M&eacute;todo encargado de realizar la consulta para obtener todas las
	 * instancias de tipo {@code Sucursal} que se encuentran en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Sucursal} con su respectiva
	 *         informaci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public List<Sucursal> getAllSucursals() throws IWDaoException,
			IWServiceException;

}
