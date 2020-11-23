import java.util.ArrayList;
import java.util.Arrays;

import automatas.AFD;
import automatas.AFN;

public class Main {
    public static void main(String[] args) {
        // AFN (ab U ac)*
        ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a", "b"));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0", "q1", "q2", "q3"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0"));
        ArrayList<String> delta = new ArrayList<>(Arrays.asList("q0:a>q1;q3", "q1:a>q2", "q2:b>q0", "q3:a>q0"));
        ArrayList<String> cadenas = new ArrayList<>();

        AFN afd = new AFN(alfabeto, estados, estadoInicial, estadosAceptacion, delta);
        // AFD afd = new AFD("test.dfa");

        cadenas.add("aabaab");
        cadenas.add("aaaa");
        cadenas.add("aaaab");
        cadenas.add("aaaaa");

        for (String string : cadenas) {
            afd.procesarCadenaConDetalles(string);
        }
        // afd.procesarListaCadena(cadenas, "AFN", true);
        // afd.toFile("AFN.hfjdskhfjkldsa");
    }

}