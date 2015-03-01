package co.edu.udea.iw.PQRS.emailsender.exception;

/**
 * Clase que define una excepci&oacute;n gen&eacute;rica que ser&aacute; lanzada
 * en la capa de Logica de Negocio de la aplicaci&oacute;n. Esta
 * excepci&oacute;n ser&aacute; lanzada por cada funci&oacute;n o m&eacute;todo
 * que se implemente en el env&iacute;o del email
 *  * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class PQRSEmailException extends Throwable {

	private static final long serialVersionUID = -916431015095985596L;


	public PQRSEmailException() {
		super();
	}

	public PQRSEmailException(String message) {
		super(message);
	}

	public PQRSEmailException(String message, Throwable cause) {
		super(message, cause);
	}

	public PQRSEmailException(Throwable cause) {
		super(cause);
	}

	public PQRSEmailException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}