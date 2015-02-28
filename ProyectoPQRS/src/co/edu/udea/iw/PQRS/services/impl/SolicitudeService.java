package co.edu.udea.iw.PQRS.services.impl;

import java.util.List;

import co.edu.udea.iw.PQRS.dao.SolicitudeDAO;
import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.ISolicitudeService;

public class SolicitudeService implements ISolicitudeService {

	private SolicitudeDAO solicitudeDAOHibernate;

	public SolicitudeDAO getSolicitudeDAOHibernate() {
		return solicitudeDAOHibernate;
	}

	public void setSolicitudeDAOHibernate(SolicitudeDAO solicitudeDAOHibernate) {
		this.solicitudeDAOHibernate = solicitudeDAOHibernate;
	}

	public void insertSolicitude(String description, 
			String solicitudeType, String idSucursal, String idNumber,
			String idProduct) throws IWDaoException, IWServiceException {

		Solicitude solicitude = new Solicitude();

		if (description == null && "".equals(description)) {
			throw new IWServiceException(
					"La descripción de la solicitud no puede ser nula o vacia");
		}

		if (solicitudeType == null && "".equals(solicitudeType)) {
			throw new IWServiceException(
					"Debe elegir un tipo de solicitud, no puede ser nulo o vacio");
		}
		if (idSucursal == null && "".equals(idSucursal)) {
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

	@Override
	public List<Solicitude> getAll() throws IWDaoException, IWServiceException {

		List<Solicitude> solicitudeList = null;
		
		solicitudeList = solicitudeDAOHibernate.get();
		
		return solicitudeList;
	}

}
