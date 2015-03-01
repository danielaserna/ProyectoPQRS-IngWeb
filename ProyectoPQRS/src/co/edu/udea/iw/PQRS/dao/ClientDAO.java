package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Interfaz definida para establecer los m&eacute;todos que se podr&aacute;n
 * realizar sobre los datos en las instancias pertenecientes a la clase
 * {@code Client}, sobre el contexto de persistencia definido para el
 * aplicativo.
 * <p>
 * Esta interfaz define los m&eacute;todos o funciones que se deber&aacute;n
 * implementar para dar soporte a las operaciones requeridas por la
 * l&oacute;gica del negocio sobre las entidades o instancias persistences de la
 * clase {@code Client}.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ClientDAO {

	/**
	 * M&eacute;todo que realiza la consulta correspondiente a insertar un
	 * objeto de tipo {@code Client} en la base de datos
	 * 
	 * @param client
	 *            objeto tipo {@code Client} con toda la informaci&acute:n
	 *            correspondiente a ser almacenada
	 * @return instancia tipo {@code Client}
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public Client insert(Client client) throws IWDaoException;

	/**
	 * M&eacute;todo encargado de actualizar los datos correspondientes a un
	 * objeto tipo {@code Client} en la base de datos
	 * 
	 * @param client
	 *            instancia de tipo {@code Client} la cual se le actualizara los
	 *            datos
	 * @return objeto de tipo {@code Client}
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public Client update(Client client) throws IWDaoException;

	/**
	 * M&eacute;todo encargado de ejecutar la sentencia para eliminar un cliente
	 * de la base de datos
	 * 
	 * @param client
	 *            instancia de tipo {@code Client} que se desea eliminar de la
	 *            base de datos
	 * @return
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public Client delete(Client client) throws IWDaoException;

	/**
	 * M&eacute;todo que sirve para ejecutar una consulta que retorne todos los
	 * objetos de tipo {@code Client} existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Client} con su respectiva
	 *         informaci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public List<Client> get() throws IWDaoException;

	/**
	 * M&eacute;todo que sirve para realizar una consulta y recuperar de la base
	 * de datos un objeto de tipo {@code Client}, b&uacute;squeda que se realiza
	 * por el n&uacute;mero de identificaci&oacute;n del cliente
	 * 
	 * @param idNumber
	 *            N&uacute;mero de identificaci&oacute;n del cliente que se
	 *            desea recuperar
	 * @return instancia de la clase {@code Client} existente en la base de
	 *         datos
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public Client get(Integer idNumber) throws IWDaoException;
}
