package co.edu.udea.iw.PQRS.webservices;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.emailsender.EmailSender;
import co.edu.udea.iw.PQRS.emailsender.exception.PQRSEmailException;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.SolicitudeService;

/**
 * Clase que establece los m&eacute;todos que podran ejecutar los procesos que
 * involucran los servicios web que estan relacionados con instancias de la
 * clase {@code Solicitude} y de ese modo, podr&aacute;n realizar paso de
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
@Path("Solicitude")
@Component
public class SolicitudeServiceWS {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos y
	 * procesos de negocio para las instancias {@code Solicitude} con respecto a
	 * las reglas de negocio definidas
	 */
	@Autowired
	private SolicitudeService solicitudeService;

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar los
	 * procesos correspondientes a la gesti&oacute;n de los datos.
	 * 
	 * @return instancia de tipo {@code SolicitudeService}
	 */
	public SolicitudeService getSolicitudeService() {
		return solicitudeService;
	}
	
	/**
	 * M&eacute;todo para establecer una nueva instancia que sirve para realizar
	 * los procesos correspondientes a la gesti&oacute;n de los datos
	 * correspondiente a la logica del negocio definida
	 * 
	 * @param solicitudeService
	 *            objeto de tipo {@code SolicitudeService}
	 */
	public void setSolicitudeService(SolicitudeService solicitudeService) {
		this.solicitudeService = solicitudeService;
	}

	/**
	 * M&eacute;todo encargado de proveer un servicio web que permite insertar 
	 * una solicitud en  la base de datos
	 * @param description
	 * @param solicitudeType
	 * @param idSucursal
	 * @param idNumber
	 * @param idProduct
	 * @return String que informa si se insert&oacute; de manera exitosa 
	 * 			un objeto de tipo {@code Solicitud}
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
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public String insertSolicitude(
			@QueryParam("description") String description,
			@QueryParam("solicitudeType") String solicitudeType,
			@QueryParam("idSucursal") String idSucursal,
			@QueryParam("idNumber") String idNumber,
			@QueryParam("idProduct") String idProduct) throws IWDaoException,
			IWServiceException, RemoteException {

		try {
			this.getSolicitudeService().insertSolicitude(description,
					solicitudeType, idSucursal, idNumber, idProduct);
		} catch (IWDaoException | IWServiceException e) {
			return "ERROR";
		}

		return "OK";
	}

	/**
	 * M&eacute;todo encargado de proveer un servicio web que puede ser
	 * consumido por los usuarios, el cual consiste en obtener todas las
	 * solicitudes existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Solicitud} en formato JSON
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 */
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Solicitude> getAll() throws RemoteException, IWDaoException,
			IWServiceException {

		List<Solicitude> solicitudeList = new ArrayList<Solicitude>();

		try {
			solicitudeList = solicitudeService.getAll();
		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}

		return solicitudeList;
	}

	/**
	 * M&eacute;todo encargado de proveer un servicio web que puede ser
	 * consumido por los usuarios, el cual consiste en dar respuesta a las 
	 * solicitudes realizadas por el usuario
	 * 
	 * @param idSolicitude
	 * @param response
	 * @return String que informa si se insert&oacute; de manera exitosa 
	 * 			un objeto de tipo {@code Solicitud}
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 */
	@Path("solicituderesponse")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String answerSolicitude(
			@QueryParam("idSolicitude") String idSolicitude,
			@QueryParam("response") String response) throws IWDaoException,
			IWServiceException, PQRSEmailException {
		EmailSender emailSender = null;
		try {
			emailSender = new EmailSender();
		} catch (PQRSEmailException e1) {

			return ("ERROR");
		}

		try {
			Solicitude s = solicitudeService
					.get(Integer.parseInt(idSolicitude));

			if (s == null) {

				return ("ERROR");
			}

			if (emailSender != null && response != null
					&& !response.trim().equals("")) {

				emailSender.sendEmail(s, response);
			} else {
				return ("ERROR");
			}

			solicitudeService.deleteSolicitude(idSolicitude);
		} catch (Exception e) {
			return e.getMessage();
		}

		return "OK";
	}

	/**
	 * 
	 * M&eacute;todo encargado de proveer un servicio web que puede ser
	 * consumido por los usuarios, el cual consiste en obtener todas los
	 * Tipos de solicitudes existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code SolicitudType} en formato JSON
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 * @throws RemoteException
	 *             Excepci&oacute;n lanzada cuando ocurre alg&uacute;n error en
	 *             el consumo del servicio web
	 */
	@GET
	@Path("getSolicitudeType")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SolicitudeType> getAllSolicitudeType() throws IWDaoException,
			IWServiceException, RemoteException {

		List<SolicitudeType> solicitudeTypeList = null;

		try {
			solicitudeTypeList = solicitudeService.getAllSolicitudeType();
		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}

		return solicitudeTypeList;

	}

}
