package src.automatas;

import java.util.ArrayList;
import java.util.Arrays;

public class MTN extends Automata {

    public MTN(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetoCinta, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetoCinta;
        this.extension = ".ntm";
    }

    public MTN(String nombreArchivo) {
        super(nombreArchivo.contains(".ntm") ? nombreArchivo : "default.ntm");
    }

    public MTN(String nombreArchivo, Boolean b) {
        super(nombreArchivo.contains(".ntm") ? nombreArchivo : "default.ntm", b);
    }

    String procesarPaso(ArrayList<String> cinta, String estadoActual, String proceso, int pos) {
        // System.out.println(cinta+"---"+estadoActual+"---"+pos+"---");
        if (pos >= 10) // Profundidad de busqueda es 10 caracteres si se excede no la acepta
        {
            return proceso + cinta.toString().replaceAll(", |\\[|\\]", "").substring(0, pos < 0 ? 0 : pos) + "(" + estadoActual
                    + ")" + cinta.toString().replaceAll(", |\\[|\\]", "").substring(pos < 0 ? 0 : pos, cinta.size()) + ">>rejected/Aborted";
        };

        String transicion = estadoActual + ":" + (pos < 0 || pos >= cinta.size() ? "!" : cinta.get(pos));

        if (this.transiciones.get(transicion) != null) { // Sigue procesando mientras exista la transicion

            int prueba = 0;
            // Hacer una prueba mientras la cadena no este aceptada la cadena tenga mas
            // pruebas
            while (!proceso.contains("accepted") && prueba < this.transiciones.get(transicion).size()) {

                ArrayList<String> cintaTmp = new ArrayList<>();
                for (String string : cinta) {
                    cintaTmp.add(string);
                }

                if (pos == cintaTmp.size() && !this.transiciones.get(transicion).get(prueba).split(":")[1].equals("!")) {
                    cintaTmp.add(this.transiciones.get(transicion).get(prueba).split(":")[1]);
                } else if (!transicion.split(":")[1]
                        .equals(this.transiciones.get(transicion).get(prueba).split(":")[1])) {
                    cintaTmp.set(pos, this.transiciones.get(transicion).get(prueba).split(":")[1]);
                }

                String procesoPrueba = procesarPaso(cintaTmp,
                        this.transiciones.get(transicion).get(prueba).split(":")[0],
                        proceso + cintaTmp.toString().replaceAll(", |\\[|\\]", "").substring(0, pos < 0 ? 0 : pos) + "("
                        + estadoActual + ")"
                        + cintaTmp.toString().replaceAll(", |\\[|\\]", "").substring(pos < 0 ? 0 : pos,
                                cintaTmp.size())
                        + "->",
                        pos + (this.transiciones.get(transicion).get(prueba).split(":")[2].equals(">") ? 1
                        : this.transiciones.get(transicion).get(prueba).split(":")[2].equals("<") ? -1 : 0));

                prueba++; // Aumenta el numero para la siguiente prueba
                proceso = procesoPrueba.contains("rejected") && prueba < this.transiciones.get(transicion).size()
                        ? proceso
                        : procesoPrueba;

                transicion = estadoActual + ":" + (pos < 0 || pos >= cinta.size() ? "!" : cinta.get(pos));
            }
            return proceso;

        }
        // System.out.println(profundidad+"==="+ transicion+"==="+proceso);

        // Al terminar de procesar la cadena
        proceso += cinta.toString().replaceAll(", |\\[|\\]", "").substring(0, pos < 0 ? 0 : pos) + "(" + estadoActual
                + ")" + cinta.toString().replaceAll(", |\\[|\\]", "").substring(pos < 0 ? 0 : pos, cinta.size()) + ">>";

        // Mira si termino en un estado de aceptacion
        return proceso + (this.estadosAceptacion.contains(estadoActual) ? "accepted" : "rejected");
    }

    @Override
    String procesarCadenaTexto(String cadena) {
        cadena = cadena.equals("") ? "!" : cadena; // Para evitar carácteres adicionales en la impresion
        ArrayList<String> cinta = new ArrayList<String>(Arrays.asList(cadena.split("|")));

        if (!verificarAlfabetoSigma(cadena)) {
            return "Cadena no cumple con el alfabeto";
        }

        return this.procesarPaso(cinta, this.estadoInicial, "", 0);
    }

}
