package co.edu.udea.iw.PQRS.services;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Sucursal;
import co.edu.udea.iw.PQRS.exception.IWDaoException;
import co.edu.udea.iw.PQRS.exception.IWServiceException;

public interface ISucursalService {

	/**
	 * M&eacute;todo encargado de realizar la consulta para obtener todas las
	 * instancias de tipo {@code Sucursal} que se encuentran en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Sucursal} con su respectiva
	 *         informaci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 * @throws IWServiceException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la logica del negocio definida para esta clase
	 */
	public List<Sucursal> getAllSucursals() throws IWDaoException,
			IWServiceException;

}
