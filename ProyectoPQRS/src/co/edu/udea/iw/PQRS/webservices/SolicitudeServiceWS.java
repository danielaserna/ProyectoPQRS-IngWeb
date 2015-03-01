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

@Path("Solicitude")
@Component
public class SolicitudeServiceWS {

	@Autowired
	private SolicitudeService solicitudeService;

	public SolicitudeService getSolicitudeService() {
		return solicitudeService;
	}

	public void setSolicitudeService(SolicitudeService solicitudeService) {
		this.solicitudeService = solicitudeService;
	}

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
