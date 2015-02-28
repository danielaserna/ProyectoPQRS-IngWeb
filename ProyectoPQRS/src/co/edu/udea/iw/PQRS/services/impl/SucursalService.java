package co.edu.udea.iw.PQRS.services.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.PQRS.dao.SucursalDAO;
import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;
import co.edu.udea.iw.PQRS.services.ISucursalService;

public class SucursalService implements ISucursalService {

	private SucursalDAO sucursalDAOHibernate;

	public SucursalDAO getSucursalDAOHibernate() {
		return sucursalDAOHibernate;
	}

	public void setSucursalDAOHibernate(SucursalDAO sucursalDAOHibernate) {
		this.sucursalDAOHibernate = sucursalDAOHibernate;
	}

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
