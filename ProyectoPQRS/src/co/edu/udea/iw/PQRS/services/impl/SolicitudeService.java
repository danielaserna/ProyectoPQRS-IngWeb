package co.edu.udea.iw.PQRS.services.impl;

import java.util.List;

import co.edu.udea.iw.PQRS.dao.SolicitudeDAO;
import co.edu.udea.iw.PQRS.dao.SolicitudeTypeDAO;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.ISolicitudeService;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos que sirven de apoyo para efectuar los procesos definidos en la
 * capa de negocio con respecto a la gesti&oacute;n de la entidad
 * {@code Solicitude}
 * 
 * <p>
 * Los m&eacute;todos expuestos para la gesti&oacute;n de los procesos de
 * negocio con respecto a las entidades perteneceientes a la clase
 * {@code Client} son aquellos que fueron definidos en la interfaz
 * {@code ISolicitudeService}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Yefry Alexis Calderon Yepes
 * @author Daniela Serna Buitrago
 */
public class SolicitudeService implements ISolicitudeService {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos de
	 * las instancias {@code Solicitude} con respecto a la capa que define el
	 * contexto de persistencia de la aplicaci&oacute;n
	 */
	private SolicitudeDAO solicitudeDAOHibernate;
	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos de
	 * las instancias {@code SolicitudeType} con respecto a la capa que define
	 * el contexto de persistencia de la aplicaci&oacute;n
	 */
	private SolicitudeTypeDAO solicitudeTypeDAOHibernate;

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar la
	 * gesti&oacute;n de los datos con respecto a la capa que define el contexto
	 * de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code SolicitudeDAO}.
	 * 
	 * @return Instancia de tipo {@code SolicitudeDAO} para acceder a los datos
	 *         de la capa de persistencia
	 * @return
	 */
	public SolicitudeDAO getSolicitudeDAOHibernate() {
		return solicitudeDAOHibernate;
	}

	/**
	 * M&eacute;todo para establecer una instancia que servir&aacute; para
	 * realizar la gesti&oacute;n de los datos con respecto a la capa que define
	 * el contexto de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code SolicitudeDAOHibernate}.
	 * 
	 * @param solicitudeDAOHibernate
	 *            instacia de tipo {@code SolicitudeDAOHibernate} que servira
	 *            para el acceso a loa datos de persistencia
	 */
	public void setSolicitudeDAOHibernate(SolicitudeDAO solicitudeDAOHibernate) {
		this.solicitudeDAOHibernate = solicitudeDAOHibernate;
	}

	/**
	 * M&eacute;todo para obtener la instancia que sirve para realizar la
	 * gesti&oacute;n de los datos con respecto a la capa que define el contexto
	 * de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code SolicitudeTypeDAOHibernate}.
	 * 
	 * @return Instancia de tipo {@code SolicitudeTypeDAO} para acceder a los
	 *         datos de la capa de persistencia
	 * @return
	 */
	public SolicitudeTypeDAO getSolicitudeTypeDAOHibernate() {
		return solicitudeTypeDAOHibernate;
	}

	/**
	 * M&eacute;todo para establecer una instancia que servir&aacute; para
	 * realizar la gesti&oacute;n de los datos con respecto a la capa que define
	 * el contexto de persistencia en la aplicaci&oacute;n para la entidad
	 * {@code SolicitudeTypeDAOHibernate}.
	 * 
	 * @param solicitudeTypeDAOHibernate
	 *            instacia de tipo {@code SolicitudeTypeDAOHibernate} que
	 *            servira para el acceso a loa datos de persistencia
	 */
	public void setSolicitudeTypeDAOHibernate(
			SolicitudeTypeDAO solicitudeTypeDAOHibernate) {
		this.solicitudeTypeDAOHibernate = solicitudeTypeDAOHibernate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.services.ISolicitudeService#insertSolicitude(java
	 * .lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void insertSolicitude(String description, String solicitudeType,
			String idSucursal, String idNumber, String idProduct)
			throws IWDaoException, IWServiceException {

		Solicitude solicitude = new Solicitude();

		if (description == null || "".equals(description)) {
			throw new IWServiceException(
					"La descripción de la solicitud no puede ser nula o vacia");
		}

		if (solicitudeType == null || "".equals(solicitudeType)) {
			throw new IWServiceException(
					"Debe elegir un tipo de solicitud, no puede ser nulo o vacio");
		}
		if (idSucursal == null || "".equals(idSucursal)) {
			throw new IWServiceException(
					"La identificacion de la sucursal no puede ser vacia o nula");
		}

		solicitude.setDescription(description);

		Client client = new Client();
		client.setIdNumber(Integer.parseInt(idNumber));

		Product product = new Product();
		product.setIdProduct(Integer.parseInt(idProduct));
		solicitude.setIdNumber(client);
		solicitude.setIdProduct(product);

		SolicitudeType typeSolicitude = new SolicitudeType();
		typeSolicitude.setIdSolicitudType(solicitudeType);
		solicitude.setSolicitudeType(typeSolicitude);

		Sucursal sucursal = new Sucursal();
		sucursal.setIdSucursal(Integer.parseInt(idSucursal));

		solicitude.setIdSucursal(sucursal);

		solicitudeDAOHibernate.insert(solicitude);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.services.ISolicitudeService#getAll()
	 */
	@Override
	public List<Solicitude> getAll() throws IWDaoException, IWServiceException {

		List<Solicitude> solicitudeList = null;

		solicitudeList = solicitudeDAOHibernate.get();

		if (solicitudeList == null || solicitudeList.size() == 0) {
			throw new IWServiceException(
					"No existen solicitudes en la base datos");
		}

		return solicitudeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.services.ISolicitudeService#deleteSolicitude(java
	 * .lang.String)
	 */
	@Override
	public void deleteSolicitude(String idSolicitude) throws IWDaoException,
			IWServiceException {

		if (idSolicitude == null || "".equals(idSolicitude)) {
			throw new IWServiceException(
					"La identificación de la solicitud no puede ser nula");
		}

		Solicitude solicitude = solicitudeDAOHibernate.get(Integer
				.parseInt(idSolicitude));

		if (solicitude == null) {
			throw new IWServiceException("La solicitud con id : "
					+ idSolicitude
					+ "ha eliminar no existe en la base de datos");
		}
		solicitude = solicitudeDAOHibernate.delete(solicitude);

		if (solicitude != null) {
			throw new IWServiceException(
					"La solicitud no se pudo eliminar satisfactoriamente");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.services.ISolicitudeService#getAllSolicitudeType()
	 */
	@Override
	public List<SolicitudeType> getAllSolicitudeType() throws IWDaoException,
			IWServiceException {

		List<SolicitudeType> solicitudeTypeList;

		solicitudeTypeList = solicitudeTypeDAOHibernate.get();

		if (solicitudeTypeList == null) {
			throw new IWServiceException(
					"Error al consultar todos los tipo de solicitud en la base de datos");
		}

		return solicitudeTypeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.edu.udea.iw.PQRS.services.ISolicitudeService#get(java.lang.Integer)
	 */
	@Override
	public Solicitude get(Integer idSolicitude) throws IWDaoException,
			IWServiceException {
		Solicitude solicitude = null;

		solicitude = solicitudeDAOHibernate.get(idSolicitude);

		return (solicitude);
	}

}
