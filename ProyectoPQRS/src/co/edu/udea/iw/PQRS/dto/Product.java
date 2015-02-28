package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos de los productos
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class Product implements Serializable {

	private static final long serialVersionUID = -4718639870074495466L;

	/**
	 * Identificación del producto
	 */
	private Integer idProduct;

	/**
	 * Descripción del producto
	 */
	private String description;

	/**
	 * Tipo de producto
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
