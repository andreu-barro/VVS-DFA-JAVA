package es.udc.vvs.dfa.dfa;

import es.udc.vvs.dfa.dfa.*;
import es.udc.vvs.dfa.util.GenList;
import es.udc.vvs.dfa.dfa.Symbol;
import org.junit.Test;
import static org.junit.Assert.*;


public class SymbolTest {

@Test
public void testCrearSymbol() throws NullPointerException {
    Symbol symbol = new Symbol(null);
}

@Test
public void testHashCode() {
    Symbol symbol = new Symbol("1");
    Symbol symbol2 = new Symbol("1");
    assertEquals(symbol.hashCode(),symbol2.hashCode());
}

@Test
public void testEqualsSymbol() {
    Symbol symbol = new Symbol("1");
    Symbol symbol2 = new Symbol("1");
    assertTrue(symbol.equals(symbol2));
}

@Test
public void testEqualsSymbol2() {
    Symbol symbol = new Symbol("1");
    Symbol symbol2 = new Symbol("12");
    assertEquals(symbol.equals(symbol2),false);
}
}