package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface SolicitudeDAO {

	// Inserta una solicitud en la base de datos
	public Solicitude insert(Solicitude solicitude) throws IWDaoException;

	// Actualiza una solicitud en la base de datos
	public Solicitude update(Solicitude solicitude) throws IWDaoException;

	// Elimina una solicitud de la base de datos
	public Solicitude delete(Solicitude solicitude) throws IWDaoException;

	// Entrega la lista de solicitudes existentes en la base de datos
	public List<Solicitude> get() throws IWDaoException;

	// Entrega los datos de una solicitud dado su identificador
	public Solicitude get(Integer idSolicitude) throws IWDaoException;
}
