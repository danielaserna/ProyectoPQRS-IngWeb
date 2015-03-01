package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Interfaz definida para establecer los m&eacute;todos que se podr&aacute;n
 * realizar sobre los datos en las instancias pertenecientes a la clase
 * {@code ProductType}, sobre el contexto de persistencia definido para el
 * aplicativo.
 * <p>
 * Esta interfaz define los m&eacute;todos o funciones que se deber&aacute;n
 * implementar para dar soporte a las operaciones requeridas por la
 * l&oacute;gica del negocio sobre las entidades o instancias persistences de la
 * clase {@code ProductType}.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ProductTypeDAO {

	/**
	 * M&eacute;todo que sirve para ejecutar una consulta que retorne todos los
	 * objetos de tipo {@code ProductType} existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code ProductType}
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public List<ProductType> get() throws IWDaoException;

	/**
	 * M&eacute;todo que sirve para realizar una consulta y recuperar de la base
	 * de datos un objeto de tipo {@code ProductType}
	 * 
	 * @param type
	 *            Tipo de producto que se desea buscar
	 * @return Instancia de tipo {@code ProductType} que encapsula toda la
	 *         informaci&oacute;n correspondiente
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada cuando alg&uacute;n error ha surgido
	 *             en la recuperaci&oacute;n de los datos
	 */
	public ProductType obtener(String type) throws IWDaoException;
}
