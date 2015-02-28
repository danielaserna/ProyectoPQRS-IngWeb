package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos del perfil
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class Profile implements Serializable {

	private static final long serialVersionUID = -7661212429500297259L;

	/**
	 * Perfil del usuario
	 */
	private String profile;

	/**
	 * Descripción del perfil
	 */
	private String description;

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
