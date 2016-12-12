package es.udc.vvs.dfa.dfa;

import java.util.Objects;

/**
 * This class defines the Symbol element of an Alphabet.
 * @@author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class Symbol {

	/**
	 * Simbolo.
	 */
    private final String symbol;

	/**
	 * Constructor.
	 * @param symbol simbolo
	 */
    public Symbol(final String symbol) {
        this.symbol = symbol;
    }

	/**
	 * Get simbolo.
	 * @return devuelve el simbolo
	 */
    public String getSymbol() {
        if (symbol != null) {
        	return symbol;
        } else {
        	return null;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.symbol);
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

        final Symbol other = (Symbol) obj;

        return Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        return symbol;
        //.toString();
    }



}
