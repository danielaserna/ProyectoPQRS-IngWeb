package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

public interface ISolicitudeService {

	/**
	 * 
	 * @param description
	 * @param idSolicitude
	 * @param solicitudeType
	 * @param idSucursal
	 * @param idNumber
	 * @param idProduct
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public void insertSolicitude(String description, String solicitudeType,
			String idSucursal, String idNumber, String idProduct)
			throws IWDaoException, IWServiceException;

	/**
	 * 
	 * @return
	 * @throws IWDaoException
	 * @throws IWServiceException
	 */
	public List<Solicitude> getAll() throws IWDaoException, IWServiceException;

	/**
	 * 
	 * @param idSolicitude
	 */
	public void deleteSolicitude(String idSolicitude) throws IWDaoException,
			IWServiceException;

	/**
	 * 
	 * @return
	 */
	public List<SolicitudeType> getAllSolicitudeType() throws IWDaoException,
			IWServiceException;
}
