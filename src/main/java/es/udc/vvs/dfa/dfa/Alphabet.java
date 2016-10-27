package es.udc.vvs.dfa.dfa;

import es.udc.vvs.dfa.util.GenList;

/**
 * This class defines the Alfphabet element of a DFA.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class Alphabet {
	/**
	 * Se crea la variable estática de alphabeto.
	 */
    private final GenList<Symbol> alphabet;

    /**
     * Construnctor.
     * */
    public Alphabet() {
        alphabet = new GenList<Symbol>();
    }

    /**
     * Construnctor con parámetros.
     * @param n tamaño de la lista
     * */
    public Alphabet(int n) {
        alphabet = new GenList<Symbol>(n);
    }

    /**
     * Añadimos simbolos nuevos al alfabeto.
     * @param symbol añade simbolo
     * */
    public void addNewSymbol(Symbol symbol) {
        alphabet.add(symbol);
    }

    /**
     * @see
     * public T es.udc.fic.dlp1516.automata.GenList.getExistingObject(T obj)
     * for further information.
     * @param symbol comprueba si existe el simbolo
     * @return an equal T object from the GenList.
     */
    public Symbol getExistingObject(Symbol symbol) {
        if (alphabet.getExistingObject(symbol)!=null) {
        return alphabet.getExistingObject(symbol);
        }
        else return null;
    }

    /**
     * @return lista de simbolos
     * */
    public GenList<Symbol> getAlphabet() {
        if (alphabet!=null) {
        return alphabet;
        }
        else return null;
    }

    @Override
    public String toString() {
        return "Alphabet{" + alphabet + "}";
    }



}
