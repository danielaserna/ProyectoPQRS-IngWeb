package co.edu.udea.iw.PQRS.exception;

/**
 * Clase que define una excepci&oacute;n gen&eacute;rica que ser&aacute; lanzada
 * en la capa de Serivcios Web de la aplicaci&oacute;n. Esta excepci&oacute;n
 * ser&aacute; lanzada por cada funci&oacute;n o m&eacute;todo que se implemente
 * en la capa que define el contexto para el paso de mensajes entre diversas
 * aplicaciones, a trav&eacute;s de Servicios Web.
 * <p>
 * La excepci&oacute;n se lanza para escalar los errores a las capas superiores
 * y de ese modo delegar a dichas capas, el manejo de los errores y la
 * informaci&oacute;n que estos contengan.
 * 
 * @since JDK 1.8
 * 
 * @version 1.0
 * 
 * @author Daniela Serna Buitrago
 * @author Yefry Alexis Calderon Yepes
 * 
 */
public class IWServiceException extends Exception {

	/**
	 * Constante utilizada para realizar operaciones de serializaci&oacute;n y
	 * deserializaci&oacute;n de la instancia {@code IWServiceException}, e
	 * igualmente, de todos los atributos esta instancia agrupe.
	 */
	private static final long serialVersionUID = -2118535128880893327L;

	/**
	 * Constructor por defecto y sin par&aacute;metros para generar instancias
	 * de esta clase.
	 * <p>
	 * Este constructor realizar&aacute; una llamada expl&iacute;cita a su
	 * constructor padre. Por otra parte, el constructor est&aacute; en la
	 * capacidad de escribir en el archivo de LOG definido para la
	 * aplicaci&oacute;n.
	 */
	public IWServiceException() {
		super();
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * un mensaje y una instancia {@code Throwable} personalizada para la
	 * excepci&oacute;n a ser creada, junto con atributos para especificar la
	 * forma en la que los mensajes deben ser mostrados. Por otra parte, el
	 * constructor est&aacute; en la capacidad de escribir en el archivo de LOG
	 * definido para la aplicaci&oacute;n.
	 * 
	 * @param message
	 *            Instancia que representa el mensaje personalizado sobre el
	 *            error o excepci&oacute;n ocurrida.
	 * @param cause
	 *            Instancia que representa la causa o raz&oacute;n del error a
	 *            ser lanzado.
	 * @param enableSuppression
	 *            Indica si la supresi&oacute;n es activada o no.
	 * @param writableStackTrace
	 *            Indica si el mensaje debe ser mostrado en la pila de llamadas.
	 *            <code>true</code> indica que el mensaje ha de ser escrito en
	 *            la pila de llamadas.
	 */
	public IWServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStacjTrace) {
		super(message, cause, enableSuppression, writableStacjTrace);
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * un mensaje y una instancia {@code Throwable} personalizada para la
	 * excepci&oacute;n a ser creada. Por otra parte, el constructor est&aacute;
	 * en la capacidad de escribir en el archivo de LOG definido para la
	 * aplicaci&oacute;n.
	 * 
	 * @param message
	 *            Instancia que representa el mensaje personalizado sobre el
	 *            error o excepci&oacute;n ocurrida.
	 * @param cause
	 *            Instancia que representa la causa o raz&oacute;n del error a
	 *            ser lanzado.
	 */
	public IWServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * un mensaje personalizado para la excepci&oacute;n a ser creada. Por otra
	 * parte, el constructor est&aacute; en la capacidad de escribir en el
	 * archivo de LOG definido para la aplicaci&oacute;n.
	 * 
	 * @param message
	 *            Instancia que representa el mensaje personalizado sobre el
	 *            error o excepci&oacute;n ocurrida.
	 */
	public IWServiceException(String message) {
		super(message);
	}

	/**
	 * Constructor sobrecargado para generar instancias de esta clase utilizando
	 * una instancia {@code Throwable} personalizada para la excepci&oacute;n a
	 * ser creada. Por otra parte, el constructor est&aacute; en la capacidad de
	 * escribir en el archivo de LOG definido para la aplicaci&oacute;n.
	 * 
	 * @param cause
	 *            Instancia que representa la causa o raz&oacute;n del error a
	 *            ser lanzado.
	 */
	public IWServiceException(Throwable cause) {
		super(cause);
	}

}
