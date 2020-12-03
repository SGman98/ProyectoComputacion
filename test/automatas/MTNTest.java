package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import src.automatas.MTN;

public class MTNTest {
    MTN mtn;
    HashMap<String, Boolean> cadenasExpected;

    public void crearMTN() {
        ArrayList<String> alfabetoEntrada = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> alfabetoCinta = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        ArrayList<String> estados = new ArrayList<>(
                Arrays.asList("q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9"));
        String estadoInicial = "q6";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q5"));
        ArrayList<String> delta = new ArrayList<>(Arrays.asList("q6:!~q5:!:-", "q6:a~q7:a:>", "q6:b~q7:b:>",
                "q7:a~q7:a:>", "q7:b~q7:b:>", "q7:!~q8:!:-", "q8:!~q9:!:<;q8:a:>;q8:b:>;q8:c:>", "q9:a~q9:a:<",
                "q9:b~q9:b:<", "q9:c~q9:c:<", "q9:!~q0:!:>", "q0:a~q1:X:>", "q0:!~q5:!:-", "q0:Y~q4:Y:>", "q1:Y~q1:Y:>",
                "q1:a~q1:a:>", "q3:X~q0:X:>", "q2:Z~q2:Z:>", "q3:Y~q3:Y:<", "q3:Z~q3:Z:<", "q4:Y~q4:Y:>", "q4:Z~q4:Z:>",
                "q1:b~q2:Y:>", "q2:b~q2:b:>", "q3:a~q3:a:<", "q2:c~q3:Z:<", "q3:b~q3:b:<", "q4:!~q5:!:-"));

        mtn = new MTN(estados, estadoInicial, estadosAceptacion, alfabetoEntrada, alfabetoCinta, delta);

        // Todas las cadenas y su resultado esperado parael automata basico de pruebas
        cadenasExpected = new HashMap<>();
        cadenasExpected.put("", true);
        cadenasExpected.put("a", true);
        cadenasExpected.put("aaa", true);
        cadenasExpected.put("aabb", true);
        cadenasExpected.put("aaabb", true);
        cadenasExpected.put("aaabc", false);
        cadenasExpected.put("abb", false);
        cadenasExpected.put("aabbb", false);
    }

    @Test
    public void procesarCadenaCodigo() {
        // Test Constructor(alfabeto, estados, estadoInicial, estadosAceptacion,delta)
        crearMTN();
        // Test Booleano procesarCadena(cadena)
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mtn.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void procesarCadenaArchivo() {
        // Test Constructor(nombreArchivo)
        this.mtn = new MTN("default");
        // Test Booleano procesarCadena(cadena)
        assertEquals(true, this.mtn.procesarCadena("")); // Cadena aceptada
        assertEquals(true, this.mtn.procesarCadena("a")); // Cadena aceptada
        assertEquals(true, this.mtn.procesarCadena("aaa")); // Cadena aceptada
        assertEquals(true, this.mtn.procesarCadena("aabb")); // Cadena no aceptada
        assertEquals(true, this.mtn.procesarCadena("aaabb")); // Cadena no aceptada
        assertEquals(false, this.mtn.procesarCadena("aaabc")); // Cadena no aceptada
        assertEquals(false, this.mtn.procesarCadena("abb")); // Cadena no aceptada
        assertEquals(false, this.mtn.procesarCadena("aabbb")); // Cadena no aceptada
    }

    @Test
    public void procesarCadenaConDetalles() {
        // Test Booleano procesarCadenaConDetalles(cadena)
        crearMTN();
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mtn.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void compararArchivoyCodigo() {
        crearMTN();
        // Test String toString()
        this.mtn.toFile("testTexto"); // Crea un Archivo con el automata creado

        MTN mtnFile = new MTN("testTexto");

        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            // Compara la misma cadena tanto en el afd del archivo como en el principal de
            // codigo
            assertEquals(mtnFile.procesarCadena(pair.getKey()), this.mtn.procesarCadena(pair.getKey()));
        }
    }
}
