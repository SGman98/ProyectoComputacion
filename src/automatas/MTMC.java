package src.automatas;

import java.util.ArrayList;
import java.util.Arrays;

public class MTMC extends Automata {

    public MTMC(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetoCinta, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetoCinta;
        this.extension = ".mttm";
    }

    public MTMC(String nombreArchivo) {
        super(nombreArchivo.contains(".mttm") ? nombreArchivo : "default.mttm");
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
        int k = this.transiciones.values().toArray()[0].toString().split(":").length / 2;

        ArrayList<ArrayList<String>> cinta = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> cabezaLectura = new ArrayList<Integer>();

        cinta.add(new ArrayList<String>(Arrays.asList(cadena.split("|"))));// Primera cinta contiene la cadena
        cabezaLectura.add(0);
        String transicion = estadoActual + ":" + cinta.get(0).get(0); // Primer caracter en la primera cinta

        for (int i = 1; i < k; i++) {
            cinta.add(new ArrayList<String>());
            cabezaLectura.add(0);
            transicion += ":" + (cinta.get(i).isEmpty() ? "!" : cinta.get(i).get(0));
        }

        while (this.transiciones.get(transicion) != null) { // Sigue procesando mientras exista la transicion
            // el proceso es la Cinta hasta la cabezaLectura + * + el resto de la cinta
            proceso += "(" + estadoActual + ",";

            estadoActual = this.transiciones.get(transicion).get(0).split(":")[0];

            for (int i = 0; i < k; i++) {
                String procesoTmp = cinta.get(i).toString().replaceAll(", |\\[|\\]", "");

                if (!(cabezaLectura.get(i) < 0)) {
                    if (cabezaLectura.get(i) >= cinta.get(i).size())
                        cinta.get(i).add("!");
                    cinta.get(i).set(cabezaLectura.get(i),
                            this.transiciones.get(transicion).get(0).split(":")[i * 2 + 1]);
                    if (cinta.get(i).contains("!"))
                        cinta.get(i).remove(cinta.get(i).size() - 1);
                }

                proceso += (cabezaLectura.get(i) < 0 ? "" : procesoTmp.substring(0, cabezaLectura.get(i)))
                        + (cabezaLectura.get(i) < 0 ? "*!" : "*")
                        + (cabezaLectura.get(i) >= procesoTmp.length() ? "!"
                                : procesoTmp.substring(cabezaLectura.get(i) < 0 ? 0 : cabezaLectura.get(i),
                                        procesoTmp.length()))
                        + (i == k - 1 ? ")->" : ",");

                cabezaLectura.set(i,
                        cabezaLectura.get(i) + (transiciones.get(transicion).get(0).split(":")[i * 2 + 2].equals(">")
                                ? 1
                                : transiciones.get(transicion).get(0).split(":")[i * 2 + 2].equals("-") ? 0 : -1));
            }
            transicion = estadoActual + ":";
            for (int i = 0; i < k; i++) {
                transicion += (cabezaLectura.get(i) < 0 || cabezaLectura.get(i) >= cinta.get(i).size() ? "!"
                        : cinta.get(i).get(cabezaLectura.get(i))) + (i == k - 1 ? "" : ":");
            }
        }

        // Al terminar de procesar la cadena
        proceso += "(" + estadoActual + ",";
        for (int i = 0; i < k; i++) {
            String procesoTmp = cinta.get(i).toString().replaceAll(", |\\[|\\]", "");
             proceso += (cabezaLectura.get(i) < 0 ? "" : procesoTmp.substring(0, cabezaLectura.get(i)))
             + (cabezaLectura.get(i) < 0 ? "*!" : "*")
             + (cabezaLectura.get(i) >= procesoTmp.length() ? "!"
                     : procesoTmp.substring(cabezaLectura.get(i) < 0 ? 0 : cabezaLectura.get(i),
                             procesoTmp.length()))
             + (i == k - 1 ? ")>>" : ",");
        }

        // Mira si termino en un estado de aceptacion
        proceso += this.estadosAceptacion.contains(estadoActual) ? "accepted" : "rejected";

        return proceso;
    }

}
