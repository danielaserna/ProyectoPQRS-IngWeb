package co.edu.udea.iw.PQRS.webservices;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.impl.SucursalService;

@Path("Sucursal")
@Component
public class SucursalServiceWS {

	@Autowired
	private SucursalService sucursalService;

	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Sucursal> getAllSucursals() throws IWDaoException,
			IWServiceException, RemoteException {

		List<Sucursal> sucursalList = new ArrayList<Sucursal>();

		try {
			sucursalList = sucursalService.getAllSucursals();
		} catch (IWDaoException e) {
			throw new RemoteException(e.getMessage());
		}

		return sucursalList;

	}

}
