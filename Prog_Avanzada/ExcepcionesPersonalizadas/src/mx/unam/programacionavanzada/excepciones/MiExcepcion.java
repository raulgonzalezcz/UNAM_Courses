package mx.unam.programacionavanzada.excepciones;

/**
 * Creación de excepción personalizada
 * @author Gabriel Gonzalez
 *
 */
public class MiExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	private int codigo;
	
	/**
	 * Constructor de la superclase
	 */
	public MiExcepcion() {
		super();
	}

	/**
	 * Constructor de la superclase
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MiExcepcion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor de la superclase
	 * 
	 * @param message
	 * @param cause
	 */
	public MiExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor de la superclase
	 * 
	 * @param message
	 */
	public MiExcepcion(String message) {
		super(message);
	}

	/**
	 * Constructor de la superclase
	 * 
	 * @param cause
	 */
	public MiExcepcion(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor personalizado para asignar un código de error
	 * @param codigo
	 * @param mensaje
	 */
	public MiExcepcion(int codigo, String mensaje) {
		super(mensaje);
		this.codigo = codigo;
	}

	/**
	 * Getter para obtener el código de error asciado a la excepción.
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
}
