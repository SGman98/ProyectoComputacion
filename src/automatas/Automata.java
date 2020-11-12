package automatas;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// Clase abstracta con la mayoria de los atributos y metodos necesarios para todas las clases

public abstract class Automata {
    ArrayList<String> alfabeto; // Lenguaje de Cinta Sigma (Para automatas con pila)
    ArrayList<String> estados;
    String estadoInicial;
    ArrayList<String> estadosAceptacion;
    HashMap<String, ArrayList<String>> transiciones; // transicion q0:a>q1 --> <q0:a, q1>

    public Automata(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, HashMap<String, ArrayList<String>> transiciones) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosAceptacion = estadosAceptacion;
        this.transiciones = transiciones;
    }
    
    public Automata(String nombreArchivo) {
        // Idea: El archivo esta dividido en secciones
        // Leer el inicio de la seccion y comenzar un bucle de lectura hasta que encuentre otra seccion
        this.alfabeto = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.estadosAceptacion = new ArrayList<>();
        this.transiciones = new HashMap<>();
        
        try {
            File myobj = new File(nombreArchivo);
            Scanner myReader = new Scanner(myobj);
            String seccion = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // System.out.println(data);
                if(data.contains("#") || data.equals("")) seccion = data;
                else {
                    switch (seccion) {
                        case "#alphabet":   
                            this.alfabeto.add(data);
                            break;
                        case "#states":
                            this.estados.add(data);
                            break;
                        case "#initial":
                            this.estadoInicial = data;
                            break;
                        case "#accepting":
                            this.estadosAceptacion.add(data);
                            break;
                        case "#transitions":
                            String transicion = data.split(">")[0];
                            String transicionFinal = data.split(">")[1];
                            this.transiciones.put(transicion, new ArrayList<>(Arrays.asList(transicionFinal)));
                            break;
                        default:
                            break;
                    }
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public abstract boolean procesarCadena(String cadena);

    public abstract boolean procesarCadenaConDetalles(String cadena);

    public abstract boolean procesarListaCadena(String listaCadenas, String nombreArchivo, boolean imprimirPantalla);

    public boolean verificarAlfabeto(String cadena) { // Verifica Alfabeto Sigma
        // String regex = "[";
        // for (String string : alfabeto)
        // regex = regex+string;
        // regex = regex+"]*";
        String regex = this.alfabeto.toString().replaceAll(", ", "") + "*"; // Verifica si la cadena entregada esta conformada unicamente por caracteres en el alfabeto
        return cadena.matches(regex);
    }

    public String toString() {
        return "";
    }
}