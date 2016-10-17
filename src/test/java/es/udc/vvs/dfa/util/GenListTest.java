/*package es.udc.vvs.dfa.util;

import es.udc.vvs.dfa.dfa.*;
import es.udc.vvs.dfa.dfa.*;
import es.udc.vvs.dfa.util.GenList;
import org.junit.Test;
import static org.junit.Assert.*;


public class GenListTest {

@Test
public void testCrearGenList() {
    GenList genList = new GenList(-1);
    assertEquals(genList.getBuffer(),1);
}

// Numero de elementos = buffer
@Test
public void testAdd() {
    Symbol symbol = new Symbol("1");
    Symbol symbol2 = new Symbol("1");
    assertEquals(symbol.hashCode(),symbol2.hashCode());
}

// Numero de elementos < buffer
@Test
public void testAdd2() {
    Symbol symbol = new Symbol("1");
    Symbol symbol2 = new Symbol("1");
    assertTrue(symbol.equals(symbol2));
}

// Añadir un null
@Test
public void testAdd3() {
    Symbol symbol = new Symbol("1");
    Symbol symbol2 = new Symbol("12");
    assertEquals(symbol.equals(symbol2),false);
}
}*/