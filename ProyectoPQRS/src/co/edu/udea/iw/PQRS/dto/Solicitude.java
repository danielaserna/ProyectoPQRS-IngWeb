package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO (Data Tranfer Object) para manejar los datos de las solicitudes que 
 * se generar&acute;n dentro de la aplicaci&oacute;n
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code Solicitude}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 */
@XmlRootElement()
public class Solicitude implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code Solicitude} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = -7442993749471623615L;

	/**
	 *Atributo que representa la identificación de la solicitud, el cual es un 
	 *número autogenerado
	 */
	private Integer idSolicitude;

	/**
	 * Atributo que representa la Descripcion de la solicitud que realiza un cliente
	 */
	private String description;

	/**
	 * Atributo que representa el Tipo de solicitud que desea realizar el cliente
	 */
	private SolicitudeType solicitudeType;

	/**
	 * Identificador del producto sobre el cual se esta realizando la solicitud
	 */
	private Product idProduct;

	/**
	 * Identificador de la sucursal a la que se le realiza la solicitud
	 */
	private Sucursal idSucursal;

	/**
	 * Identificación del cliente que realiza la solicitud
	 */
	private Client idNumber;

	public Integer getIdSolicitude() {
		return idSolicitude;
	}

	public void setIdSolicitude(Integer idSolicitude) {
		this.idSolicitude = idSolicitude;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SolicitudeType getSolicitudeType() {
		return solicitudeType;
	}

	public void setSolicitudeType(SolicitudeType solicitudeType) {
		this.solicitudeType = solicitudeType;
	}

	public Product getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Product idProduct) {
		this.idProduct = idProduct;
	}

	public Sucursal getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(Sucursal idSucursal) {
		this.idSucursal = idSucursal;
	}

	public Client getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Client idNumber) {
		this.idNumber = idNumber;
	}

}
