package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.City;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface CityDAO {

	// Entrega la lista de ciudades existentes en la base de datos
	public List<City> get() throws IWDaoException;

	// Entrega los datos de una ciudad dado su codigo
	public City obtener(Integer code) throws IWDaoException;
}
