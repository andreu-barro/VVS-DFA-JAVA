package es.udc.vvs.dfa.dfa;

import java.util.Objects;

/**
 * This class defines the State element of a DFA.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class State {
	
	/**
	 * Estado.
	 */
    private final String state;

    /**
     * Constructor.
     * @param state Estado
     */
    public State(final String state) {
        this.state = state;
    }

    /**
     * Constructor.
     * @return estado
     */
    public String getState() {
        if (state != null) {
        	return state;
        } else {
        	return null;
        }
    }

    @Override
    public String toString() {
        return state;
        //.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.state);
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
        final State other = (State) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }



}
