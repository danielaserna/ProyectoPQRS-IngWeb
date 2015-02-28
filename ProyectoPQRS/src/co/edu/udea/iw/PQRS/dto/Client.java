package co.edu.udea.iw.PQRS.dto;

import java.io.Serializable;

/**
 * Clase dto para los datos del cliente
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class Client implements Serializable {

	private static final long serialVersionUID = 4098723666223954696L;

	/**
	 * Identificación del cliente
	 */
	private Integer idNumber;

	/**
	 * Nombre del Cliente
	 */
	private String fullName;

	/**
	 * Apellidos del Cliente
	 */
	private String lastName;

	/**
	 * Correo electronico del Cliente
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
