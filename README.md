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
        
        Busca el archivo y carga cada atributo a partir de la lectura por secciones las cuales estan representadas por un "#" -> ("#Seccion"). Para ver mas informacion ver en **Formato de archivo**

- **Metodos**

    Exigidos
    - `procesarCadena(cadena)` Retorna verdadero o falso dependiendo de el resultado del proceso, llamando al metodo **"procesarCadenaTexto(cadena)"**
    - `procesarCadenaConDetalles(cadena)` Hace lo mismo que el metodo **"procesarCadena"**, imprimiendo el procedimiento
    - `procesarListaCadena(listaCadenas, nombreArchivo, imprimirPantalla)` Procesa todas las cadenas en **"listaCadenas"** llamando ya sea al metodo **"procesarCadena"** o **"procesarCadenaConDetalles"** dependiendo del parametro **"imprimirPantalla"**, y las pone en un archivo usando el nombre **"nombreArchivo"**.
    - `toString()` Traduce el automata a una String con el formato de **Formato de archivo** para poder escribirse en un archivo

    Utiles
    - `procesarCadenaTexto(cadena)` Metodo abstracto para modificar en cada clase que extienda de **Automata** segun necesite el proceso
    - `ponerTrancisiones(transiciones)` Parte la transicion en 2 partes haciendo uso del carácter "~".

        Ej: Si se tiene la transicion `q0:a:A~q1:B;q3:A` de un AFPN

        - La primera es un string que queda así: `q0:a:A` donde en este caso indica que hay una trancision en `q0` al leer en la cadena una `a` y en la pila una `A`.

        - La segunda parte se vuelve a dividir haciendo uso del carácter ";" creando un **ArrayList** con cada parte creada en este caso quedaría [q1:B, q3:A] donde el primero representa que la transicion llega a `q1` y la `B` se usa en la pila, y el segundo representa que la transicion llega a `q3` y la `A` se usa en la pila
    - `createOutFile(nombreArchivo)` Haciendo uso del **nombreArchivo** crea un archivo vacio y lo retorna, este metodo se encarga de revisar si el archivo existe, en caso contrario crea un archivo con el nombre por defecto **default** y el numero correspondiente para evitar usar el mismo nombre
    - `toFile(nombreArchivo)` Llama a **createOutFile** y escribe en el archivo creado el contenido de **toString()**
    - `verificarAlfabetoSigma(cadena)` Como su nombre lo indica revisa si la cadena dada cumple con el alfabeto aceptado por el automata

# Formato de archivo

    