package es.udc.vvs.dfa.mockito;

import es.udc.vvs.dfa.dfa.Alphabet;
import es.udc.vvs.dfa.dfa.DFA;
import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.dfa.Transition;
import es.udc.vvs.dfa.util.GenList;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class DFAMocksTest {

    GenList genListMock = Mockito.mock(GenList.class);
    State stateMock = Mockito.mock(State.class);
    Alphabet alphabetMock = Mockito.mock(Alphabet.class);
    Transition transitionMock = Mockito.mock(Transition.class);
        
    // states null
    @Test
    public void testCrearDFA() throws NullPointerException {
        Alphabet alphabet = alphabetMock;
        State state = stateMock;
        GenList genList = genListMock;
        
        DFA dfa = new DFA(null, alphabet, state, 
                genList, genList);
    }
    
    // alphabet null
    @Test
    public void testCrearDFA2() throws NullPointerException {
        State state = stateMock;
        GenList genList = genListMock;
        
        DFA dfa = new DFA(genList, null, state, 
                genList, genList);
    }
    
    // dfa null
    @Test
    public void getConnectedDFA() throws NullPointerException {
        State state = stateMock;
        GenList genList = genListMock;
        
        DFA dfa = null;
        dfa.getConnectedDFA();
    }
}
