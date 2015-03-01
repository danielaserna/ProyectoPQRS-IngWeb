package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO (Data Tranfer Object) para manejar los datos de las sucursales que 
 * existen dentro de la aplicaci&oacute;n
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code Sucursal}
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
public class Sucursal implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code Sucursal} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = 3126750689288922532L;

	/**
	 *Atributo que identifica una sucursal dentro del sistema
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
