package src.automatas;

import java.util.ArrayList;
import java.util.Stack;

public class AFPD extends Automata {

    Stack<String> stack;

    public AFPD(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetopila, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetopila;
        this.extension = ".pda";
    }

    public AFPD(String nombreArchivo) {
        super(nombreArchivo.contains(".pda") ? nombreArchivo : "default.pda");
    }

    @Override
    public String procesarCadenaTexto(String cadena) {
        String proceso = "";
        this.stack = new Stack<>();
        this.stack.add("$");
        if (!verificarAlfabetoSigma(cadena)) {
            System.out.println("Cadena no cumple con el alfabeto");
            return "No cumple con el alfabeto Sigma";
        }
        String estadoActual = this.estadoInicial;

        while (encontrarTransicion(estadoActual,
                (!cadena.isEmpty() ? String.valueOf(cadena.charAt(0)) : " ")) != null) { // Mientras la transicion exista
            if (verificarAlfabetoGamma(mostrarPila())) {

                proceso += "(" + estadoActual + "," + cadena + "," + mostrarPila() + ")->";

                String transicion = encontrarTransicion(estadoActual,
                        (!cadena.isEmpty() ? String.valueOf(cadena.charAt(0)) : " "));

                modificarPila(this.stack, transicion.split(":")[2],
                        this.transiciones.get(transicion).get(0).split(":")[1]);

                estadoActual = this.transiciones.get(transicion).get(0).split(":")[0];

                //si hay una trasicion tipo q:$ no modifica la cadena
                if (!transicion.split(":")[1].equals("$")) {
                    cadena = cadena.substring(1);
                }
            } else {
                return "No cumple con el alfabeto Gamma";
            }
        }

        // Termina de procesar la cadena
        proceso += "(" + estadoActual + "," + (cadena.isEmpty() ? "$" : cadena) + ","
                + (this.stack.peek().equals("$") ? "$" : mostrarPila()) + ")>>";
        // Mira si termino en un estado de aceptacion
        return proceso + (this.estadosAceptacion.contains(estadoActual)
                && cadena.isEmpty()
                && this.stack.peek().equals("$") ? "accepted" : "rejected");

    }

    void modificarPila(Stack s, String operecion, String parametro) {
        if (operecion.equals("$")) {
            if (!parametro.equals("$")) {
                s.push(parametro); // Añade
            }
        } else {
            if (!stack.peek().equals("$")) {
                s.pop(); // Elimina
                if (!parametro.equals("$")) {
                    s.push(parametro); // Remplaza
                }
            }
        }

    }

    String encontrarTransicion(String estadoActual, String cabezaCinta) {
        //intenta encontrar llave con la forma estadoActual:$:alfabetoPila
        //ej q0:$:A
        for (String s : this.alfabetoPila) {
            if (this.transiciones.get(estadoActual + ":$:" + s) != null) {
                return (estadoActual + ":$:" + s);
            }
            //intenta encontrar llave con la forma estadoActual:cabezaCinta:alfabetoPila
            //ej q0:b:A
            if (this.transiciones.get(estadoActual + ":" + cabezaCinta + ":" + s) != null) {
                return (estadoActual + ":" + cabezaCinta + ":" + s);
            }
        }
        return null;
    }

    String mostrarPila() {
        //recorre la pila y la convierte 
        String out = "";
        for (String s : this.stack) {
            out += s;
        }
        return out;
    }
}
