package src.automatas;

import java.util.ArrayList;
import java.util.Arrays;

public class MT extends Automata {

    public MT(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetoCinta, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetoCinta;
        this.extension = ".mt";
    }

    public MT(String nombreArchivo) {
        super(nombreArchivo.contains(".mt") ? nombreArchivo : "default.mt");
    }

    @Override
    String procesarCadenaTexto(String cadena) {
        cadena = cadena.equals("") ? "!" : cadena; // Para evitar carácteres adicionales en la impresion
        ArrayList<String> cinta = new ArrayList<String>(Arrays.asList(cadena.split("|")));
        String proceso = "";
        if (!verificarAlfabetoSigma(cadena)) {
            return "Cadena no cumple con el alfabeto";
        }
        String estadoActual = this.estadoInicial;

        int pos = 0; // Variable para saber la posicion de la cabeza de lectura
        // Crea la transicion teniendo en cuenta el carácter blanco tomandolo como "!"
        String transicion = estadoActual + ":" + (pos < 0 || pos >= cinta.size() ? "!" : cinta.get(pos));

        while (this.transiciones.get(transicion) != null) { // Sigue procesando mientras exista la transicion

            // el proceso es la Cinta hasta pos + estadoActual + el resto de la cinta
            proceso += cinta.toString().replaceAll(", ", "").substring(1, pos + 1) + "(" + estadoActual + ")"
                    + cinta.toString().replaceAll(", ", "").substring(pos + 1, cinta.size() + 1) + "->";
            estadoActual = this.transiciones.get(transicion).get(0).split(":")[0];

            // Mira si hay cambio en el carácter de la cinta si hay cambio lo actualiza
            // si no entonces no hace nada
            if (!transicion.split(":")[1].equals(this.transiciones.get(transicion).get(0).split(":")[1])) {
                cinta.set(pos, this.transiciones.get(transicion).get(0).split(":")[1]);
            }
            // Actualiza la posicion segun el simbolo final en la segunda parte de la
            // transicion. Si es ">" aumenta 1, si es "<" disminuye 1, y si no es ninguno de
            // los 2 es decir si es "-" no hace nada
            pos += (this.transiciones.get(transicion).get(0).split(":")[2].equals(">") ? 1
                    : this.transiciones.get(transicion).get(0).split(":")[2].equals("<") ? -1 : 0);
            transicion = estadoActual + ":" + (pos < 0 || pos >= cinta.size() ? "!" : cinta.get(pos));

        }
        // Al terminar de procesar la cadena
        proceso += cinta.toString().replaceAll(", ", "").substring(1, pos + 1) + "(" + estadoActual + ")"
                + cinta.toString().replaceAll(", ", "").substring(pos + 1, cinta.size() + 1) + ">>";

        // Mira si termino en un estado de aceptacion
        proceso += this.estadosAceptacion.contains(estadoActual) ? "accepted" : "rejected";

        return proceso;
    }

}
