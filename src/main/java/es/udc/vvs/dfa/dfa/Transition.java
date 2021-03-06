package es.udc.vvs.dfa.dfa;

import java.util.Objects;

/**
 * This class defines the Transition element of a DFA.
 * @author {andreu.barro, emma.oitaven, javi.moure}@udc.es
 */
public class Transition {

	/**
	 * Estado.
	 */
    private final State startState;
	/**
	 * Estado final.
	 */
    private final State endState;
	/**
	 * Simbolo.
	 */
    private final Symbol symbol;

	/**
	 * Constructor.
	 * @param startState estado inicial
	 * @param endState estado final
	 * @param symbol Simbolo
	 */
    public Transition(final State startState, final State endState, final Symbol symbol) {
        this.startState = startState;
        this.endState = endState;
        this.symbol = symbol;
    }

    /**
     * Devuelve el estado inicial.
     * @return State
     */
    public State getStartState() {
        if (startState != null) {
            return startState;
        } else {
        	return null;
        }
    }
    /**
     * Devuelve el estado final.
     * @return State
     */
    public State getEndState() {
        if (endState != null) {
        	return endState;
        } else {
        	return null;
        }
    }
    /**
     * Devuelve el simbolo.
     * @return Symbol
     */
    public Symbol getSymbol() {
        if (symbol != null) {
        	return symbol;
        } else {
        	return null;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.startState);
        hash = 13 * hash + Objects.hashCode(this.symbol);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Transition other = (Transition) obj;

        if (!Objects.equals(this.startState, other.startState)) {
            return false;
        }

        return Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        return "Transition{"
          + startState 
          + ", "
          + endState 
          + ", "
          + symbol 
          + "}";
    }



}
