package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos de las ciudades (Data Tranfer Object).
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code City}}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 *  
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 *
 */
public class City implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code City} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = 6217642515784020664L;

	/**
	 * Atributo que representa el Codigo que posee cada ciudad dentro de la base de 
	 * datos
	 */
	private Integer code;

	/**
	 * Atributo que representa el Nombre de la ciudad
	 */
	private String name;

	/**
	 * Atributo que representa el Codigo de &acute;rea de la ciudad
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
