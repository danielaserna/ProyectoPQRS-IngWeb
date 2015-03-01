package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase dto(Data Tranfer Object) para los datos de un Cliente .
 * Esta clase ser&acute; usada para realizar toda la persistencia relacionada
 * con la entidad {@code Client}}
 * 
 * @since JDK 1.7
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
@XmlRootElement()
public class Client implements Serializable {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n de la
	 * instancia {@code Client} e igualmente de todos los atributos tanto primitivos
	 * como objetos y compuestos que esta instancia agrupe
	 */
	private static final long serialVersionUID = 4098723666223954696L;

	/**
	 *Atributo que representa la Identificación del cliente, la cual es inequivoca
	 *para cada usuario, y ser&acute; usada para el registro y validaci&oacute;n 
	 *del usuario dentro del sistema
	 */
	private Integer idNumber;

	/**
	 * Atributo que representa el Nombre del Cliente
	 */
	private String fullName;

	/**
	 *Atributo que representa los Apellidos del Cliente 
	 */
	private String lastName;

	/**
	 * Atributo que Correo electronico del Cliente
	 */
	private String email;

	/**
	 * Numero telefonico del Cliente
	 */
	private String phoneNumber;

	/**
	 * Numero telefonico movil del Cliente
	 */
	private String cellphoneNumber;

	/**
	 * Perfil del Cliente
	 */
	private Profile profile;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Integer getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}

}
