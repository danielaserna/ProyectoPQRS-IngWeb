package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO (Data Tranfer Object) para los datos de los productos que compran
 * los clientes.
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code ProductType}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
@XmlRootElement()
public class ProductType implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code ProductType} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = -8655161871517817922L;

	/**
	 * Atributo que representa el Tipo de producto dentro del sistema
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
