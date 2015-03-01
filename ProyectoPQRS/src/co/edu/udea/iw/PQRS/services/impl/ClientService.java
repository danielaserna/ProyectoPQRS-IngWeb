package co.edu.udea.iw.PQRS.services.impl;

import co.edu.udea.iw.PQRS.dao.hibernate.ClientDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.IClientService;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos que sirven de apoyo para efectuar los procesos definidos en la
 * capa de negocio con respecto a la gesti&oacute;n de la entidad {@code Client}
 * .
 * <p>
 * Los m&eacute;todos expuestos para la gesti&oacute;n de los procesos de
 * negocio con respecto a las entidades perteneceientes a la clase
 * {@code Client} son aquellos que fueron definidos en la interfaz
 * {@code IClientService}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Yefry Alexis Calderon Yepes
 * @author Daniela Serna Buitrago
 *
 */
public class ClientService implements IClientService {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos de
	 * las instancias {@code Client} con respecto a la capa que define el
	 * contexto de persistencia de la aplicaci&oacute;n
	 */
	private ClientDAOHibernate clientDAO;

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar la
	 * gesti&oacute;n de los datos con respecto a la capa que define el contexto
	 * de persistencia en la aplicaci&oacute;n para la entidad {@code Client}.
	 * 
	 * @return Instancia de tipo {@code ClientDAOHibernate} para acceder a los
	 *         datos de la capa de persistencia
	 */
	public ClientDAOHibernate getClientDAO() {
		return clientDAO;
	}

	/**
	 * M&eacute;todo para establecer una instancia que servir&aacute; para
	 * realizar la gesti&oacute;n de los datos con respecto a la capa que define
	 * el contexto de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code Client}.
	 * 
	 * @param clientDAO
	 *            instacia de tipo {@code ClientDAOHibernate} que servira para
	 *            el acceso a loa datos de persistencia
	 */
	public void setClientDAO(ClientDAOHibernate clientDAO) {
		this.clientDAO = clientDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.services.IClientService#saveClient(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void saveClient(String fullname, String lastName,
			String cellphoneNumber, String email, String idNumber,
			String phoneNumber, String profile) throws IWDaoException,
			IWServiceException {

		Client client = new Client();
		if (idNumber == null || "".equals(idNumber)) {
			throw new IWServiceException(
					"La identificación del cliente no puede ser nula o vacia");
		}
		if (fullname == null || "".equals(fullname)) {
			throw new IWServiceException(
					"El nombre del cliente no puede ser nulo o vacio");
		}
		if (lastName == null || "".equals(lastName)) {
			throw new IWServiceException(
					"El apellido del cliente no puede ser nulo o vacio");
		}
		if (email == null || "".equals(email)) {
			throw new IWServiceException(
					"El correo electronico del cliente no puede ser nulo o vacio");
		}
		if (cellphoneNumber == null || "".equals(cellphoneNumber)) {
			throw new IWServiceException(
					"El telefono celular del cliente no puede ser nulo o vacio");
		}

		client.setFullName(fullname);
		client.setLastName(lastName);
		client.setIdNumber(new Integer(idNumber));
		client.setEmail(email);
		client.setCellphoneNumber(cellphoneNumber);
		Profile profileAux = new Profile();
		profileAux.setProfile(profile);
		client.setProfile(profileAux);
		client.setPhoneNumber(phoneNumber);

		clientDAO.insert(client);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.services.IClientService#findUserByLogin(java.lang
	 * .String)
	 */
	@Override
	public Client findUserByLogin(String idNumber) throws IWDaoException,
			IWServiceException {

		Client client = null;

		if (idNumber == null || "".equals(idNumber)) {
			throw new IWServiceException(
					"La identificacion del usuario no puede ser vacia o nula o no se encontro el cliente");
		}

		client = clientDAO.get(Integer.parseInt(idNumber));

		if (client == null) {
			throw new IWServiceException("Usuario o contraseña no validos");
		}

		return client;
	}

}
