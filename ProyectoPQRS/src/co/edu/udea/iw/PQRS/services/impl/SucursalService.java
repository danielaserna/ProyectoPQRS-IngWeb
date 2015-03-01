package co.edu.udea.iw.PQRS.services.impl;

import java.util.List;

import co.edu.udea.iw.PQRS.dao.SucursalDAO;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.ISucursalService;

/**
 * Clase que define la implementaci&oacute;n espec&iacute;fica para los
 * m&eacute;todos que sirven de apoyo para efectuar los procesos definidos en la
 * capa de negocio con respecto a la gesti&oacute;n de la entidad
 * {@code Sucursal}
 * 
 * <p>
 * Los m&eacute;todos expuestos para la gesti&oacute;n de los procesos de
 * negocio con respecto a las entidades perteneceientes a la clase
 * {@code Client} son aquellos que fueron definidos en la interfaz
 * {@code ISucursalService}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Yefry Alexis Calderon Yepes
 * @author Daniela Serna Buitrago
 */
public class SucursalService implements ISucursalService {

	/**
	 * Instancia requerida para poder realizar la gesti&oacute;n de los datos de
	 * las instancias {@code Sucursal} con respecto a la capa que define el
	 * contexto de persistencia de la aplicaci&oacute;n
	 */
	private SucursalDAO sucursalDAOHibernate;

	public SucursalDAO getSucursalDAOHibernate() {
		return sucursalDAOHibernate;
	}

	public void setSucursalDAOHibernate(SucursalDAO sucursalDAOHibernate) {
		this.sucursalDAOHibernate = sucursalDAOHibernate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.edu.udea.iw.PQRS.services.ISucursalService#getAllSucursals()
	 */
	@Override
	public List<Sucursal> getAllSucursals() throws IWDaoException,
			IWServiceException {

		List<Sucursal> sucursalList = sucursalDAOHibernate.get();

		if (sucursalList == null || sucursalList.size() == 0) {
			throw new IWServiceException(
					"No existen sucursales en la base de datos");
		}

		return sucursalList;
	}

}
