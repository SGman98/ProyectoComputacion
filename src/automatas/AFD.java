package automatas;

import java.util.ArrayList;
import java.util.HashMap;

public class AFD extends Automata {
    public AFD(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, HashMap<String, ArrayList<String>> transiciones) {
        super(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones);
    }

    public AFD(String nombreArchivo) {
        super(nombreArchivo);
    }

    public String procesarCadenaTexto(String cadena) {
        String proceso = "";
        if (!verificarAlfabeto(cadena)) {
            System.out.println("Cadena no cumple con el alfabeto");
            return "No cumple con el alfabeto";
        }
        String estadoActual = this.estadoInicial;
        // Separamos la cadena en caracteres individuales. si la cadena esta vacia se
        // hace un arreglo vacio
        String[] cadenaLectura = cadena == "" ? new String[0] : cadena.split("|");

        for (int i = 0; i < cadenaLectura.length; i++) {
            // Crea llave de busqueda en transiciones de forma "q0:a"
            String transicion = estadoActual + ":" + cadenaLectura[i];

            if (this.transiciones.get(transicion) != null) { // Busca si existe la transicion
                proceso += "(" + estadoActual + "," + cadena + ")->";
                estadoActual = this.transiciones.get(transicion).get(0);
                cadena = cadena.substring(1);
            } else { // Cadena Abortada cuando no existe la transicion
                proceso += "(" + estadoActual + "," + cadena + ")>>rejected";
                return proceso;
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
}
