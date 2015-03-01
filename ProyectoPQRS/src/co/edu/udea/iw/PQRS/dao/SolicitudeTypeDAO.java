package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Interfaz definida para establecer los m&eacute;todos que se podr&aacute;n
 * realizar sobre los datos en las instancias pertenecientes a la clase
 * {@code SolicitudeType}, sobre el contexto de persistencia definido para el
 * aplicativo.
 * <p>
 * Esta interfaz define los m&eacute;todos o funciones que se deber&aacute;n
 * implementar para dar soporte a las operaciones requeridas por la
 * l&oacute;gica del negocio sobre las entidades o instancias persistences de la
 * clase {@code SolicitudeType}.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface SolicitudeTypeDAO {

	/**
	 * M&eacute;todo que sirve para ejecutar una consulta que retorne todos los
	 * objetos de tipo {@code SolicitudeType} existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code SolicitudeType}
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public List<SolicitudeType> get() throws IWDaoException;

	/**
	 * M&eacute;todo que sirve para realizar una consulta y recuperar de la base
	 * de datos un objeto de tipo {@code SolicitudeType}
	 * 
	 * @param idSolicitudType
	 *            cadena de texto con la identificaci&oacute;n del tipo de
	 *            solicitud
	 * @return objeto de tipo {@code SolicitudeType} con toda la
	 *         informaci&oacute;n correspondiente
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public SolicitudeType obtener(String idSolicitudType) throws IWDaoException;

}
