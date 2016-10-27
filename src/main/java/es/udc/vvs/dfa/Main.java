package es.udc.vvs.dfa;

import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.dfa.Alphabet;
import es.udc.vvs.dfa.dfa.Transition;
import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.DFA;
import es.udc.vvs.dfa.util.GenList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.udc.vvs.dfa.excepciones.MalformedDFAException;

/**
 * This class represents the main program. An interface to interact with.
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 */
public class Main {

    /**
     * Gets the first line of a file (\n terminated text) to read the DFA string
     * codification.
     * @param filePath the location of the input file.
     * @return The text which represents the DFA from the input file.
     * @throws IOException excepcion
     */
    private static String getStringAutomataFromFile(String filePath)
            throws IOException {
        String fp = filePath;
        String afd;
//prueba de deteccion
//        try (BufferedReader br
  //              = new BufferedReader(new FileReader(fp))) {
    //        afd = br.readLine();
      //  }

      try(  BufferedReader br = new BufferedReader(
    		  new InputStreamReader(new FileInputStream(fp),""))){
        afd = br.readLine();
      }
        return afd;
    }

    /**
     * Converts a DFA as a String into an actual DFA object.
     * @param dfa String DFA representation
     * @return An actual DFA object
     * @throws MalformedDFAException excepcion
     */
    private static DFA parseDFA(String dfa) throws MalformedDFAException {

        String currentParsing;

        // Q
        currentParsing = dfa.substring(0, dfa.indexOf(";"));
        String[] split = currentParsing.split(" ");
        GenList<State> states = new GenList<>(split.length);
        for (String s : split) {
            states.add(new State(s));
        }
        dfa = dfa.substring(dfa.indexOf(";") + 2);

        // E
        currentParsing = dfa.substring(0, dfa.indexOf(";"));
        split = currentParsing.split(" ");
        Alphabet alphabet = new Alphabet(split.length);
        for (String s : split) {
            alphabet.addNewSymbol(new Symbol(s));
        }
        dfa = dfa.substring(dfa.indexOf(";") + 2);

        // s
        currentParsing = dfa.substring(0, dfa.indexOf(";"));
        split = currentParsing.split(" ");
        State initialState = new State(split[0]);
        dfa = dfa.substring(dfa.indexOf(";") + 2);

        // F
        currentParsing = dfa.substring(0, dfa.indexOf(";"));
        split = currentParsing.split(" ");
        GenList<State> finalStates = new GenList<>(split.length);
        for (String s : split) {
            finalStates.add(new State(s));
        }
        dfa = dfa.substring(dfa.indexOf(";") + 2);

        // Gamma
        currentParsing = dfa;
        split = currentParsing.split("; ");
        String lastTransition = split[split.length - 1];
        split[split.length - 1]
                = lastTransition.substring(0, lastTransition.length() - 1);
        GenList<Transition> transitions = new GenList<>(split.length);
        String[] splitTransition;
        for (String s : split) {
            splitTransition = s.split(" ");
            transitions.add(new Transition(
                    new State(splitTransition[0]),
                    new State(splitTransition[1]),
                    new Symbol(splitTransition[2])));
        }

        return new DFA(states, alphabet, initialState, finalStates, transitions);
    }

    /**
     * Main method. It reads a DFA entry from the standard input or a file
     * input and retrieves the connected DFA representation.
     *
     * If you specify the DFA via command line arguments, make sure you surround
     * the DFA string codification between quotes (");
     *
     * @param args the command line arguments (DFA codification / file path)
     * @throws MalformedDFAException excepcion
     */
    public static void main(String[] args) throws MalformedDFAException {
        String dfaString = null, output = null;
        DFA inputDFA, outputDFA;

        try {
        	System.out.println("ARG: " + args[0]);
            dfaString = getStringAutomataFromFile(args[0]);
        } catch (IOException ioexn) {
            dfaString = args[0];
        } finally {
            inputDFA = parseDFA(dfaString);
            outputDFA = inputDFA.getConnectedDFA();

            output = ""
              + "\n-# INPUT DFA #-->\n"
              + inputDFA + "\n\n"
              + "-# OUTPUT DFA #-->\n"
              + outputDFA;

            System.out.println(output);
        }
    }

}
