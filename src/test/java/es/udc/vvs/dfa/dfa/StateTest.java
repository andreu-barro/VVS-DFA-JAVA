package es.udc.vvs.dfa.dfa;

import es.udc.vvs.dfa.dfa.*;
import es.udc.vvs.dfa.util.GenList;
import es.udc.vvs.dfa.dfa.Symbol;
import org.junit.Test;
import static org.junit.Assert.*;


public class StateTest {

@Test
public void testCrearState() throws NullPointerException {
    State state = new State(null);
}

@Test
public void testHashCode() {
    State state = new State("1");
    State state2 = new State("1");
    assertEquals(state.hashCode(),state2.hashCode());
}

@Test
public void testEqualsState() {
    State state = new State("1");
    State state2 = new State("1");
    assertTrue(state.equals(state2));
}

@Test
public void testEqualsState2() {
    State state = new State("1");
    State state2 = new State("12");
    assertEquals(state.equals(state2),false);
}
}