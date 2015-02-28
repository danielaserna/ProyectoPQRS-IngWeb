package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

public interface ISucursalService {
	
	/**
	 * 
	 * @return
	 */
	public List<Sucursal> getAllSucursals() throws IWDaoException, IWServiceException;

}
