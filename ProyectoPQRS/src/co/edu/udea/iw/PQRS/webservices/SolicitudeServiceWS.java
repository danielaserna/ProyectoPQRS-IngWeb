package co.edu.udea.iw.PQRS.webservices;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.PQRS.dto.Solicitude;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Solicitude> getAll() throws RemoteException, IWDaoException, IWServiceException {

		List<Solicitude> solicitudeList = new ArrayList<Solicitude>();

		try {
			solicitudeList = solicitudeService.getAll();
		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}

		return solicitudeList;
	}

}
