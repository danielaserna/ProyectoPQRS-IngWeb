package co.edu.udea.iw.PQRS.services;

import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

/**
 * Interfaz definida para establecer los m&eacute;todos que sepodr&acute;n
 * ejecutar sobre los procesos que involucran instancias pertenecientes a la
 * clase {@code Client} y de ese modo, realizar la gesti&oacute;n de los
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
 * @author Yefry Alexis Calderon Yepes
 * @author Daniela Serna Buitrago
 *
 */
public interface IClientService {

	/**
	 * M&eacute;todo Utilizado para guardar una instacion de tipo
	 * {@code Client } dentro de la base de datos. Este m&eacute;todo se
	 * encargara de realizar todas las validaciones necesarias para evitar
	 * problemas en las capas inferiores de la aplicaci&oacute;n.
	 * 
	 * @param fullname
	 *            nombre completo del cliente
	 * @param lastName
	 *            apellido del cliente
	 * @param cellphoneNumber
	 *            n&uacute;mero de celular del cliente
	 * @param email
	 *            correo electronico del cliente
	 * @param idNumber
	 *            n&uacute;mero de identificaci&oacute;n del cliente
	 * @param phoneNumber
	 *            n&uacute;mero fijo del cliente
	 * @param profile
	 *            perfil o rol que se le dara al cliente dentro de la
	 *            aplica&oacute;n
	 */
	public void saveClient(String fullname, String lastName,
			String cellphoneNumber, String email, String idNumber,
			String phoneNumber, String profile) throws IWDaoException,
			IWServiceException;

	/**
	 * M&eacute;todo encargado de buscar y validar la identificaci&oacute;n de
	 * un cliente, dentro del sistema y asi brindarle las opciones que
	 * seg&uacute;n el rol que este tenga dentro del sistema, pueda realizar,
	 * bien sea realizar una solicitud para el caso de un cliente o responder
	 * las solicitudes, en el caso de un gerente de cuentas corporativas
	 * 
	 * @param idNumber
	 *            n&uacute;mero de identificaci&oacute;n del cliente, que lo
	 *            identificara dentro del sistema
	 * @return un objeto que encapsula toda la informaci&oacute;n de un cliente
	 */
	public Client findUserByLogin(String idNumber) throws IWDaoException,
			IWServiceException;

}
