package co.edu.udea.iw.PQRS.dao;

import java.util.List;

import co.edu.udea.iw.PQRS.dto.Client;
import co.edu.udea.iw.PQRS.exception.IWDaoException;

/**
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public interface ClientDAO {

	// Inserta un cliente en la base de datos
	public Client insert(Client client) throws IWDaoException;

	// Actualiza un cliente en la base de datos
	public Client update(Client client) throws IWDaoException;

	// Elimina un cliente de la base de datos
	public Client delete(Client client) throws IWDaoException;

	// Entrega la lista de Clientes existentes en la base de datos
	public List<Client> get() throws IWDaoException;

	// Entrega los datos de un cliente dado su identificacion
	public Client get(Integer idNumber) throws IWDaoException;
}
