package src.automatas;

import java.util.ArrayList;
import java.util.Stack;

public class AFPN extends Automata {

    public AFPN(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetopila, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetopila;
        this.extension = ".pda";
    }

    public AFPN(String nombreArchivo) {
        super(nombreArchivo.contains(".pda") ? nombreArchivo : "default.pda");
    }

    public AFPN(String nombreArchivo, Boolean b) {
        super(nombreArchivo.contains(".pda") ? nombreArchivo : "default.pda", b);
    }

    public String procesarPaso(String cadena, String estadoActual, String proceso, Stack<String> pila, int i) {

        String transicion = estadoActual + ":" + encontrarTransicion(i, cadena, pila);

        // System.out.println(i + "-----" + proceso + transicion);
        if (!cadena.isEmpty()) {
            if (this.transiciones.get(transicion) != null) {

                int prueba = 0;

                while (!proceso.contains("accepted") && prueba < this.transiciones.get(transicion).size()) {

                    String procesoPrueba = "";

                    for (int j = 0; j < 4; j++) {
                        // System.out.println("*" + j);
                        procesoPrueba = procesarPaso(cadena.substring(1),
                                this.transiciones.get(transicion).get(prueba).split(":")[0],
                                proceso + "(" + estadoActual + "," + cadena + ","
                                + (pila.isEmpty() ? "$" : pila.toString().replaceAll(", |\\[|\\]", "")) + ")->",
                                modificarPila(pila, transicion.split(":")[2],
                                        this.transiciones.get(transicion).get(prueba).split(":")[1]),
                                j);

                        if (procesoPrueba.contains("rejected") || procesoPrueba.contains("accepted")) {
                            break;
                        }

                    }
                    prueba++; // Aumenta el numero para la siguiente prueba
                    proceso = (procesoPrueba.contains("rejected") || !procesoPrueba.contains("accepted"))
                            && prueba < this.transiciones.get(transicion).size() ? proceso : procesoPrueba;
                }

            }
            return proceso;
        }

        if (this.estadosAceptacion.contains(estadoActual) && pila.isEmpty()) { // Mira si termino en un estado de
            // aceptacion
            proceso += "(" + estadoActual + ",$,$)>>accepted";
            return proceso;
        }
        proceso += "(" + estadoActual + ",$," + pila.toString().replaceAll(", |\\[|\\]", "") + ")>>rejected";
        return proceso;
    }

    Stack<String> modificarPila(Stack<String> pila, String topePila, String resultadoTransicion) {
        Stack<String> pilaProceso = new Stack<>();
        for (String string : pila) {
            pilaProceso.add(string);
        }
        if (topePila.equals("$")) {
            if (!resultadoTransicion.equals("$")) {
                pilaProceso.push(resultadoTransicion); // Añade
            }
        } else {
            pilaProceso.pop(); // Elimina
            if (!resultadoTransicion.equals("$")) {
                pilaProceso.push(resultadoTransicion); // Remplaza
            }
        }
        return pilaProceso;
    }

    String encontrarTransicion(int prueba, String cadena, Stack<String> pila) {
        switch (prueba) {
            case 0:
                return "$:" + (pila.isEmpty() ? "$" : pila.peek()); // Añadir
            case 1:
                return cadena.charAt(0) + ":" + (pila.isEmpty() ? "$" : pila.peek()); // reemplazar o no hacer nada
            case 2:
                return "$:$"; // neutro
            case 3:
                return cadena.charAt(0) + ":$"; // Eliminar
            default:
                return "";
        }
    }

    @Override
    String procesarCadenaTexto(String cadena) {

        if (!verificarAlfabetoSigma(cadena)) {
            return "Cadena no cumple con el alfabeto";
        }

        String proceso = "";
        for (int i = 0; i < 4; i++) {
            proceso = procesarPaso(cadena, this.estadoInicial, "", new Stack<>(), i);
            // if (proceso.contains("rejected") || proceso.contains("accepted"))
            // break;
        }
        return proceso;
    }

}
