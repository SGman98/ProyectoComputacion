package automatas;

import java.util.ArrayList;
import java.util.HashMap;

public class AFD extends Automata {
    public AFD (ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion, HashMap<String,ArrayList<String>> transiciones) {
        super(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones);

    }
    public AFD (String nombreArchivo) {
        super(nombreArchivo);
    }

    public boolean procesarCadena(String cadena) {
        String estadoActual = this.estadoInicial;
        String[] cadenaLectura = cadena.split("|"); // Separamos la cadena en caracteres individuales

        for (int i = 0; i < cadenaLectura.length; i++) {
            String transicion = estadoActual+":"+ cadenaLectura[i]; // Crea llave de busqueda en transiciones de forma "q0:a"

            if(this.transiciones.get(transicion) != null) { // Mira si existe el estadoActual ( = mira si existe la transicion)
                estadoActual = this.transiciones.get(transicion).get(0);
                cadena = cadena.substring(1);
            } else // Cadena Abortada cuando no existe la transicion
                return false;
        }

        // Termina de procesar la cadena
        return this.estadosAceptacion.contains(estadoActual); // Retorna si termino en un estado de aceptacion
    }

    public boolean procesarCadenaConDetalles(String cadena){
        String estadoActual = this.estadoInicial;
        String[] cadenaLectura = cadena.split("|"); // Separamos la cadena en caracteres individuales

        for (int i = 0; i < cadenaLectura.length; i++) {      
            String transicion = estadoActual+":"+ cadenaLectura[i]; // Crea llave de busqueda en transiciones de forma "q0:a"

            if(this.transiciones.get(transicion) != null) { // Busca si existe la transicion
                System.out.print("("+estadoActual+","+cadena+")->");
                estadoActual = this.transiciones.get(transicion).get(0);
                cadena = cadena.substring(1);
            } else { // Cadena Abortada cuando no existe la transicion
                System.out.println("("+estadoActual+","+cadena+")>>rejected"); 
                return false;
            }
        }

        // Termina de procesar la cadena
        if (this.estadosAceptacion.contains(estadoActual)) { // Mira si termino en un estado de aceptacion
            System.out.println("("+estadoActual+",$)>>accepted");
            return true;
        }
        System.out.println("("+estadoActual+",$)>>rejected"); 
        return false;
    }

    public boolean procesarListaCadena(String listaCadenas, String nombreArchivo, boolean imprimirPantalla){
        return true;
    }

}
