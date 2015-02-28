package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface SucursalDAO {

	// Entrega la lista de Sucursales existentes en la base de datos
	public List<Sucursal> get() throws IWDaoException;

	// Entrega los datos de una sucursal dado su codigo
	public Sucursal obtener(Integer idSucursal) throws IWDaoException;

}
