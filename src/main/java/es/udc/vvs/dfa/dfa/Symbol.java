package es.udc.vvs.dfa.dfa;

import java.util.Objects;

/**
 * This class defines the Symbol element of an Alphabet.
 * @@author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 * @param <T>
 */
public class Symbol {

    private final String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.symbol);
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

        final Symbol other = (Symbol) obj;

        return Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        return symbol.toString();
    }



}
