package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos de las ciudades
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class City implements Serializable {

	private static final long serialVersionUID = 6217642515784020664L;

	/**
	 * Codigo de la ciudad
	 */
	private Integer code;

	/**
	 * Nombre de la ciudad
	 */
	private String name;

	/**
	 * Codigo de area de la ciudad
	 */
	private String areaCode;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

}
