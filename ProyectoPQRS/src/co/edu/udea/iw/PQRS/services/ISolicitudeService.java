package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

/**
 * Interfaz definida para establecer los m&eacute;todos que sepodr&acute;n
 * ejecutar sobre los procesos que involucran instancias pertenecientes a la
 * clase {@code Solicitude} y de ese modo, realizar la gesti&oacute;n de los
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
 * @author Yefry Alexis Calder&oacute;n Yepes
 * @author Daniela Serna Buitrago
 *
 */
public interface ISolicitudeService {

	/**
	 * M&eacute;todo encargado de la comunicaci&oacute;n con la capa de
	 * persistencia con el fin de guardar una nueva instancia de
	 * {@code Solicitude} realizando todas las validaciones necesarias,
	 * definidas en la logica del negocio.
	 * 
	 * @param description
	 *            cadena de texto, que representa la descripci&oacute;n de la
	 *            solicitud que se va a guardar
	 * @param solicitudeType
	 *            N&uacute;mero que representa el tipo de solicitud, asi:
	 *            1:peticion 2:queja 3:reclamo 4:sugerencia
	 * @param idSucursal
	 *            N&uacute;mero de identificaci&oacute;n de la sucursal a la que
	 *            se realizar&acute; la solicitud
	 * @param idNumber
	 *            N&uacute;mero de identificaci&oacute;n del cliente que realiza
	 *            la solicitud
	 * @param idProduct
	 *            N&uacute;mero que identifica al producto sobre el que se
	 *            realiza la solicitud
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public void insertSolicitude(String description, String solicitudeType,
			String idSucursal, String idNumber, String idProduct)
			throws IWDaoException, IWServiceException;

	/**
	 * M&eacute;todo encargado de realizar la consulta para obtener todas las
	 * instancias de tipo {@code Solicitude} que se encuentran en la base de
	 * datos
	 * 
	 * @return lista de objetos de tipo {@code Solicitude} con su respectiva
	 *         informaci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public List<Solicitude> getAll() throws IWDaoException, IWServiceException;

	/**
	 * M&etodo encargado de realizar la comunicaci&oacute;n con la capa de
	 * persistencia para llevar a cabo la operaci&oacute;n para eliminar una
	 * solicitud de la base de datos
	 * 
	 * @param idSolicitude
	 *            N&uacute;mero que identifica la solicitud que se desea
	 *            eliminar
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public void deleteSolicitude(String idSolicitude) throws IWDaoException,
			IWServiceException;

	/**
	 * M&eacute;todo encargado de realizar la consulta para obtener todas las
	 * instancias de tipo {@code SolicitudeType} que se encuentran en la base de
	 * datos.
	 * 
	 * @return Lista de objetos de tipo {@code SolicitudeType} con su respectiva
	 *         informaci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public List<SolicitudeType> getAllSolicitudeType() throws IWDaoException,
			IWServiceException;
}
