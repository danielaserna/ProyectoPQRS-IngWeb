package co.edu.udea.iw.PQRS.services;

import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

public interface IClientService {

	/**
	 * Metodo Utilizado para guardar un cliente dentro de la base de datos,
	 * realizando todas las validaciones necesarias
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
			String cellphoneNumber, String email, Integer idNumber,
			String phoneNumber, String profile) throws IWDaoException,
			IWServiceException;

	/**
	 * 
	 * @param idNumber
	 * @return
	 */
	public Client findUserByLogin(String idNumber) throws IWDaoException,
			IWServiceException;
}
