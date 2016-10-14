package es.udc.vvs.dfa.dfa;

import es.udc.vvs.dfa.util.GenList;

/**
 * This class defines the Alfphabet element of a DFA.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class Alphabet {
    private final GenList<Symbol> alphabet;

    public Alphabet() {
        alphabet = new GenList<Symbol>();
    }

    public Alphabet(int n) {
        alphabet = new GenList<Symbol>(n);
    }

    public void addNewSymbol(Symbol symbol) {
        alphabet.add(symbol);
    }

    /**
     * @see
     * public T es.udc.fic.dlp1516.automata.GenList.getExistingObject(T obj)
     * for further information.
     * @param symbol
     * @return an equal T object from the GenList.
     */
    public Symbol getExistingObject(Symbol symbol) {
        return alphabet.getExistingObject(symbol);
    }

    public GenList<Symbol> getAlphabet() {
        return alphabet;
    }

    @Override
    public String toString() {
        return "Alphabet{" + alphabet + "}";
    }



}
