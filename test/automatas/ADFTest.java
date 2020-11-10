package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import automatas.AFD;

public class ADFTest {
    AFD afd;

    @Before
    public void setUp() {
        // Test AFD (ab U ba)*
        // Creacion del automata
        ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0","q1","q2"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0"));
        HashMap<String,ArrayList<String>> delta = new HashMap<String,ArrayList<String>>();
        delta.put("q0:a", new ArrayList<>(Arrays.asList("q1")));
        delta.put("q0:b", new ArrayList<>(Arrays.asList("q2")));
        delta.put("q1:b", new ArrayList<>(Arrays.asList("q0")));
        delta.put("q2:a", new ArrayList<>(Arrays.asList("q0")));

        afd = new AFD(alfabeto, estados, estadoInicial, estadosAceptacion, delta);
    }

    @Test
    public void procesarCadenaConDetalles() {
        assertEquals(true, this.afd.procesarCadena("baabbaab"));     // Cadena aceptada
        assertEquals(false, this.afd.procesarCadena("abaabbaab"));   // Cadena no aceptada 
        assertEquals(false, this.afd.procesarCadena("baabbaaba"));   // No termina en estado de aceptacion
        assertEquals(false, this.afd.procesarCadena("baabbaabb"));   // No termina en estado de aceptacion
    }
    
}
