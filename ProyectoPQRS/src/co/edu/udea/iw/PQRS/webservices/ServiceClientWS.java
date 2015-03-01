package co.edu.udea.iw.PQRS.webservices;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.ClientService;

@Path("Client")
@Component
public class ServiceClientWS {

	@Autowired
	private ClientService clientService;

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("login")
	public Client getClient(@QueryParam("idNumber") String idNumber)
			throws RemoteException, IWServiceException {

		Client client = new Client();
		try {
			client = clientService.findUserByLogin(idNumber);
		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}
		return client;
	}

	@Path("insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String insertClient(@QueryParam("fullName") String fullName,
			@QueryParam("lastName") String lastName,
			@QueryParam("cellPhoneNumber") String cellPhoneNumber,
			@QueryParam("email") String email,
			@QueryParam("idNumber") String idNumber,
			@QueryParam("phoneNumber") String phoneNumber,
			@QueryParam("profile") String profile) throws RemoteException,
			IWServiceException {

		try {
			clientService.saveClient(fullName, lastName, cellPhoneNumber,
					email, idNumber, phoneNumber, profile);
		} catch (IWDaoException | IWServiceException e) {
			return "Error";
		}

		return "OK";
	}

}
