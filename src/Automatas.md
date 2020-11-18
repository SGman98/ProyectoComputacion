# Automatas

## Crear nuevos modelos
Crear nueva clase que extienda a ```Automata```
Tiene 2 constructores donde ambos tienen que llamar su relativo ```super```

El unico metodo a modificar es 
```java
public String procesarCadenaTexto(String cadena) {
    String proceso = "";
    if (!verificarAlfabeto(cadena)) {
        System.out.println("Cadena no cumple con el alfabeto");
        return "No cumple con el alfabeto";
    }
    // Implementar codigo acá
}
```
Donde recomiendo comenzar como el codigo anterior y tiene que retornar un string como lo dice el pdf

ejemplo:

(q0,aabab)->(q0,abab)->(q0,bab)->(q1,ab)->(q1,b)->(q2,$)>>accepted