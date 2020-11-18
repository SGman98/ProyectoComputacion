import java.util.ArrayList;
import java.util.Arrays;

import automatas.AFD;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a", "b"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0"));
        ArrayList<String> delta = new ArrayList<>(Arrays.asList("q0:a>q1", "q0:b>q2", "q1:b>q0", "q2:a>q0"));
        ArrayList<String> cadenas = new ArrayList<>();

        AFD afd = new AFD(alfabeto, estados, estadoInicial, estadosAceptacion, delta);
        // AFD afd = new AFD("test.dfa");

        cadenas.add("ababbaba");
        cadenas.add("aabab");
        cadenas.add("aababa");
        cadenas.add("");

        for (String string : cadenas) {
            afd.procesarCadenaConDetalles(string);
        }
        afd.procesarListaCadena(cadenas, "AFD", true);
        afd.toFile("ADF.dfa");
    }

}