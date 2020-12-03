package src.Main;
import java.util.ArrayList;

import src.automatas.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cadenas = new ArrayList<>();

        MTN automata = new MTN("default.ttm");

        cadenas.add("");
        cadenas.add("a");
        cadenas.add("aaaa");
        cadenas.add("aabb");
        cadenas.add("aaabbb");
        cadenas.add("aaabb");
        cadenas.add("aaab");
        cadenas.add("aabbb");
        cadenas.add("aaabc");

        for (String string : cadenas) {
            automata.procesarCadenaConDetalles(string);
        }
        // automata.procesarListaCadena(cadenas, "MTMC.mtmc", true);
        // automata.toFile("MTMC.mtmc");
        
    }

}