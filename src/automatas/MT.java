package src.automatas;

import java.util.ArrayList;
import java.util.Arrays;

public class MT extends Automata {
    ArrayList<String> alfabetoPila; // Lenguaje de Pila Gamma

    public MT(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabeto, ArrayList<String> alfabetoPila, ArrayList<String> transiciones) {
        super(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetoPila;
        this.extension = ".mt";
    }

    public MT(String nombreArchivo) {
        super(nombreArchivo.contains(".mt") ? nombreArchivo : "default.mt");
    }

    @Override
    String procesarCadenaTexto(String cadena) {
        cadena = cadena.equals("") ? " " : cadena;
        ArrayList<String> cinta = new ArrayList<String>(Arrays.asList(cadena.split("|")));
        String proceso = "";
        if (!verificarAlfabetoSigma(cadena) && !cadena.equals(" ")) {
            return "Cadena no cumple con el alfabeto";
        }
        String estadoActual = this.estadoInicial;

        int pos = 0;
        String transicion = estadoActual + ":"
                + (pos < 0 || pos >= cinta.size() || cadena.equals(" ") ? "!" : cinta.get(pos));

        while (this.transiciones.get(transicion) != null) {
            // Crea llave de busqueda en transiciones de forma "q0:a"
            proceso += cinta.toString().replaceAll(", ", "").substring(1, pos + 1) + "(" + estadoActual + ")"
                    + cinta.toString().replaceAll(", ", "").substring(pos + 1, cinta.size() + 1) + "->";
            estadoActual = this.transiciones.get(transicion).get(0).split(":")[0];

            if (!transicion.split(":")[1].equals(this.transiciones.get(transicion).get(0).split(":")[1])) {
                cinta.set(pos, this.transiciones.get(transicion).get(0).split(":")[1]);
            }
            pos += (this.transiciones.get(transicion).get(0).split(":")[2].equals(">") ? 1
                    : this.transiciones.get(transicion).get(0).split(":")[2].equals("<") ? -1 : 0);
            transicion = estadoActual + ":" + (pos < 0 || pos >= cinta.size() ? "!" : cinta.get(pos));

        }
        // Termina de procesar la cadena
        proceso += cinta.toString().replaceAll(", ", "").substring(1, pos + 1) + "(" + estadoActual + ")"
                + cinta.toString().replaceAll(", ", "").substring(pos + 1, cinta.size() + 1) + ">>";

        // Mira si termino en un estado de aceptacion
        proceso += this.estadosAceptacion.contains(estadoActual) ? "accepted" : "rejected";

        return proceso;
    }

    boolean verificarAlfabetoGamma(String cadena) { // Verifica Alfabeto Sigma
        cadena.replaceAll("!", ""); // mantiene lor caracteres en blanco
        String regex = "[";
        for (String string : alfabetoPila)
            regex = regex + string;
        regex = regex + "]*";
        // String regex = this.alfabeto.toString().replaceAll(", ", "") + "*"; //
        // Verifica si la cadena entregada esta
        // conformada unicamente por caracteres en
        // el alfabeto
        return cadena.matches(regex);
    }

}
