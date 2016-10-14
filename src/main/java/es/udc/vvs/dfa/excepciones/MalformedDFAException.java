package es.udc.vvs.dfa.excepciones;



/**
 * Exception that identifies a mal-formed DFA.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class MalformedDFAException extends Exception {

    public MalformedDFAException(String message) {
        super(message);
    }

}
