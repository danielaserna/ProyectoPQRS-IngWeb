package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * Interfaz definida para establecer los m&eacute;todos que se podr&aacute;n
 * realizar sobre los datos en las instancias pertenecientes a la clase
 * {@code Product}, sobre el contexto de persistencia definido para el
 * aplicativo.
 * <p>
 * Esta interfaz define los m&eacute;todos o funciones que se deber&aacute;n
 * implementar para dar soporte a las operaciones requeridas por la
 * l&oacute;gica del negocio sobre las entidades o instancias persistences de la
 * clase {@code Product}.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ProductDAO {

	/**
	 * M&eacute;todo que sirve para ejecutar una consulta que retorne todos los
	 * objetos de tipo {@code Product} existentes en la base de datos
	 * 
	 * @return lista de objetos de tipo {@code Product} con su respectiva
	 *         informaci&oacute;n
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada en caso de alg&uacute;n error en la
	 *             b&uacute;squeda del producto
	 */
	public List<Product> get() throws IWDaoException;

	/**
	 * Entrega los datos de una sucursal dado su c&oacute;digo
	 * 
	 * @param idProduct
	 *            Representa el c&oacute;digo del producto a buscar.
	 * @return Retorna el producto seg&uacute;n el c&oacute;digo proporcionado.
	 *         Retorna <b>null</b> en el caso de que no lo encuentre.
	 * @throws IWDaoException
	 *             Excepci&oacute;n lanzada en caso de alg&uacute;n error en la
	 *             b&uacute;squeda del producto
	 */
	public Product get(Integer idProduct) throws IWDaoException;
}
