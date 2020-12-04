/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.automatas;

import java.util.ArrayList;
import java.util.Stack;

public class AF2P extends Automata {


    public AF2P(ArrayList<String> estados, String estadoInicial, ArrayList<String> estadosAceptacion,
            ArrayList<String> alfabetoEntrada, ArrayList<String> alfabetopila, ArrayList<String> transiciones) {
        super(alfabetoEntrada, estados, estadoInicial, estadosAceptacion, transiciones);
        this.alfabetoPila = alfabetopila;
        this.extension =  ".msm";
    }

    public AF2P(String nombreArchivo) {
        super(nombreArchivo.contains(".msm") ? nombreArchivo : "default.msm");}

    

    public String procesar(String cadena,String estadoActual, String proceso, Stack pila1, Stack pila2){
        //recibe el string del proceso, el estado y las pilas
       // if (!cadena.isEmpty()){
        String aux = "";
            if (!verificarAlfabetoSigma(cadena)) {
                System.out.println("Cadena no cumple con el alfabeto");

            }           //verificó si la cadena está vacia y si pertenece al alfabeto
            else {

                ArrayList<String> opciones = encontrarOpciones(estadoActual,!cadena.isEmpty() ? String.valueOf(cadena.charAt(0)) : " ");
                while (!proceso.contains("accepted") && opciones.size()>0){
                    // tiene que buscar el primer objeto de la lista y seguir
                    modificarPila(pila1, opciones.get(0).split(":")[2],
                            this.transiciones.get(opciones.get(0)).get(0).split(":")[1]);
                    //encuentra y realiza las operaciones para la pila 1
                    modificarPila(pila1, opciones.get(0).split(":")[3],
                            this.transiciones.get(opciones.get(0)).get(0).split(":")[2]);
                    //realiza las operaciones para la pila 2

                    //recursividad
                    String procesoRec =procesar(cadena.substring(1),
                            this.transiciones.get(opciones.get(0)).get(0).split(":")[0],
                    proceso + "("+ estadoActual + "," + cadena + "," + pila1.peek() + ","
                    + pila2.peek() + ")->", pila1, pila2);

                    opciones.remove(0);
                    //debe eliminar el primer elemento de la lista para que luego no se repita

                }

            }
        if (this.estadosAceptacion.contains(estadoActual) && pila1.peek()=="$" && pila1.size()==1
                && pila2.peek()=="$" && pila2.size()==1) { // Mira si termino en un estado de aceptacion
            proceso += "(" + estadoActual + ",$)>>accepted";
            return "true";
        }
            proceso += "(" + estadoActual + ",$)>>rejected";
        return "false";
        
    }
    public void modificarPila(Stack pila, String operacion, String parametro){
            if (operacion.equals("$")) {
                if (!parametro.equals("$")) {
                    pila.push(parametro); // Añade
                }
            } else {
                if (!pila.peek().equals("$")) {
                    pila.pop(); // Elimina
                    if (!parametro.equals("$")) {
                        pila.push(parametro); // Remplaza
                    }
                }
            }


    }
    int computarTodosLosProcesamientos(String cadena, String nombreArchivo){
    return 0;

    }

    //además de las opciones de la cadena debe dar las de lambda
    ArrayList encontrarOpciones(String estadoActual, String cabezaCinta) {
        ArrayList<String> opciones = new ArrayList<>();
        for (String s : this.alfabetoPila){
            for (String c : this.alfabetoPila){
                if (this.transiciones.get(estadoActual + ":$:" + s + ":" + c) != null) {
                    opciones.add(estadoActual + ":$:" + s + ":" + c);
                }

                if (this.transiciones.get(estadoActual + ":" + cabezaCinta + ":" + s +":" + c) != null) {
                    opciones.add(estadoActual + ":"+ cabezaCinta +":" + s + ":" + c);
                }

            }
        }
        return opciones;
    
    }



    @Override
    String procesarCadenaTexto(String cadena) {
        Stack<String> pila1 = new Stack<>();
        pila1.push("$");
        Stack <String >pila2 = new Stack<>();
        pila2.push("$");
        
        return procesar(cadena, this.estadoInicial," ", pila1, pila2 );

    }
}
