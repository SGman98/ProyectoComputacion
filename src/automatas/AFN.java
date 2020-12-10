package src.automatas;

import java.util.ArrayList;

public class AFN extends Automata {

    public AFN(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, ArrayList<String> transiciones) {
        super(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones);
        this.extension = ".nfa";
    }

    public AFN(String nombreArchivo) {
        super(nombreArchivo.contains(".nfa") ? nombreArchivo : "default.nfa");
    }

    public AFN(String nombreArchivo, Boolean b) {
        super(nombreArchivo.contains(".nfa") ? nombreArchivo : "default.nfa", b);
    }

    String procesarPaso(String cadena, String estadoActual, String proceso) {
        // System.out.print(!cadena.isEmpty()+";"+cadena+"---"+estadoActual+"**************");
        if (!cadena.isEmpty()) {
            String transicion = estadoActual + ":" + cadena.charAt(0);

            if (this.transiciones.get(transicion) != null) { // Busca si existe la transicion
                int prueba = 0;
                // Hacer una prueba mientras
                // la cadena no este aceptada
                // la cadena tenga mas pruebas
                while (!proceso.contains("accepted") && prueba < this.transiciones.get(transicion).size()) {
                    // Cambia de estado de forma provisional
                    String procesoPrueba = procesarPaso(cadena.substring(1),
                            this.transiciones.get(transicion).get(prueba),
                            proceso + "(" + estadoActual + "," + cadena + ")->");

                    prueba++; // Aumenta el numero para la siguiente prueba
                    proceso = procesoPrueba.contains("rejected") && prueba < this.transiciones.get(transicion).size()
                            ? proceso
                            : procesoPrueba;
                }
                return proceso;
            } else { // Se aborta este camino
                // System.out.println("Proceso abortado: "+proceso);
                return "";
            }
        }
        // Termina de procesar la cadena

        if (this.estadosAceptacion.contains(estadoActual)) { // Mira si termino en un estado de aceptacion
            proceso += "(" + estadoActual + ",$)>>accepted";
            return proceso;
        }
        proceso += "(" + estadoActual + ",$)>>rejected";

        return proceso;
    }

    @Override
    String procesarCadenaTexto(String cadena) {
        if (!verificarAlfabetoSigma(cadena)) {
            System.out.println("Cadena no cumple con el alfabeto");
            return "No cumple con el alfabeto";
        }
        return this.procesarPaso(cadena, this.estadoInicial, "");
    }
}
