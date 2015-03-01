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

public final class EmailSender {

	private Properties properties;
	private String fromEmail;
	private String password;
	private String host;
	private String port;
	private Session session;

	public EmailSender() throws PQRSEmailException {
		this.properties = new Properties();
		this.configureEMailProperties();
	}

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

	private void getSessionProperties(String host, String port) {
		this.properties.put("mail.smtp.host", host);
		this.properties.put("mail.smtp.socketFactory.port", port);
		this.properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		this.properties.put("mail.smtp.auth", "true");
		this.properties.put("mail.smtp.port", port);
	}

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