package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Interfaz definida para establecer los m&eacute;todos que se podr&aacute;n
 * realizar sobre los datos en las instancias pertenecientes a la clase
 * {@code City}, sobre el contexto de persistencia definido para el aplicativo.
 * <p>
 * Esta interfaz define los m&eacute;todos o funciones que se deber&aacute;n
 * implementar para dar soporte a las operaciones requeridas por la
 * l&oacute;gica del negocio sobre las entidades o instancias persistences de la
 * clase {@code City}.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface CityDAO {

	/**
	 * M&eacute;todo que sirve para ejecutar una consulta que retorne todos los
	 * objetos de tipo {@code City} existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code City}
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public List<City> get() throws IWDaoException;

	/**
	 * M&eacute;todo que sirve para realizar una consulta y recuperar de la base
	 * de datos una ciudad, al buscarla por su identificador, el cual es el
	 * codigo de la misma
	 * 
	 * @param code
	 *            N&uacute;mero que identifica la ciudad, por su c&oacute;digo
	 * @return Instancia de tipo {@code City} que encapsula toda la
	 *         informaci&oacute;n correspondiente
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public City obtener(Integer code) throws IWDaoException;
}
