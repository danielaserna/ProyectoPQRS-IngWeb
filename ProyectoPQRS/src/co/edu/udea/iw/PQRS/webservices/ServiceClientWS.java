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

/**
 * Clase que establece los m&eacute;todos que podran ejecutar los procesos que
 * involucran los servicios web que estan relacionados con instancias de la
 * clase {@code Client} y de ese modo, podr&aacute;n realizar paso de
 * informaci&oacute;n y de mensajes y poder cumplir asi con los procesos
 * negocios definidos para el sistema.
 * 
 * @since JDK 1.7
 * @since Jersey 1.4
 * 
 * @version 1.0
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 *
 */
@Path("Client")
@Component
public class ServiceClientWS {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos y
	 * procesos de negocio para las instancias {@code Client} con respecto a
	 * las reglas de negocio definidas
	 */
	@Autowired
	private ClientService clientService;

	/**
	 * M&eacute;todo encargado de proveer un servicio web que permite autenticar 
	 * un cliente en  el sistema
	 * @param idNumber
	 * @return Un objeto de tipo {@code Cliente}
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 */
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

	/**
	 * M&eacute;todo encargado de proveer un servicio web que permite insertar 
	 * un cliente en  la base de datos
	 * @param fullName
	 * @param lastName
	 * @param cellPhoneNumber
	 * @param email
	 * @param idNumber
	 * @param phoneNumber
	 * @param profile
	 * @return @return String que informa si se insert&oacute; de manera exitosa 
	 * 			un objeto de tipo {@code Cliente}
	 * @throws IWDaoException
	 * 			   Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 */
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
