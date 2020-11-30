package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import src.automatas.MTMC;

public class MTMCTest {
    MTMC mtmc;
    HashMap<String, Boolean> cadenasExpected;

    public void crearMTMC() {
        ArrayList<String> alfabetoEntrada = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> alfabetoCinta = new ArrayList<>(Arrays.asList("X"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2", "q3", "q4"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q4"));
        ArrayList<String> delta = new ArrayList<>(
                Arrays.asList("q0:a:!~q1:a:>:X:>", "q0:!:!~q4:!:-:!:-", "q1:a:!~q1:a:>:X:>", "q1:b:!~q2:b:-:!:<",
                        "q2:b:X~q2:b:>:X:<", "q2:c:!~q3:c:-:!:>", "q3:c:X~q3:c:>:X:>", "q3:!:!~q4:!:-:!:-"));

        mtmc = new MTMC(estados, estadoInicial, estadosAceptacion, alfabetoEntrada, alfabetoCinta, delta);

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
        crearMTMC();
        // Test Booleano procesarCadena(cadena)
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mtmc.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void procesarCadenaArchivo() {
        // Test Constructor(nombreArchivo)
        this.mtmc = new MTMC("default");
        // Test Booleano procesarCadena(cadena)
        assertEquals(true, this.mtmc.procesarCadena("")); // Cadena aceptada
        assertEquals(true, this.mtmc.procesarCadena("aabbcc")); // Cadena aceptada
        assertEquals(true, this.mtmc.procesarCadena("aaabbbccc")); // Cadena aceptada
        assertEquals(false, this.mtmc.procesarCadena("aabb")); // Cadena no aceptada
        assertEquals(false, this.mtmc.procesarCadena("aaabbcc")); // Cadena no aceptada
        assertEquals(false, this.mtmc.procesarCadena("aabbbcc")); // Cadena no aceptada
        assertEquals(false, this.mtmc.procesarCadena("aabbccc")); // Cadena no aceptada
    }

    @Test
    public void procesarCadenaConDetalles() {
        // Test Booleano procesarCadenaConDetalles(cadena)
        crearMTMC();
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mtmc.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void compararArchivoyCodigo() {
        crearMTMC();
        // Test String toString()
        this.mtmc.toFile("testTexto"); // Crea un Archivo con el automata creado

        MTMC mtmcFile = new MTMC("testTexto");

        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            // Compara la misma cadena tanto en el afd del archivo como en el principal de
            // codigo
            assertEquals(mtmcFile.procesarCadena(pair.getKey()), this.mtmc.procesarCadena(pair.getKey()));
        }
    }
}
