package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.*;

import src.automatas.*;

import static org.junit.Assert.assertEquals;


public class AFDTest {
    AFD afd;
    HashMap<String, Boolean> cadenasExpected;

    public void crearAfd() {
        // Test AFD (ab U ba)*
        // Creacion del automata basico para pruebas
        ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a", "b"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0"));
        ArrayList<String> delta = new ArrayList<String>(Arrays.asList("q0:a~q1", "q0:b~q2", "q1:b~q0", "q2:a~q0"));

        afd = new AFD(alfabeto, estados, estadoInicial, estadosAceptacion, delta);

        // Todas las cadenas y su resultado esperado parael automata basico de pruebas
        cadenasExpected = new HashMap<>();
        cadenasExpected.put("baabbaab", true);
        cadenasExpected.put("abaabbaab", false);
        cadenasExpected.put("baabbaaba", false);
        cadenasExpected.put("baabbaabb", false);
    }

    @Test
    public void procesarCadenaCodigo() {
        // Test Constructor(alfabeto, estados, estadoInicial, estadosAceptacion,delta)
        crearAfd();
        // Test Booleano procesarCadena(cadena)
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.afd.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void procesarCadenaArchivo() {
        // Test Constructor(nombreArchivo)
        this.afd = new AFD("default");
        // Test Booleano procesarCadena(cadena)
        assertEquals(true, this.afd.procesarCadena("baabbaab")); // Cadena aceptada
        assertEquals(false, this.afd.procesarCadena("abaabbaab")); // Cadena no aceptada
        assertEquals(false, this.afd.procesarCadena("baabbaaba")); // No termina en estado de aceptacion
        assertEquals(false, this.afd.procesarCadena("baabbaabb")); // No termina en estado de aceptacion
    }

    @Test
    public void procesarCadenaConDetalles() {
        // Test Booleano procesarCadenaConDetalles(cadena)
        crearAfd();
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.afd.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void compararArchivoyCodigo() {
        crearAfd();
        // Test String toString()
        this.afd.toFile("testTexto"); // Crea un Archivo con el automata creado

        AFD afdFile = new AFD("testTexto");

        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            // Compara la misma cadena tanto en el afd del archivo como en el principal de
            // codigo
            assertEquals(afdFile.procesarCadena(pair.getKey()), this.afd.procesarCadena(pair.getKey()));
        }
    }

}