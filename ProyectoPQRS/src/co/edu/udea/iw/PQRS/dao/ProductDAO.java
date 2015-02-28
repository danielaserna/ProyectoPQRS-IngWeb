package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Product;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ProductDAO {

	// Entrega la lista de productos existentes en la base de datos
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
