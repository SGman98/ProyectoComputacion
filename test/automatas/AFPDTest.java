package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.*;

import src.automatas.*;

import static org.junit.Assert.assertEquals;

public class AFPDTest {

    AFPD afpd;
    HashMap<String, Boolean> cadenasExpected;

    public void crearAFPD() {
        // Test afpd a^n b^2n
        // Creacion del automata basico para pruebas
        ArrayList<String> alfabetoEntrada = new ArrayList<>(Arrays.asList("a", "b"));
        ArrayList<String> alfabetoPila = new ArrayList<>(Arrays.asList("$", "A"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0", "q2"));
        ArrayList<String> delta = new ArrayList<String>(
                Arrays.asList("q0:a:$~q1:A", "q0:b:A~q2:$", "q1:$:$~q0:A", "q2:b:A~q2:$"));
        afpd = new AFPD(estados, estadoInicial, estadosAceptacion, alfabetoEntrada, alfabetoPila, delta);

        // Todas las cadenas y su resultado esperado parael automata basico de pruebas
        cadenasExpected = new HashMap<>();
        cadenasExpected.put("abb", true);
        cadenasExpected.put("aaabb", false);
        cadenasExpected.put("bbbaa", false);
        cadenasExpected.put("babababa", false);
    }

    @Test
    public void procesarCadenaCodigo() {
        // Test Constructor(alfabeto, estados, estadoInicial, estadosAceptacion,delta)
        crearAFPD();
        // Test Booleano procesarCadena(cadena)
        for (Map.Entry<String, Boolean> pair : this.cadenasExpected.entrySet()) {
            assertEquals(pair.getValue(), this.afpd.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void procesarCadenaArchivo() {
        // Test Constructor(nombreArchivo)
        this.afpd = new AFPD("default.dpda");
        // Test Booleano procesarCadena(cadena)
        assertEquals(true, this.afpd.procesarCadena("abb")); // Cadena aceptada
        assertEquals(false, this.afpd.procesarCadena("aaabb")); // Cadena no aceptada
        assertEquals(false, this.afpd.procesarCadena("bbbaa")); // No termina en estado de aceptacion
        assertEquals(false, this.afpd.procesarCadena("babababa")); // No termina en estado de aceptacion
    }

    @Test
    public void procesarCadenaConDetalles() {
        // Test Booleano procesarCadenaConDetalles(cadena)
        crearAFPD();
        for (Map.Entry<String, Boolean> pair : this.cadenasExpected.entrySet()) {
            assertEquals(pair.getValue(), this.afpd.procesarCadena(pair.getKey()));
        }
    }
}
