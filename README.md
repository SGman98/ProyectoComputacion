# Automata
Clase general con la mayoria de los Atributos y Metodos necesarios

- **Atributos**
    - **`ArrayList<String>`** `alfabeto` Lenguaje de Cinta Sigma
    - **`ArrayList<String>`** `estados` Listado de todos los estados dentro del automata
    - **`String`** `estadoInicial` Guarda el estado inicial como un String
    - **`ArrayList<String>`** `estadosAceptacion` Listado de todos los estados dentro del automata
    - **`HashMap<String, ArrayList<String>>`** `transiciones` Las transiciones quedan como 2 partes la primera se usa como llave para verificar la existencia de la transicion, la segunda parte indica lo que sucede en el proceso dependiendo del tipo de automata.
    - **`String`** `extension` Se usa para guardar el tipo de extension que usa los archivos leidos por el automata

- **Constructores**
    - **`constructor`** `(alfabeto, estados, estadoInicial, estadosAceptacion, transiciones)` inicializa los atributos
    - **`constructor`** `(nombreArchivo)` Carga la informacion del automata a partir de un archivo
        
        Busca el archivo y carga cada atributo a partir de la lectura por secciones las cuales estan representadas por un "#" -> ("#Seccion"). Para ver mas informacion ver en [**Formato de archivo**](#formato-de-archivo)

- **Metodos**

    Exigidos
    - `procesarCadena(cadena)` Retorna verdadero o falso dependiendo de el resultado del proceso, llamando al metodo **"procesarCadenaTexto(cadena)"**
    - `procesarCadenaConDetalles(cadena)` Hace lo mismo que el metodo **"procesarCadena"**, imprimiendo el procedimiento
    - `procesarListaCadena(listaCadenas, nombreArchivo, imprimirPantalla)` Procesa todas las cadenas en **"listaCadenas"** llamando ya sea al metodo **"procesarCadena"** o **"procesarCadenaConDetalles"** dependiendo del parametro **"imprimirPantalla"**, y las pone en un archivo usando el nombre **"nombreArchivo"**.
    - `toString()` Traduce el automata a una String con el formato de [**Formato de archivo**](#formato-de-archivo) para poder escribirse en un archivo

    Utiles
    - `procesarCadenaTexto(cadena)` Metodo abstracto para modificar en cada clase que extienda de **Automata** segun necesite el proceso
    - `ponerTrancisiones(transiciones)` Parte la transicion en 2 partes haciendo uso del carácter "~".

        Ej: Si se tiene la transicion `q0:a:A~q1:B;q3:A` de un AFPN

        - La primera es un string que queda así: `q0:a:A` donde en este caso indica que hay una trancision en `q0` al leer en la cadena una `a` y en la pila una `A`.

        - La segunda parte se vuelve a dividir haciendo uso del carácter ";" creando un **ArrayList** con cada parte creada en este caso quedaría [q1:B, q3:A] donde el primero representa que la transicion llega a `q1` y la `B` se usa en la pila, y el segundo representa que la transicion llega a `q3` y la `A` se usa en la pila
    - `createOutFile(nombreArchivo)` Haciendo uso del **nombreArchivo** crea un archivo vacio y lo retorna, este metodo se encarga de revisar si el archivo existe, en caso contrario crea un archivo con el nombre por defecto **default** y el numero correspondiente para evitar usar el mismo nombre
    - `toFile(nombreArchivo)` Llama a **createOutFile** y escribe en el archivo creado el contenido de **toString()**
    - `verificarAlfabetoSigma/Gamma(cadena)` Como su nombre lo indica revisa si la cinta/pila/cadena dada cumple con el alfabeto aceptado por el automata

# Formato de archivo

- **Extension**

    Dependiendo del tipo de automata toca poner la extension en la primera linea del archivo haciendo uso del punto. Ej:

        .dfa
- **Secciones**
    
    Las secciones se marcan usando el simbolo numeral "#" antes del nombre. Las siguientes son las secciones aceptadas y su forma de uso. Si estan con un "/" es que se puede usar o uno o el otro

```markdown

<!-- Alfabeto Sigma -->
#alphabet / #inputAlphabet
A-F
a-z
ñ
Ñ
...
0-9

<!-- Alfabeto Gamma -->
#tapeAlphabet / #stackAlphabet
A-F
a-z
ñ
Ñ
...
0-9

<!-- Todos los estados del automata -->
#states
q0
q1
q2
...
qn
otro_estado
state_name

<!-- Se indica el estado inicial -->
#initial
state_i
```

Dependiendo del tipo de automata toca hacer uso de uno de los siguientes formatos para lar transiciones

``` markdown
<!-- Autómata Finito Determinista (AFD) -->
#transitions
q0:a~q1
q1:b~q2
...
qn:c~qk
<!-- Autómata Finito con Pila Determinista (AFPD) -->
#transitions
q0:a:A~q1:$
q1:$:B~q2:A
<!-- Autómata Finito con Pila No Determinista (AFPN) -->
#transitions
q0:a:A~q1:$q2:D;q3:$
q1:$:B~q2:A;q5:$
<!-- Autómata Finito con 2 Pilas (AF2P) -->
#transitions
q0:a:A:B~q1:$:C;q2:D:B;q3:$:$
q1:$:B:$~q2:A:B;q5:$:S
<!-- Máquina de Turing – Modelo Estándar (MT) -->
#transitions
q0:!~q1:A:>
q1:a~q2:!:<
<!-- Máquina de Turing Modelo con una Cinta dividida en Pistas (MTP) -->
#transitions
q0:!:A~q1:A:!:<
q1:a:b~q2:!:!:-
<!-- Máquina de Turing Modelo con Múltiples Cintas (MTMC) -->
#transitions
q0:!:A~q1:A;>:!;<
q1:a:b~q2:!;<:!;-
```
