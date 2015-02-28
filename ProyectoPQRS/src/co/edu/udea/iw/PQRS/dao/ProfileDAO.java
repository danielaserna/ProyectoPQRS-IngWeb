package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Profile;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ProfileDAO {

	// Entrega la lista de perfiles existentes en la base de datos
	public List<Profile> get() throws IWDaoException;

	// Entrega los datos de un perfil dado su codigo
	public Profile obtener(String profile) throws IWDaoException;
}
