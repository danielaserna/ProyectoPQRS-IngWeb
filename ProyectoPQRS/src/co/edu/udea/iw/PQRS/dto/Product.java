package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO (Data Tranfer Object) para los datos de los productos que compran
 * los clientes.
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code Product}
 * 
 * @since JDK 1.7
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
@XmlRootElement()
public class Product implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code Product} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = -4718639870074495466L;

	/**
	 *Atributo que identifica inequivocamente un producto dentro del sistema
	 *el cual es la identificación del producto
	 */
	private Integer idProduct;

	/**
	 *Atributo que brinda una Descripción del producto
	 */
	private String description;

	/**
	 *Atributo que identifica el Tipo de producto 
	 */
	private ProductType type;

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

}
