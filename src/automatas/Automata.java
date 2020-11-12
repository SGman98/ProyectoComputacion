package automatas;

import java.util.ArrayList;
import java.util.HashMap;

// Clase abstracta con la mayoria de los atributos y metodos necesarios para todas las clases

public abstract class Automata {
    ArrayList<String> alfabeto;                     // Lenguaje de Cinta Sigma (Para automatas con pila)
    ArrayList<String> estados;                      // 
    String estadoInicial;                           //
    ArrayList<String> estadosAceptacion;            //
    HashMap<String,ArrayList<String>> transiciones; // transicion q0:a>q1 --> <q0:a, q1>

    public Automata (ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion, HashMap<String,ArrayList<String>> transiciones) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosAceptacion = estadosAceptacion;
        this.transiciones = transiciones;
    }

    public Automata (String nombreArchivo) {
        
    }

    public abstract boolean procesarCadena(String cadena);

    public abstract boolean procesarCadenaConDetalles(String cadena);

    public abstract boolean procesarListaCadena(String listaCadenas, String nombreArchivo, boolean imprimirPantalla);

    public boolean verificarAlfabeto(String cadena) { //Verifica Alfabeto Sigma
        // String regex = "[";
        // for (String string : alfabeto)
        //     regex = regex+string;
        // regex = regex+"]*";
        String regex = this.alfabeto.toString().replaceAll(", ", "")+"*"; // Verifica si la cadena entregada esta conformada unicamente por caracteres en el alfabeto
        return cadena.matches(regex);
    }

    public String toString() {
        return "";
    }
}