package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.SolicitudeType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface SolicitudeTypeDAO {

	// Entrega la lista de tipo de solicitudes existentes en la base de datos
	public List<SolicitudeType> get() throws IWDaoException;

	// Entrega los datos de untipo de solicitud dado su codigo
	public SolicitudeType obtener(String idSolicitudType) throws IWDaoException;

}
