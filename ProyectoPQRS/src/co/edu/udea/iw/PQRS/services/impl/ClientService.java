package co.edu.udea.iw.PQRS.services.impl;

import co.edu.udea.iw.PQRS.dao.hibernate.ClientDAOHibernate;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.IClientService;

public class ClientService implements IClientService {

	private ClientDAOHibernate clientDAO;

	public ClientDAOHibernate getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAOHibernate clientDAO) {
		this.clientDAO = clientDAO;
	}

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

	public Client findUserByLogin(String idNumber) throws IWDaoException,
			IWServiceException {

		Client client = null;

		if (idNumber == null || "".equals(idNumber)) {
			throw new IWServiceException(
					"La identificacion del usuario no puede ser vacia o nula o no se encontro el cliente");
		}

		client = clientDAO.get(Integer.parseInt(idNumber));
		
		if(client == null){
			throw new IWServiceException("Usuario o contraseña no validos");
		}

		return client;
	}

}
