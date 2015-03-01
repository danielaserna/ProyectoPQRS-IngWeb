package co.edu.udea.iw.PQRS.emailsender;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.udea.iw.PQRS.dto.Solicitude;
import co.edu.udea.iw.PQRS.emailsender.exception.PQRSEmailException;

/**
 * Clase que define la implementaci&oacute;n de m&eacute;todos que sirven para
 * para gestionar la configuración de una cuenta de correo electr&oacute;nico y
 * el env&iacute;o de los mismos a partir de los datos proporciondos por un
 * objeto tipo {@code Solicitude}.
 * <p>
 * Esta clase ser&aacute; la encargada de apoyar el proceso de env&iacute;o de
 * correos electr&oacute;nicos cada vez que una solicitud es atendida por uno de
 * los Administradores del sistema.
 *
 * @since JDK1.8
 *
 * @version 1.0
 *
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 */
public final class EmailSender {

	/**
     * Atributo a trav&eacute;s del cual se gestiona y guarda la
     * informaci&oacute;n que se encuentra en una archivo de propiedades,
     * espec&iacute;ficamente, los datos relacionados con la
     * configuraci&oacute;n de correo electr&oacute;nico fuente.
     */
	private Properties properties;
	
	/**
     * Atributo en el que se conserva el correo electr&oacute;nico desde el cual
     * se realizar&aacute; el env&iacute;o de los mensajes.
     */
	private String fromEmail;
	
	/**
     * Atributo donde se almacena temporalmente la contrase&ntilde;a asociada a
     * la cuenta de correo electr&oacute;nico fuente.
     */
	private String password;
	
	/**
     * Atributo que representa el protocolo o host a trav&eacute;s del cual se
     * realizar&aacute;n los env&iacute;os de los mensajes.
     */
	private String host;
	
	/**
     * Atributo que almacena temporalmente el puerto usado para enviar los
     * mensajes.
     */
	private String port;
	
	/**
     * Objeto tipo {@code Session} en el que se guarda todas las propiedades y
     * valores por defecto usados para el env&iacute;o de los mensajes.
     */
	private Session session;

	/**
     * &Uacute;nico constructor de la clase y en el que se podr&aacute; obtener
     * el conjunto de propiedades que permite el env&iacute;o correcto de los
     * mensajes..
     *
     * @throws PQRSEmailException
     */
	public EmailSender() throws PQRSEmailException {
		this.properties = new Properties();
		this.configureEMailProperties();
	}

	/**
     * M&eacute;todo que sirve para el env&io de correos electr&oacute;nicos
     * desde un correo fuente previamente obtenido desde las propiedades.
     * Ser&aacute; el &uacute;nico m&eacute;todo que realice este procedimiento
     * y es utilzado para dar apoyo al proceso de responder ante una solicitud
     * realizada por un clinte y/o usuario.
     *
     * @param solicitude Objetio de tipo {@code Solicitude} usado para obtener
     * la informaci&oacute;n necesaria y/o requerida para el env&iacute;o del
     * mensaje. Representa la petici&oacute;n a la que se le desaa dar respuesta
     * o se desea atender.
     * @param text Hilera de caracteres que representa la respuesta dada por una
     * administrador a la petici&oacute;n evaluada.
     * @return Retorna <b>true</b> si el proceso se haya realizado
     * correctamente.
     * @throws PQRSEmailException Excepción lanzada debido a alg&uacute;n
     * problema o error ocurrido mientras se trataba de realizar el env&iacute;o
     * de un correo electr&oacute;nico.
     */
	public boolean sendEmail(Solicitude solicitude, String text)
			throws PQRSEmailException {
		if (solicitude == null) {

			return (false);
		}

		if (solicitude.getIdSolicitude() == null
				|| solicitude.getIdSolicitude().toString().equals("")
				|| solicitude.getIdNumber().getEmail() == null
				|| solicitude.getIdNumber().toString().trim().equals("")
				|| solicitude.getIdProduct().getDescription() == null
				|| solicitude.getIdProduct().getDescription().trim().equals("")
				|| solicitude.getIdProduct().getType().getType() == null
				|| solicitude.getIdProduct().getType().getType().trim()
						.equals("")
				|| solicitude.getIdSucursal().getNombre() == null
				|| solicitude.getIdSucursal().getNombre().trim().equals("")
				|| solicitude.getIdSucursal().getCode().getName() == null
				|| solicitude.getIdSucursal().getCode().getName().trim()
						.equals("")
				|| solicitude.getSolicitudeType().getIdSolicitudType() == null
				|| solicitude.getSolicitudeType().getIdSolicitudType().trim()
						.equals("") || solicitude.getDescription() == null
				|| solicitude.getDescription().trim().equals("")
				|| text == null || text.trim().equals("")) {

			return (false);
		}

		try {
			String subject = "Respuesta a la Solicitud "
					+ solicitude.getIdSolicitude().toString().trim();

			String emailMessage = "Detalle de la Solicitud\n\n";
			emailMessage += "Id de Solicitud: "
					+ solicitude.getIdSolicitude().toString().trim() + "\n";
			emailMessage += "Producto: "
					+ solicitude.getIdProduct().getDescription().trim() + " - "
					+ solicitude.getIdProduct().getType().getType() + "\n";
			emailMessage += "Sucursal: "
					+ solicitude.getIdSucursal().getNombre().trim() + " - "
					+ solicitude.getIdSucursal().getCode().getName().trim()
					+ "\n";
			emailMessage += "Tipo de Solicitud: "
					+ solicitude.getSolicitudeType().getIdSolicitudType()
							.trim() + "\n";
			emailMessage += "Descripción de Solicitud: "
					+ solicitude.getDescription().trim() + "\n\n";
			emailMessage += "Respuesta:  " + text.trim() + "\n\n\n";
			emailMessage += "Proyecto PQRS - Ingeniería Web";

			Message message = new MimeMessage(this.session);
			message.setFrom(new InternetAddress(this.fromEmail));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(solicitude.getIdNumber().getEmail()
							.trim().toLowerCase()));
			message.setSubject(subject);
			message.setText(emailMessage);

			Transport.send(message);
		} catch (MessagingException e) {
			throw new PQRSEmailException(
					"Fatal error while the application was trying to send a "
							+ "E-Mail.", e.getCause());
		}

		return (true);
	}

	/**
     * M&eacute;todo cuyo prop&oacute;sito es la obtenci&oacute;n de las
     * propiedades o de los datos que servir&aacute;n como insumo para realizar
     * la configuraci&ooacute;n del correo electr&oacute;nico desde el cual se
     * realizar&aacute; el env&iacute;o de los mensajes. Es principalmente un
     * m&eacute;todo de utilidad.
     *
     * @throws PQRSEmailException Excepci&oacute;n lanzada cuando no se ha
     * encontrado el archivo de propiedades, no se ha podido abrir o no se ha
     * podido leer las propiedades que almacena.
     */
	private void getEMailAccountProperties() throws PQRSEmailException {
		Properties properties = new Properties();
		InputStream inputStream = getClass().getResourceAsStream(
				"/co/edu/udea/iw/PQRS/emailsender/config/"
						+ "emailsender.properties");

		try {
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			throw new PQRSEmailException(
					"Fatal error while application was trying to read E-Mail "
							+ "properties.", e.getCause());
		}

		this.fromEmail = properties.getProperty("EMAIL_ADDRESS");
		this.password = properties.getProperty("PASSWORD");
		this.host = properties.getProperty("HOST");
		this.port = properties.getProperty("PORT");
	}

	/**
     * M&eacute;todo donde se establecen el conjunto de propiedades que
     * permitir&aacute;n la conexi&oacute;n a la cuenta de correo
     * electr&oacute;nico para el env&iacute;o de los mensajes a trav&eacute;s
     * de la misma.
     *
     * @param host Atributo que representa el host o protocolo utilizado para el
     * env&iacute;o de los mensajes.
     * @param port Puerto a trav&eacute;s del cual se hace la conexi&oacute;n a
     * la cuenta de correo y se hace el env&iacute;o de los mensajes.
     */
	private void getSessionProperties(String host, String port) {
		this.properties.put("mail.smtp.host", host);
		this.properties.put("mail.smtp.socketFactory.port", port);
		this.properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		this.properties.put("mail.smtp.auth", "true");
		this.properties.put("mail.smtp.port", port);
	}

	/**
     * Es en este m&eacute;todo donde se obtiene la sesi&oacute;n de correo para
     * realizar el uso inmediato de la cuenta all&iacute; asociada o
     * establecida.
     *
     * @throws PQRSEmailException Excepci&oacute;n lanzada porque no se ha
     * podido crear la sesi&oacute;n debido a alguna inconsistencia en los datos
     * obtendios.
     */
	private void configureEMailProperties() throws PQRSEmailException {
		this.getEMailAccountProperties();
		this.getSessionProperties(this.host, this.port);

		this.session = Session.getInstance(properties, new Authenticator() {
			@Override()
			protected PasswordAuthentication getPasswordAuthentication() {

				return (new PasswordAuthentication(fromEmail, password));
			}
		});
	}
}