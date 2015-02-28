package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.ProductType;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ProductTypeDAO {

	// Entrega la lista de tipo de productos existentes en la base de datos
	public List<ProductType> get() throws IWDaoException;

	// Entrega los datos de un tipo de producto dado su codigo
	public ProductType obtener(String type) throws IWDaoException;
}
