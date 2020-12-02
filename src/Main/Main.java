package src.Main;
import java.util.ArrayList;

import src.automatas.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cadenas = new ArrayList<>();

        MTP automata = new MTP("default.ttm");

        cadenas.add("aabbcc");
        cadenas.add("aaabbbccc");
        cadenas.add("aaabbcc");
        cadenas.add("aabbbcc");
        cadenas.add("aabbccc");

        for (String string : cadenas) {
            automata.procesarCadenaConDetalles(string);
        }
        // automata.procesarListaCadena(cadenas, "MTMC.mtmc", true);
        // automata.toFile("MTMC.mtmc");
        
    }

}