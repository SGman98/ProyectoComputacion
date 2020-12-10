package src.automatas;

import java.util.ArrayList;

public class AFD extends Automata {

    public AFD(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, ArrayList<String> transiciones) {
        super(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones);
        this.extension = ".dfa";
    }

    public AFD(String nombreArchivo) {
        super(nombreArchivo.contains(".dfa") ? nombreArchivo : "default.dfa");
    }

    public AFD(String nombreArchivo, Boolean b) {
        super(nombreArchivo.contains(".dfa") ? nombreArchivo : "default.dfa", b);
    }

    @Override
    public String procesarCadenaTexto(String cadena) {
        String proceso = "";
        if (!verificarAlfabetoSigma(cadena)) {
            System.out.println("Cadena no cumple con el alfabeto");
            return "No cumple con el alfabeto";
        }
        String estadoActual = this.estadoInicial;

        // Crea llave de busqueda en transiciones de forma "q0:a"
        String transicion = estadoActual + ":" + (!cadena.isEmpty() ? cadena.charAt(0) : " ");

        while (this.transiciones.get(transicion) != null) { // Mientras la transicion exista
            proceso += "(" + estadoActual + "," + cadena + ")->";
            estadoActual = this.transiciones.get(transicion).get(0);
            cadena = cadena.substring(1);

            transicion = estadoActual + ":" + (!cadena.isEmpty() ? cadena.charAt(0) : " ");
        }

        // Termina de procesar la cadena
        proceso += "(" + estadoActual + "," + (cadena.isEmpty() ? "$" : cadena) + ")>>";
        // Mira si termino en un estado de aceptacion
        return proceso + (this.estadosAceptacion.contains(estadoActual) ? "accepted" : "rejected");
    }
}
