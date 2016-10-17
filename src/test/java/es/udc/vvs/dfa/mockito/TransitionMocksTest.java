package es.udc.vvs.dfa.mockito;

import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.dfa.Transition;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class TransitionMocksTest {

    Symbol symbolMock = Mockito.mock(Symbol.class);
    State stateMock = Mockito.mock(State.class);

    // symbol null, inicio y fin validos
    @Test
    public void testCrearTransition() throws NullPointerException {
        State inicio = stateMock;
        State fin = stateMock;
        Transition t = new Transition(inicio, fin, null);
    }
    
    // symbolo y fin validos, inicio no valido
    @Test
    public void testCrearTransition2() {
        State fin = stateMock;
        Transition t = new Transition(null, fin, null);
    }

    // symbolo y inicio validos, finno valido
    @Test
    public void testCrearTransition3() {
        State inicio = stateMock;
        Transition t = new Transition(inicio, null, null);
    }
    
    // Hashcode
    @Test
    public void testHashCode() {
        State inicio = stateMock;
        State fin = stateMock;
        Symbol symbol = symbolMock;
        
        Transition t = new Transition(inicio, fin, symbol);
        
        Transition t2 = new Transition(inicio, fin, symbol);
        
        assertEquals(t.hashCode(),t2.hashCode());
    }
    
    // Equals
    @Test
    public void testEquals() {
        State inicio = stateMock;
        State fin = stateMock;
        Symbol symbol = symbolMock;
        
        Transition t = new Transition(inicio, fin, symbol);
        
        Transition t2 = new Transition(inicio, fin, symbol);
        
        assertTrue(t.equals(t2));
    }
}
