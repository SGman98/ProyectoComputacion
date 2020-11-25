package src;

import java.util.ArrayList;
import java.util.Arrays;

import src.automatas.*;

public class Main {
    public static void main(String[] args) {
        // AFN (ab U ac)*
        ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a", "b", "c"));
        ArrayList<String> alfabetoCinta = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2", "q3", "q4", "q5"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q5"));
        ArrayList<String> delta = new ArrayList<>(
                Arrays.asList("q0:a~q1:X:>", "q1:a~q1:a:>", "q1:Y~q1:Y:>", "q1:b~q2:Y:>", "q2:b~q2:b:>", "q2:Z~q2:Z:>",
                        "q2:c~q3:Z:<", "q3:a~q3:a:<", "q3:b~q3:b:<", "q3:Y~q3:Y:<", "q3:Z~q3:Z:<", "q3:X~q0:X:>",
                        "q0:!~q5:!:-", "q0:Y~q4:Y:>", "q4:Y~q4:Y:>", "q4:Z~q4:Z:>", "q4:!~q5:!:-"));
        ArrayList<String> cadenas = new ArrayList<>();

        MT afd = new MT(estados, estadoInicial, estadosAceptacion, alfabeto, alfabetoCinta, delta);
        // AFD afd = new AFD("test.dfa");

        cadenas.add("");
        cadenas.add("aabbcc");
        cadenas.add("aabb");
        cadenas.add("aaabbcc");
        cadenas.add("aabbbcc");
        cadenas.add("aabbccc");

        for (String string : cadenas) {
            afd.procesarCadenaConDetalles(string);
        }
        // afd.procesarListaCadena(cadenas, "MT.mt", true);
        afd.toFile("MT.mt");
    }

}