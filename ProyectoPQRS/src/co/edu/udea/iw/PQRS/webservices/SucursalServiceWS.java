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

/**
 * Clase que establece los m&eacute;todos que podran ejecutar los procesos que
 * involucran los servicios web que estan relacionados con instancias de la
 * clase {@code Sucursal} y de ese modo, podr&aacute;n realizar paso de
 * informaci&oacute;n y de mensajes y poder cumplir asi con los procesos
 * negocios definidos para el sistema.
 * 
 * @since JDK 1.8
 * @since Jersey 1.4
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 *
 */
@Path("Sucursal")
@Component
public class SucursalServiceWS {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos y
	 * procesos de negocio para las instancias {@code Sucursal} con respecto a
	 * las reglas de negocio definidas
	 */
	@Autowired
	private SucursalService sucursalService;

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar los
	 * procesos correspondientes a la gesti&oacute;n de los datos.
	 * 
	 * @return objeto de tipo {@code SucursalService}
	 */
	public SucursalService getSucursalService() {
		return sucursalService;
	}

	/**
	 * M&eacute;todo para establecer una nueva instancia que sirve para realizar
	 * los procesos correspondientes a la gesti&oacute;n de los datos
	 * correspondiente a la logica del negocio definida
	 * 
	 * @param sucursalService
	 *            objeto de tipo {@code SucursalService}
	 */
	public void setSucursalService(SucursalService sucursalService) {
		this.sucursalService = sucursalService;
	}

	/**
	 * M&eacute;todo encargado de proveer un servicio web que puede ser
	 * consumido por los usuarios, el cual consiste en obtener todas las
	 * sucursales existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Sucursal} en formato JSON
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
