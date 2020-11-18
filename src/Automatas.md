# Automatas

## Comprender Atributos

- ```java
    ArrayList<String> alfabeto; // Lenguaje de Cinta Sigma
    ArrayList<String> estados;
    String estadoInicial;
    ArrayList<String> estadosAceptacion;
    HashMap<String, ArrayList<String>> transiciones; 
        //  Automata determinista           q0:a>q1             q0:a    [q1]
        //  Automata no determinista        q0:a>q1;q2          q0:a    [q1,q2]
        //  Automata determinista pila      q0:a:A>q1:$         q0:a:A  [q1:$]
        //  Automata no determinista pila   q0:a:A>q1:B;q2:$    q0:a:A  [q1:B,q2:$]
    ```

## Crear nuevos modelos

- ### Constructores
    - Crear nueva clase que extienda a ```Automata``` con 2 constructores
        ```java
        Constructor(alfabeto, estados, estadoInicial, estadosAceptacion,delta) {
            super(alfabeto, estados, estadoInicial, estadosAceptacion,delta)
        }
        Constructor(nombreArchivo) {
            // Poner la extension respectiva
            super(nombreArchivo.contains(".dfa")? nombreArchivo: "default.dfa");
        }
        ```

    - Los metodos base necesarios son:
        -   ```java
            public String procesarCadenaTexto(String cadena) {
                String proceso = "";
                if (!verificarAlfabeto(cadena)) {
                    System.out.println("Cadena no cumple con el alfabeto");
                    return "No cumple con el alfabeto";
                }
                // Implementar codigo acá y registrar el proceso en el string "proceso"
                return proceso;
            }
            ```

            El String que retorna ```procesarCadenaTexto(String cadena)``` tiene que ser de la siguiente forma:

            (q0,aabab)->(q0,abab)->(q0,bab)->(q1,ab)->(q1,b)->(q2,$)>>accepted

        -   ```java
            public void toFile(String nombreArchivo) {
                // Poner la extension respectiva
                super.toFile(nombreArchivo.contains(".dfa")? nombreArchivo: "default.dfa");
            }
            ```