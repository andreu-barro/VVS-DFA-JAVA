package es.udc.vvs.dfa.dfa;

import es.udc.vvs.dfa.util.GenList;

/**
 * This class represents a DFA entity.
 * Furthermore, it simplifies a disconnected DFA into a connected one.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class DFA {

    /**
     * All these attributes define a DFA
     */
    private final GenList<State> states;
    private final Alphabet alphabet;
    private final State initialState;
    private final GenList<State> finalStates;
    private final GenList<Transition> transitions;

    public DFA(GenList<State> states, Alphabet alphabet, State initialState,
            GenList<State> finalStates, GenList<Transition> transitions) {
        this.states = states;
        this.alphabet = alphabet;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.transitions = transitions;
    }

    /**
     * Find all the reachable states from this DFA.
     * @return the connected states
     */
    private GenList<State> getAllConnectedStates() {
        Transition t, rTransition;
        GenList<State> visitedStates = new GenList<State>();
        visitedStates.add(initialState);
        State currentState;
        State[] statesQueue = new State[states.getSize()];
        statesQueue[0] = visitedStates.get(0);
        Symbol[] alphabetList = new Symbol[alphabet.getAlphabet().getSize()];
        System.arraycopy(alphabet.getAlphabet().getArray(), 0, alphabetList, 0,
                alphabet.getAlphabet().getSize());

        // Breadth First Search
        int head = 0, tail = 0;
        while (head <= tail) {
            currentState = statesQueue[head];
            statesQueue[head++] = null; // let the GC free unused queue space

            for(Symbol symbol: alphabetList) {
                t = new Transition(currentState, null, symbol);
                if ((rTransition = transitions.getExistingObject(t)) != null) {
                    if (visitedStates.getExistingObject(rTransition.getEndState()) == null) {
                        visitedStates.add(rTransition.getEndState());
                        statesQueue[++tail] = rTransition.getEndState();
                    }
                }
            }
        }

        return visitedStates;
    }

    /**
     * Main algorithm to transform a disconnected DFA into a connected one.
     * @return a connected DFA
     */
    public DFA getConnectedDFA() {
        GenList<State> q; // connected states
        GenList<State> f = new GenList<State>(); // new final states
        GenList<Transition> t = new GenList<Transition>(); // new transitions
        // E and s remain the same

        /* Build the new connected DFA */

        // new Q (get all reachable states from the initial state)
        q = getAllConnectedStates();

        // F (get rid of unreachable states)
        State[] finalStatesList = new State[finalStates.getSize()];
        System.arraycopy(finalStates.getArray(), 0, finalStatesList, 0,
            finalStates.getSize());
        State[] fArray = new State[finalStates.getSize()];
        int i=0, j=0;
        for (State s: finalStatesList) {
            if (q.getExistingObject(s) != null) {
                fArray[i++] = s;
            }
        }
        while (j<i) {
            f.add(fArray[j++]);
        }

        // Gamma (get rid of useless transitions)
        Transition[] transitionList = new Transition[transitions.getSize()];
        System.arraycopy(transitions.getArray(), 0, transitionList, 0,
            transitions.getSize());
        Transition[] tArray = new Transition[transitions.getSize()];
        i=0; j=0;
        for (Transition ts: transitionList) {
            if (q.getExistingObject(ts.getStartState()) != null) {
                tArray[i++] = ts;
            }
        }
        while (j<i) {
            t.add(tArray[j++]);
        }

        return new DFA(q, this.alphabet, initialState, f, t);
    }

    @Override
    public String toString() {
        return "DFA = {\n"
          + "\tstates=" + states
          + ",\n\talphabet=" + alphabet
          + ",\n\tinitialState=" + initialState
          + ",\n\tfinalStates=" + finalStates
          + ",\n\ttransitions=\n\t" + getTransitionsTable() + "\n}";
    }

    private String getTransitionsTable() {
        StringBuilder output = new StringBuilder("");
        output.append("   | ");
      
        for (Object s: alphabet.getAlphabet().getArray()) {
            output.append(s).append("  | ");
        }
        
        output.append("\n");
        
        for (Object q: states.getArray()) {
            output.append("\t").append(q).append(" | ");
            for (Object s: alphabet.getAlphabet().getArray()) {
                Transition t =
                        new Transition(new State(q.toString()), null, new Symbol(s.toString()));
                Transition tn = transitions.getExistingObject(t);
                if (tn != null) {
                    output.append(tn.getEndState()).append(" | ");
                }
            }
            output.append("\n");
        }
        
        return output.toString();
    }

}
