package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Tranfer Object) para los tipos de perfil que se manejaran 
 * dentro de la aplicaci&oacute;n
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code Profile}
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class Profile implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code Profile} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = -7661212429500297259L;

	/**
	 *Atributo que representa el tipo de Perfil del usuario, el cual puede ser de
	 *tipo: cliente o gerente de cuentas administrativas
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
