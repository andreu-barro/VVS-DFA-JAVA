package es.udc.vvs.dfa.dfa;

import java.util.Objects;

/**
 * This class defines the Transition element of a DFA.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class Transition {

    private final State startState;
    private final State endState;
    private final Symbol symbol;

    public Transition(State startState, State endState, Symbol symbol) {
        this.startState = startState;
        this.endState = endState;
        this.symbol = symbol;
    }

    public State getStartState() {
        return startState;
    }

    public State getEndState() {
        return endState;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.startState);
        hash = 13 * hash + Objects.hashCode(this.symbol);
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

        final Transition other = (Transition) obj;

        if (!Objects.equals(this.startState, other.startState)) {
            return false;
        }

        return Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        return "Transition{"
          + startState + ", "
          + endState + ", "
          + symbol +
        "}";
    }



}
