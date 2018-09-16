package mx.unam.programacionavanzada.excepciones;

/**
 * Ejemplo de uso de excepciones
 * @author Gabriel Gonz&aacute;lez
 * @author Raúl González Cruz
 * @since 16/09/18
 *
 */
public class PruebaExcepcion {
	/**
	 * Funci&oacute;n que lanza la excepci&oacute;n personalizada <code>MiExcepcion</code>
	 * @throws MiExcepcion Excepci&oacute;n personalizada
	 */
	public void provocarMiExcepcion() throws MiExcepcion{
		throw new MiExcepcion(123, "Error asociado con el código 123");
	}
	
	/**
	 * &iquest;Por qu&eacute; a pesar de emplear <code>throw new RuntimeException</code> dentro del 
	 * cuerpo de la funci&oacute;n, su declaraci&oacute;n no requiere especificar 
	 * <code>throws RuntimeException</code>?<br>
	 * 
	 * <br>RuntimeException es la superclase de esas excepciones que se pueden lanzar durante 
	 * el funcionamiento normal de la Máquina Virtual de Java; por lo que RuntimeException 
	 * y sus subclases son consideradas excepciones no verificadas (unchecked exceptions). 
	 * Estas excepciones no necesitan ser declaradas en un método o cláusula throws del 
	 * constructor si pueden ser lanzadas por la ejecución del método o el constructor 
	 * y propagarse fuera del método o del límite del constructor.<br> 
	 * 
	 * <br>Las excepciones no verificadas deben reservarse para los errores del sistema que 
	 * representan alguna condición de falla no controlada (como NullPointer o OutOfMemory), 
	 * provocando que la aplicación deba finalizar con esa excepción. Se espera que 
	 * ocurran excepciones de este tipo en cualquier 
	 * parte del programa, por lo que  indican errores no predecibles en la lógica del programa
	 * que normalmente no deberían ocurrir. Entonces se utilizan para comprobar la consistencia 
	 * interna del programa y solo deberían recuperarse si realmente sabemos cuáles 
	 * son las implicaciones de esa recuperación. 
	 * 
	 * También necesitamos usar RuntimeException en caso de que tengamos un bloque 
	 * estático en el que se esté creando instancias y se desee lanzar una 
	 * excepción si falla la creación de instancias. Como los bloques estáticos 
	 * no tienen la palabra clave throw / throws, RuntimeExceptions se vuelve adecuado
	 * en este caso. Finalmente se resume que RuntimeException, al ser una unchecked exception, establece que:<br>
	 * 
	 * <br>
	 * <ul>
	 * <li> La declaración del método no tiene que indicar que se puede lanzar una RuntimeException con la palabra reservada throws</li>
	 * <li> Otras partes del programa que llaman ese método no están obligadas a detectar la excepción ni a reconocerla de alguna manera</li>
	 * <li> Aunque no hace falta la cláusula throws en la declaración del método, si 
	 * no son capturadas estas excepciones, pasarán al método de nivel 
	 * superior y seguirán así hasta llegar a la función principal, 
	 * momento en el que provocará la salida de nuestro programa mostrando el error 
	 * correspondiente dado que no se capturó la excepción </li>
	 * </ul>
	 * <br>
	 * 
	 * <br>Dado que RuntimeException extiende de la clase Exception, en este caso 
	 * throw new RuntimeException(msg) está creando una instancia de RuntimeException
	 * con el mensaje especificado antes de ser lanzada.<br>
	 * 
	 * <br>Ref: https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/RuntimeException.html
	 * http://www.jtech.ua.es/j2ee/publico/lja-2012-13/sesion03-apuntes.html
	 */
	public void lanzarExcepcionEnTiempoEjecucion(){
		throw new RuntimeException("Error en tiempo de ejecución");
	}
	
	/**
	 * &iquest;Por qu&eacute; no se declara una excepci&oacute;n?
	 */
	public void provocarExcepcionEnTiempoEjecucion(){
		System.out.println(33/0);
	}
	
	public static void main(String []args) {
		System.out.println("Iniciando aplicación");
		
		PruebaExcepcion prueba = new PruebaExcepcion();
		
		try {
			System.out.println("Llamando la función provocarMiExcepcion()");
			prueba.provocarMiExcepcion();
			
			System.out.println("Llamando la función lanzarExcepcionEnTiempoEjecucion()");
			prueba.lanzarExcepcionEnTiempoEjecucion();
			
			System.out.println("Llamando la función provocarExcepcionEnTiempoEjecucion()");
			prueba.provocarExcepcionEnTiempoEjecucion();
		} catch (MiExcepcion e) {
			e.printStackTrace();
			System.err.println("Código de error: " + e.getCodigo());
			System.err.println("Mensaje de error: " + e.getMessage());
		}
		
		// Continua programa porque prueba.provocarMiExcepcion() condujo al bloque catch
		try {
		System.out.println("Llamando la funci&oacute;n lanzarExcepcionEnTiempoEjecucion() fuera del bloque try-catch");
		prueba.lanzarExcepcionEnTiempoEjecucion();
		}catch(RuntimeException re) {
			re.printStackTrace();
			System.err.println("Mensaje de error: " + re.getMessage());
		}
		
		try {
		System.out.println("Llamando la funci&oacute;n provocarExcepcionEnTiempoEjecucion() fuera del bloque try-catch");
		prueba.provocarExcepcionEnTiempoEjecucion();
		}catch(ArithmeticException ae) {
			ae.printStackTrace();
			System.err.println("Mensaje de error: " + ae.getMessage());
		}
		
	}
}
