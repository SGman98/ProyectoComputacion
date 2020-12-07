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
    public AF2P (String nombreArchivo) {
        super(nombreArchivo.contains(".msm") ? nombreArchivo : "default.msm");}



    public ArrayList procesar(String cadena, String estadoActual, ArrayList<String> opciones,
                              ArrayList<String> proceso, Stack stack1, Stack stack2){
        proceso.add("(" + estadoActual + "," + cadena + ","+ stack1.peek()+","+ stack2.peek()+")->");
        for(String s : opciones){
            if (this.transiciones.get(s) != null) {
                modificarPila(stack1, s.split(":")[2],
                        this.transiciones.get(s).get(0).split(":")[1]);
                //encuentra y realiza las operaciones para la pila 1
                modificarPila(stack2, s.split(":")[3],
                        this.transiciones.get(s).get(0).split(":")[2]);
                if (!cadena.substring(1).isEmpty()) {
                    procesar(cadena.substring(1), this.transiciones.get(s).get(0).split(":")[0],
                            encontrarOpciones(this.transiciones.get(s).get(0).split(":")[0], !cadena.isEmpty() ? String.valueOf(cadena.charAt(1)) : " "),
                            proceso, stack1, stack2);
                }

            }

        }
        if (this.estadosAceptacion.contains(estadoActual) && stack1.peek() == "$" && stack1.size() == 1
                && stack2.peek() == "$" && stack2.size() == 1&& cadena.substring(1).isEmpty()) {
            // Mira si termino en un estado de aceptacion
            proceso.add("(" + estadoActual + "," + stack1.peek()+ ","+ stack2.peek() +")>>");
            proceso.add("accepted");

        }
        else if(this.estadosAceptacion.contains(estadoActual) && stack1.peek() != "$"
                && stack2.peek() != "$"  && cadena.substring(1).isEmpty()){
            proceso.add("(" + estadoActual + "," + stack1.peek()+ ","+ stack2.peek() +")>>");
            proceso.add("rejected");
        }else if(!proceso.contains("accepted") & !proceso.contains("rejected") &&
                !cadena.substring(1).isEmpty()){
            proceso.add("aborted");
        }

        return proceso;
    }
    public String verCadenas(ArrayList<String> array){
        String str = "";
        for(String s: array){
            //System.out.print(s);
            str += s;
        }
        return str;

    }
    public void modificarPila(Stack pila, String operacion, String parametro){
        if (operacion.equals("$")) {
            if (!parametro.equals("$")) {
                for(int i = 0; i< parametro.length(); i++) {
                    pila.push(parametro.charAt(i));
                }// Añade

            }
        } else {
            if (!pila.peek().equals("$")) {
                pila.pop(); // Elimina
                if (!parametro.equals("$")) {
                    for(int i = 0; i< parametro.length(); i++) {
                        pila.push(parametro.charAt(i));
                    } // Remplaza
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
        ArrayList<String> af = new ArrayList<>();
        af.add(" ");
        Stack<String> pila1 = new Stack<>();
        Stack<String> pila2 = new Stack<>();
        pila1.add("$");
        pila2.add("$");
        String ad = verCadenas(procesar(cadena,this.estadoInicial,
                encontrarOpciones(this.estadoInicial,!cadena.isEmpty() ? String.valueOf(cadena.charAt(0)) : " " ),
                af, pila1, pila2));

        return ad;
    }
}
