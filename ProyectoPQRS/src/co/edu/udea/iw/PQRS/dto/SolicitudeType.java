package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos del Tipo de Solicitud
 * 
 * @author Daniela
 * 
 */
public class SolicitudeType implements Serializable {

	private static final long serialVersionUID = -8914230857815099581L;

	/**
	 * Identificaci�n del tipo de solictud
	 */
	private String idSolicitudType;

	/**
	 * Descripci�n del tipo de solicitud
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
