package es.udc.vvs.dfa.excepciones;



/**
 * Exception that identifies a mal-formed DFA.
 * @author {andreu.barro, emma.oitaven, javier.moure}@udc.es
 */
public class MalformedDFAException extends Exception {

	/**
	 * Mensaje de excepcion.
	 * @param message mensaje de error
	 * */
    public MalformedDFAException(final String message) {
        super(message);
    }

}
