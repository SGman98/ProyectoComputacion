import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import automatas.AFD;

public class Main {

    public static void main(String[] args) {
        // Test AFD temporal  (ab U ba)*
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

        AFD test = new AFD(alfabeto, estados, estadoInicial, estadosAceptacion, delta);

        System.out.println(test.procesarCadena("baabbaab"));
    }

}