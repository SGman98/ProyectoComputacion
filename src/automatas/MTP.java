package src.automatas;

import java.util.ArrayList;
import java.util.Arrays;

public class MTP extends Automata {

    public MTP(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetoCinta, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetoCinta;
        this.extension = ".ttm";
    }

    public MTP(String nombreArchivo) {
        super(nombreArchivo.contains(".ttm") ? nombreArchivo : "default.ttm");
    }

    @Override
    String procesarCadenaTexto(String cadena) {
        cadena = cadena.equals("") ? "!" : cadena; // Para evitar carácteres adicionales en la impresion

        String proceso = "";
        if (!verificarAlfabetoSigma(cadena)) {
            return "Cadena no cumple con el alfabeto";
        }
        String estadoActual = this.estadoInicial;

        // Detecta el numero de cintas que se van a utilizar
        int k = this.transiciones.values().toArray()[0].toString().split(":").length - 2;

        ArrayList<ArrayList<String>> cinta = new ArrayList<ArrayList<String>>();
        int cabezaLectura = 0;

        cinta.add(new ArrayList<String>(Arrays.asList(cadena.split("|"))));// Primera cinta contiene la cadena
        String transicion = estadoActual + ":" + cinta.get(0).get(0); // Primer caracter en la primera cinta

        for (int i = 1; i < k; i++) {
            cinta.add(new ArrayList<String>());
            for (int j = 0; j < cinta.get(0).size(); j++)
                cinta.get(i).add("!");
            transicion += ":" + cinta.get(i).get(0);
        }

        while (this.transiciones.get(transicion) != null) { // Sigue procesando mientras exista la transicion
            // el proceso es la Cinta hasta la cabezaLectura + * + el resto de la cinta

            for (int i = 0; i < cinta.get(0).size(); i++) {
                proceso += "(";
                if (i == cabezaLectura)
                    proceso += estadoActual + ")(";

                for (int j = 0; j < k; j++)
                    proceso += cinta.get(j).get(i) + (j == k - 1 ? ")" : ",");

                if (i == cabezaLectura)
                    for (int j = 0; j < k; j++)
                        cinta.get(j).set(i, this.transiciones.get(transicion).get(0).split(":")[j + 1]);

            }
            proceso += "->";
            cabezaLectura += (this.transiciones.get(transicion).get(0).split(":")[k + 1].equals(">") ? 1
                    : this.transiciones.get(transicion).get(0).split(":")[k + 1].equals("-") ? 0 : -1);

            estadoActual = this.transiciones.get(transicion).get(0).split(":")[0];

            transicion = estadoActual + ":";
            for (int i = 0; i < k; i++) {
                transicion += (cabezaLectura < 0 || cabezaLectura >= cinta.get(i).size() ? "!"
                        : cinta.get(i).get(cabezaLectura)) + (i == k - 1 ? "" : ":");
            }
        }

        // Al terminar de procesar la cadena
        proceso += "(" + estadoActual + ",";
        for (int i = 0; i < k; i++) {
            String procesoTmp = cinta.get(i).toString().replaceAll(", |\\[|\\]", "");
            proceso += (cabezaLectura < 0 ? "" : procesoTmp.substring(0, cabezaLectura))
                    + (cabezaLectura < 0 ? "*!" : "*")
                    + (cabezaLectura >= procesoTmp.length() ? "!"
                            : procesoTmp.substring(cabezaLectura < 0 ? 0 : cabezaLectura, procesoTmp.length()))
                    + (i == k - 1 ? ")>>" : ",");
        }

        // Mira si termino en un estado de aceptacion
        proceso += this.estadosAceptacion.contains(estadoActual) ? "accepted" : "rejected";

        return proceso;
    }

}
