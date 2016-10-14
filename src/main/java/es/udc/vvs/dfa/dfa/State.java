package es.udc.vvs.dfa.dfa;

import java.util.Objects;

/**
 * This class defines the State element of a DFA.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 * @param <T>
 */
public class State {
    private final String state;

    public State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.state);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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
