package src.Main;

import java.util.ArrayList;

import src.automatas.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cadenas = new ArrayList<>();

        AFPN automata = new AFPN("default.pda");

        cadenas.add("abcc");
        // cadenas.add("aabbcccc");
        // cadenas.add("abcc");
        // cadenas.add("aaabbbcccccc");
        // cadenas.add("aabbccc");
        // cadenas.add("aabbccccc");

        // cadenas.add("abab");
        // cadenas.add("ababa");
        // cadenas.add("baba");
        // cadenas.add("babab");
        // cadenas.add("bbaa");
        // cadenas.add("aabb");
        // cadenas.add("bbababaa");
        // cadenas.add("bbaaaabb");

        for (String string : cadenas) {
            automata.procesarCadenaConDetalles(string);
        }
        // automata.procesarListaCadena(cadenas, "MTMC.mtmc", true);
        // automata.toFile("MTMC.mtmc");

    }

}