package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import src.automatas.MT;

public class MTTest {
    MT mt;
    HashMap<String, Boolean> cadenasExpected;

    public void crearMT() {
        ArrayList<String> alfabetoEntrada = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> alfabetoCinta = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2", "q3", "q4", "q5"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q5"));
        ArrayList<String> delta = new ArrayList<>(
                Arrays.asList("q0:a~q1:X:>", "q1:a~q1:a:>", "q1:Y~q1:Y:>", "q1:b~q2:Y:>", "q2:b~q2:b:>", "q2:Z~q2:Z:>",
                        "q2:c~q3:Z:<", "q3:a~q3:a:<", "q3:b~q3:b:<", "q3:Y~q3:Y:<", "q3:Z~q3:Z:<", "q3:X~q0:X:>",
                        "q0:!~q5:!:-", "q0:Y~q4:Y:>", "q4:Y~q4:Y:>", "q4:Z~q4:Z:>", "q4:!~q5:!:-"));

        mt = new MT(estados, estadoInicial, estadosAceptacion, alfabetoEntrada, alfabetoCinta, delta);

        // Todas las cadenas y su resultado esperado parael automata basico de pruebas
        cadenasExpected = new HashMap<>();
        cadenasExpected.put("", true);
        cadenasExpected.put("aabbcc", true);
        cadenasExpected.put("aaabbbccc", true);
        cadenasExpected.put("aabb", false);
        cadenasExpected.put("aaabbcc", false);
        cadenasExpected.put("aabbbcc", false);
        cadenasExpected.put("aabbccc", false);
    }

    @Test
    public void procesarCadenaCodigo() {
        // Test Constructor(alfabeto, estados, estadoInicial, estadosAceptacion,delta)
        crearMT();
        // Test Booleano procesarCadena(cadena)
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mt.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void procesarCadenaArchivo() {
        // Test Constructor(nombreArchivo)
        this.mt = new MT("default");
        // Test Booleano procesarCadena(cadena)
        assertEquals(true, this.mt.procesarCadena("")); // Cadena aceptada
        assertEquals(true, this.mt.procesarCadena("aabbcc")); // Cadena aceptada
        assertEquals(true, this.mt.procesarCadena("aaabbbccc")); // Cadena aceptada
        assertEquals(false, this.mt.procesarCadena("aabb")); // Cadena no aceptada
        assertEquals(false, this.mt.procesarCadena("aaabbcc")); // Cadena no aceptada
        assertEquals(false, this.mt.procesarCadena("aabbbcc")); // Cadena no aceptada
        assertEquals(false, this.mt.procesarCadena("aabbccc")); // Cadena no aceptada
    }

    @Test
    public void procesarCadenaConDetalles() {
        // Test Booleano procesarCadenaConDetalles(cadena)
        crearMT();
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mt.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void compararArchivoyCodigo() {
        crearMT();
        // Test String toString()
        this.mt.toFile("testTexto"); // Crea un Archivo con el automata creado

        MT mtFile = new MT("testTexto");

        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            // Compara la misma cadena tanto en el afd del archivo como en el principal de
            // codigo
            assertEquals(mtFile.procesarCadena(pair.getKey()), this.mt.procesarCadena(pair.getKey()));
        }
    }
}
