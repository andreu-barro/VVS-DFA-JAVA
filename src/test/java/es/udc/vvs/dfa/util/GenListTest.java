package es.udc.vvs.dfa.util;

import es.udc.vvs.dfa.dfa.*;
import es.udc.vvs.dfa.dfa.*;
import es.udc.vvs.dfa.util.GenList;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class GenListTest {

// Buffer<0
@Test
public void testCrearGenList() {
    GenList genList = new GenList(-1);
    assertEquals(genList.getBuffer(),1);
}

// Buffer vacio
@Test
public void testCrearGenList2() {
    GenList genList = new GenList();
    assertEquals(genList.getBuffer(),1);
}

// Buffer N
@Test
public void testCrearGenList3() {
    GenList genList = new GenList(20);
    assertEquals(genList.getBuffer(),20);
}

// Añadir 1 elemento a la lista generica vacia
@Test
public void testAdd() {
    ArrayList lista = new ArrayList();
    lista.add("a");
    GenList genList = new GenList();
    genList.add("a");
}

// Añadir 1 elemento con numeroElementos=buffer
@Test
public void testAdd2() {
    ArrayList lista = new ArrayList();
    lista.add("a");
    GenList genList = new GenList();
    genList.add("a");

    genList.add("b");
    assertEquals(lista.get(0),genList.get(0));
    assertEquals(2,genList.getSize());
}

// Añadir 1 elemento con numeroElementos<buffer
@Test
public void testAdd3() {
    ArrayList lista = new ArrayList();
    lista.add("a");
    GenList genList = new GenList(2);
    genList.add("a");

    genList.add("b");
    assertEquals(lista.get(0),genList.get(0));
    assertEquals(lista.get(1),genList.get(1));
    assertEquals(2,genList.getSize());
}

// Añadir un null
@Test
public void testAdd4() throws NullPointerException {
    GenList genList = new GenList();
    genList.add(null);
}

// Posicion negativa
@Test
public void testRemove() {
    GenList genList = new GenList();
    genList.add("a");
    boolean pasa = true;
    try {
    genList.remove(-1);
    }
    catch (Exception e) {
        pasa=false;
    }
    assertTrue(!pasa);
    
    pasa = true;
    try {
    genList.remove(10);
    }
    catch (Exception e) {
        pasa=false;
    }
    assertTrue(!pasa);
}

// lista = null
@Test
public void testRemove2() {
    GenList genList = new GenList();
    genList.add("a");

    boolean pasa = true;
    genList.remove(0);
    try {
    genList.get(0);
    }
    catch (NullPointerException ex) {
        pasa=false;
    }
    assertTrue(!pasa);
}

// Posicion no valida
@Test
public void testGet() {
    GenList genList = new GenList();
    genList.add("a");
    boolean pasa = true;
    try {
    genList.get(-1);
    }
    catch (Exception e) {
        pasa=false;
    }
    assertTrue(!pasa);
    
    pasa = true;
    try {
    genList.get(10);
    }
    catch (Exception e) {
        pasa=false;
    }
    assertTrue(!pasa);
}

// Posicion valida y lista valida
@Test
public void testGet2() {
    GenList genList = new GenList();
    genList.add("a");
    boolean pasa = true;
    genList.get(0);
}

// Objeto está y lista valida
@Test
public void testGetExistingObject() {
    GenList genList = new GenList();
    genList.add("a");
    assertEquals("a",genList.getExistingObject("a"));
}

// Objeto no está y lista valida
@Test
public void testGetExistingObject2() {
    GenList genList = new GenList();
    genList.add("a");
    assertEquals(null,genList.getExistingObject("b"));
}

// Lista vacia
@Test
public void testGetExistingObject3() {
    GenList genList = new GenList();
    assertEquals(null,genList.getExistingObject("b"));
}

}