package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos del tipo de producto
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class ProductType implements Serializable {

	private static final long serialVersionUID = -8655161871517817922L;

	/**
	 * Tipo de producto
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
