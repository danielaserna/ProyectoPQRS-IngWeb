package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase DTO (Data Tranfer Object) para manejar los tipos de solicitud que 
 * se pueden generar dentro de la aplicaci&oacute;n
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code SolicitudeType}
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
public class SolicitudeType implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code SolicitudeType} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = -8914230857815099581L;

	/**
	 *Valor de Identificación del tipo de solictud
	 */
	private String idSolicitudType;

	/**
	 * Descripción del tipo de solicitud
	 */
	private String description;

	public SolicitudeType() {
		super();
	}

	public SolicitudeType(String idSolicitudType) {
		this.idSolicitudType = idSolicitudType;
	}

	public String getIdSolicitudType() {
		return idSolicitudType;
	}

	public void setIdSolicitudType(String idSolicitudType) {
		this.idSolicitudType = idSolicitudType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
