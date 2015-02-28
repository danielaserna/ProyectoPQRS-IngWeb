package co.edu.udea.iw.PQRS.webservices;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
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

}
