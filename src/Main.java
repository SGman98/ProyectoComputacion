import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import automatas.AFD;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> alfabeto = new ArrayList<>(Arrays.asList("a", "b", ",", " "));
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("q0","q1","q2"));
        String estadoInicial = "q0";
        ArrayList<String> estadosAceptacion = new ArrayList<>(Arrays.asList("q0", "q2"));
        HashMap<String,ArrayList<String>> delta = new HashMap<String,ArrayList<String>>();
        delta.put("q0:a", new ArrayList<>(Arrays.asList("q0")));
        delta.put("q0:b", new ArrayList<>(Arrays.asList("q1")));
        delta.put("q1:a", new ArrayList<>(Arrays.asList("q1")));
        delta.put("q1:b", new ArrayList<>(Arrays.asList("q2")));
        delta.put("q2:a", new ArrayList<>(Arrays.asList("q1")));
        delta.put("q2:b", new ArrayList<>(Arrays.asList("q1")));

        AFD afd = new AFD(alfabeto, estados, estadoInicial, estadosAceptacion, delta);

        afd.procesarCadenaConDetalles("aabab");
        afd.procesarCadenaConDetalles("aababa");
        afd.procesarCadenaConDetalles("");
    }

}