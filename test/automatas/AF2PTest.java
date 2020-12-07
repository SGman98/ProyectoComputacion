/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

import src.automatas.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class AF2PTest {
    AF2P af2p;

    
    public AF2PTest() {
        
    }
    
    public void crearAf2p(){
        ArrayList<String> alfabetoEntrada = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> alfabetoPila = new ArrayList<>(Arrays.asList("$", "A"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0", "q2"));
        ArrayList<String> transiciones = new ArrayList<String>(Arrays.asList("q0:a:$:$~q0:A:A", "q0:b:A:$~q1:$:$", "q1:b:A:$~q1:$:$",
                "q1:c:$:A~q2:$:$", "q2:c:$:A~q2:$:$"));
        af2p = new AF2P(estados,estadoInicial,estadosAceptacion, alfabetoEntrada, alfabetoPila, transiciones);
        


        
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
         
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void procesarCadenaCodigo(){
        crearAf2p();
        // Test Booleano procesarCadena(cadena)
        
        assertEquals(false, af2p.procesarCadena("aaabbcc"));
        assertEquals(false, af2p.procesarCadena("baabbcc"));
        assertEquals(true, af2p.procesarCadena("aabbcc"));
        assertEquals(true,af2p.procesarCadena("aaaaaabbbbbbcccccc"));
        
    }
    
    @Test
    public void procesarCadenaArchivo(){
    this.af2p = new AF2P("default");
        
        assertEquals(false, this.af2p.procesarCadena("baabbaab")); 
        assertEquals(false, this.af2p.procesarCadena("abaabbaab")); 
        assertEquals(true, this.af2p.procesarCadena("aaabbbccc")); 
        assertEquals(false, this.af2p.procesarCadena("aaaaabbcc"));
    }
}
