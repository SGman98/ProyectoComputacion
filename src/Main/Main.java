package src.Main;
import java.util.ArrayList;

import src.automatas.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cadenas = new ArrayList<>();

        AFPD automata = new AFPD("default.pda");

        cadenas.add("abb");
        cadenas.add("aabb");
        cadenas.add("aaabb");
        cadenas.add("aaabbbbbb");

        for (String string : cadenas) {
            automata.procesarCadenaConDetalles(string);
        }
        // automata.procesarListaCadena(cadenas, "MTMC.mtmc", true);
        // automata.toFile("MTMC.mtmc");
        
    }

}