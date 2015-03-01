package co.edu.udea.iw.PQRS.emailsender.exception;

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