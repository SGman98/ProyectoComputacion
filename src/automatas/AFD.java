package automatas;

import java.util.ArrayList;

public class AFD extends Automata {
    public AFD(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, ArrayList<String> transiciones) {
        super(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones);
    }

    public AFD(String nombreArchivo) {
        super(nombreArchivo.contains(".dfa") ? nombreArchivo : "default.dfa");
    }

    @Override
    public String procesarCadenaTexto(String cadena) {
        String proceso = "";
        if (!verificarAlfabeto(cadena)) {
            System.out.println("Cadena no cumple con el alfabeto");
            return "No cumple con el alfabeto";
        }
        String estadoActual = this.estadoInicial;

        while (!cadena.isEmpty()) {
            // Crea llave de busqueda en transiciones de forma "q0:a"
            String transicion = estadoActual + ":" + cadena.charAt(0);
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

    public void toFile(String nombreArchivo) {
        super.toFile(nombreArchivo.contains(".dfa") ? nombreArchivo : "default.dfa");
    }
}
