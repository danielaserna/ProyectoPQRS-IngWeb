package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase dto para los datos de las sucursales
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
@XmlRootElement()
public class Sucursal implements Serializable {

	private static final long serialVersionUID = 3126750689288922532L;

	/**
	 * Identificador de la sucursal
	 */
	private Integer idSucursal;

	/**
	 * Nombre de la sucursal
	 */
	private String nombre;

	/**
	 * Codigo de la ciudad donde esta ubicada la sucursal
	 */
	private City code;

	public Integer getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public City getCode() {
		return code;
	}

	public void setCode(City code) {
		this.code = code;
	}

}
