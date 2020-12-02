package test.automatas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.*;
import static org.junit.Assert.assertEquals;

import src.automatas.MTP;

public class MTPTest {
    MTP mtp;
    HashMap<String, Boolean> cadenasExpected;

    public void crearMTMC() {
        ArrayList<String> alfabetoEntrada = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> alfabetoCinta = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2", "q3", "q4", "q5"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q5"));
        ArrayList<String> delta = new ArrayList<>(Arrays.asList("q0:a:!~q1:a:A:>", "q0:!:!~q5:!:!:-", "q1:a:!~q1:a:!:>",
                "q1:b:B~q1:b:B:>", "q1:b:!~q2:b:B:>", "q2:b:!~q2:b:!:>", "q2:c:C~q2:c:C:>", "q2:c:!~q3:c:C:<",
                "q3:c:C~q3:c:C:<", "q3:b:!~q3:b:!:<", "q3:b:B~q3:b:B:<", "q3:a:!~q3:a:!:<", "q3:a:A~q0:a:A:>",
                "q0:b:B~q4:b:B:>", "q4:b:B~q4:b:B:>", "q4:c:C~q4:c:C:>", "q4:!:!~q5:!:!:-"));

        mtp = new MTP(estados, estadoInicial, estadosAceptacion, alfabetoEntrada, alfabetoCinta, delta);

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
            assertEquals(pair.getValue(), this.mtp.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void procesarCadenaArchivo() {
        // Test Constructor(nombreArchivo)
        this.mtp = new MTP("default");
        // Test Booleano procesarCadena(cadena)
        assertEquals(true, this.mtp.procesarCadena("")); // Cadena aceptada
        assertEquals(true, this.mtp.procesarCadena("aabbcc")); // Cadena aceptada
        assertEquals(true, this.mtp.procesarCadena("aaabbbccc")); // Cadena aceptada
        assertEquals(false, this.mtp.procesarCadena("aabb")); // Cadena no aceptada
        assertEquals(false, this.mtp.procesarCadena("aaabbcc")); // Cadena no aceptada
        assertEquals(false, this.mtp.procesarCadena("aabbbcc")); // Cadena no aceptada
        assertEquals(false, this.mtp.procesarCadena("aabbccc")); // Cadena no aceptada
    }

    @Test
    public void procesarCadenaConDetalles() {
        // Test Booleano procesarCadenaConDetalles(cadena)
        crearMTMC();
        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            assertEquals(pair.getValue(), this.mtp.procesarCadena(pair.getKey()));
        }
    }

    @Test
    public void compararArchivoyCodigo() {
        crearMTMC();
        // Test String toString()
        this.mtp.toFile("testTexto"); // Crea un Archivo con el automata creado

        MTP mtpFile = new MTP("testTexto");

        for (Iterator<Map.Entry<String, Boolean>> it = this.cadenasExpected.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Boolean> pair = it.next();
            // Compara la misma cadena tanto en el afd del archivo como en el principal de
            // codigo
            assertEquals(mtpFile.procesarCadena(pair.getKey()), this.mtp.procesarCadena(pair.getKey()));
        }
    }
}
