package src.automatas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Clase abstracta con la mayoria de los atributos y metodos necesarios para todas las clases
public abstract class Automata {

    ArrayList<String> alfabeto; // Lenguaje de Cinta Sigma
    ArrayList<String> alfabetoPila; // Lenguaje de Pila Gamma
    ArrayList<String> estados;
    String estadoInicial;
    ArrayList<String> estadosAceptacion;
    HashMap<String, ArrayList<String>> transiciones; // transicion q0:a>q1 --> <q0:a, q1>

    String extension;

    public Automata(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, ArrayList<String> transiciones) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosAceptacion = estadosAceptacion;
        this.transiciones = new HashMap<String, ArrayList<String>>();
        for (String string : transiciones) {
            this.ponerTrancisiones(string);
        }
    }

    public Automata(String nombreArchivo) {
        // Idea: El archivo esta dividido en secciones Leer el inicio de la seccion y
        // comenzar un bucle de lectura hasta que encuentre otra seccion
        this.alfabeto = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.estadosAceptacion = new ArrayList<>();
        this.transiciones = new HashMap<>();

        int index = nombreArchivo.lastIndexOf('.');
        this.extension = "." + ((index > 0) ? nombreArchivo.substring(index + 1) : "");
        try {
            // Al usar los test en visual studio se crea una carpeta bin,
            // por lo que esto es para diferenciar los test
            boolean inTest = Files.exists(Paths.get("bin"), LinkOption.NOFOLLOW_LINKS);

            if (!Files.exists(Paths.get((inTest ? "bin\\" : "") + "resources\\" + nombreArchivo),
                    LinkOption.NOFOLLOW_LINKS)) {
                System.out.println("El archivo " + nombreArchivo + " no existe. Cargando archivo por defecto: default"
                        + this.extension);
                nombreArchivo = (inTest ? "bin\\" : "") + "resources\\default" + this.extension;
            } else {
                nombreArchivo = (inTest ? "bin\\" : "") + "resources\\" + nombreArchivo;
            }
            File myFile = new File(nombreArchivo);
            Scanner myReader = new Scanner(myFile);
            String seccion = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("#") || data.equals("")) {
                    seccion = data;
                    if (seccion.equals("#tapeAlphabet")) {
                        this.alfabetoPila = new ArrayList<>();
                    }
                } else {
                    switch (seccion) {
                        case "#alphabet":
                        case "#inputAlphabet":
                            this.alfabeto.add(data);
                            break;
                        case "#tapeAlphabet":
                            this.alfabetoPila.add(data);
                            break;
                        case "#states":
                            this.estados.add(data);
                            break;
                        case "#initial":
                            this.estadoInicial = data;
                            break;
                        case "#accepting":
                            this.estadosAceptacion.add(data);
                            break;
                        case "#transitions":
                            this.ponerTrancisiones(data);
                            break;
                        default:
                            if (!this.extension.equals(data)) {
                                System.out.println("La extension " + data + " no corresponde");
                            }
                            break;
                    }
                }
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public Automata(String nombreArchivo, boolean b) {
        // Idea: El archivo esta dividido en secciones Leer el inicio de la seccion y
        // comenzar un bucle de lectura hasta que encuentre otra seccion
        this.alfabeto = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.estadosAceptacion = new ArrayList<>();
        this.transiciones = new HashMap<>();

        int index = nombreArchivo.lastIndexOf('.');
        this.extension = "." + ((index > 0) ? nombreArchivo.substring(index + 1) : "");
        try {
            File myFile = new File(nombreArchivo);
            Scanner myReader = new Scanner(myFile);
            String seccion = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("#") || data.equals("")) {
                    seccion = data;
                    if (seccion.equals("#tapeAlphabet")) {
                        this.alfabetoPila = new ArrayList<>();
                    }
                } else {
                    switch (seccion) {
                        case "#alphabet":
                        case "#inputAlphabet":
                            this.alfabeto.add(data);
                            break;
                        case "#tapeAlphabet":
                            this.alfabetoPila.add(data);
                            break;
                        case "#states":
                            this.estados.add(data);
                            break;
                        case "#initial":
                            this.estadoInicial = data;
                            break;
                        case "#accepting":
                            this.estadosAceptacion.add(data);
                            break;
                        case "#transitions":
                            this.ponerTrancisiones(data);
                            break;
                        default:
                            if (!this.extension.equals(data)) {
                                System.out.println("La extension " + data + " no corresponde");
                            }
                            break;
                    }
                }
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean procesarCadena(String cadena) { // Apartir de la cadenaprocesada detecta la aceptacion
        return this.procesarCadenaTexto(cadena).contains("accepted");
    }

    public boolean procesarCadenaConDetalles(String cadena) { // Apartir de la cadenaprocesada detecta la aceptacion
        String resultado = this.procesarCadenaTexto(cadena);
        System.out.println(resultado); // Muestra el resultado en pantalla
        return resultado.contains("accepted");
    }

    public void procesarListaCadena(ArrayList<String> listaCadenas, String nombreArchivo, boolean imprimirPantalla) {
        try {

            // boolean inTest = Files.exists(Paths.get("bin"), LinkOption.NOFOLLOW_LINKS);
            FileWriter myWriter = new FileWriter(
                    this.createOutFile(nombreArchivo.contains(".") ? nombreArchivo : nombreArchivo + ".txt"));
            for (String string : listaCadenas) {
                // Escribe el archivo con el formato dado
                myWriter.write(string + "\t" + this.procesarCadenaTexto(string) + "\t"
                        + (imprimirPantalla ? this.procesarCadenaConDetalles(string) ? "yes" : "no"
                                : this.procesarCadena(string) ? "yes" : "no")
                        + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public String toString() { // Crea Un string con la forma de entrada del PDF
        String string = this.extension + "\n";
        if (!this.alfabeto.isEmpty() && this.alfabetoPila == null) {
            string += "#alphabet\n";
            for (String s : this.alfabeto) {
                string += s + "\n";
            }
            string += "\n";
        }
        if (!this.estados.isEmpty()) {
            string += "#states\n";
            for (String s : this.estados) {
                string += s + "\n";
            }
            string += "\n";
        }
        if (!this.estadoInicial.equals("")) {
            string += "#initial\n";
            string += this.estadoInicial + "\n\n";
        }
        if (!this.estadosAceptacion.isEmpty()) {
            string += "#accepting\n";
            for (String s : this.estadosAceptacion) {
                string += s + "\n";
            }
            string += "\n";
        }
        if (!this.alfabeto.isEmpty() && this.alfabetoPila != null) {
            string += "#inputAlphabet\n";
            for (String s : this.alfabeto) {
                string += s + "\n";
            }
            string += "\n";
        }
        if (this.alfabetoPila != null && !this.alfabetoPila.isEmpty()) {
            string += "#tapeAlphabet\n";
            for (String s : this.alfabetoPila) {
                string += s + "\n";
            }
            string += "\n";
        }
        if (!this.transiciones.isEmpty()) {
            string += "#transitions\n";
            // Pasa el hashmap a una string la cual es de la siguiente forma
            // {key1=[value1-1, value1-2], key2=[value2-1]}
            // Al fomato del pdf key1~value1-1;value1-2 /n key2~value2-1
            string += this.transiciones.toString().replaceAll("\\], ", "\n").replaceAll("=\\[", "~")
                    .replaceAll(", ", ";").replaceAll("\\{", "").replaceAll("\\]\\}", "");
        }

        return string;
    }

    // Metodos Utiles no propuestos
    abstract String procesarCadenaTexto(String cadena); // Procesa la cadena y devuelve el texto

    public String mostrarProceso(String texto) {
        return procesarCadenaTexto(texto);
    }

    void ponerTrancisiones(String transiciones) { // Añadir las trancisiones
        String[] transicion;
        ArrayList<String> transicionFinal = new ArrayList<String>();

        transicion = transiciones.split("\\~");
        for (String string : transicion[1].split(";")) {
            transicionFinal.add(string);
        }
        if (transicion[1].split(";").length == 0) {
            transicionFinal.add(transicion[1]);
        }
        this.transiciones.put(transicion[0], new ArrayList<String>(transicionFinal));
        transicionFinal.clear();
    }

    File createOutFile(String nombreArchivo) throws IOException {
        // Intenta crear el archivo y revisa si el metodo fue llamado desde JUnit Test
        boolean inTest = Files.exists(Paths.get("bin"), LinkOption.NOFOLLOW_LINKS);
        File myFile = new File((inTest ? "bin\\" : "") + "resources\\" + nombreArchivo);

        if (myFile.createNewFile()) {
            System.out.println("Archivo Creado: " + myFile.getName());
        } else {
            // Si no existe crea un archivo con un nobre por defecto
            System.out.println("El archivo " + myFile.getName() + " ya existe. Creando archivo por defecto");
            myFile = new File((inTest ? "bin\\" : "") + "resources\\default" + this.extension);
            int filenum = 0;

            if (myFile.exists() && !myFile.isDirectory()) {
                while (myFile.exists()) {
                    filenum++;
                    myFile = new File((inTest ? "bin\\" : "") + "resources\\default " + filenum + this.extension);
                }
            }
            myFile.createNewFile();
            System.out.println("Archivo Creado: " + myFile.getName());
        }
        return myFile;
    }

    public void toFile(String nombreArchivo) {
        nombreArchivo = nombreArchivo.contains(this.extension) ? nombreArchivo : "default" + this.extension;
        try {
            FileWriter myWriter = new FileWriter(createOutFile(nombreArchivo));
            myWriter.write(this.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    boolean verificarAlfabetoSigma(String cadena) { // Verifica Alfabeto Sigma
        cadena = cadena.replaceAll("!", ""); // ignora los caracteres en blanco
        String regex = "[";
        for (String string : this.alfabeto) {
            regex = regex + string;
        }
        regex = regex + "]*";
        return cadena.matches(regex);
    }

    boolean verificarAlfabetoGamma(String cadena) { // Verifica Alfabeto Sigma
        cadena = cadena.replaceAll("!", ""); // ignora los caracteres en blanco
        String regex = "[";
        for (String string : this.alfabetoPila) {
            regex = regex + string;
        }
        regex = regex + "]*";
        return cadena.matches(regex);
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public ArrayList<String> getAlfabetoPila() {
        return alfabetoPila;
    }

    public ArrayList<String> getEstados() {
        return estados;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public ArrayList<String> getEstadosAceptacion() {
        return estadosAceptacion;
    }

    public HashMap<String, ArrayList<String>> getTransiciones() {
        return transiciones;
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setAlfabetoPila(ArrayList<String> alfabetoPila) {
        this.alfabetoPila = alfabetoPila;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void setEstadosAceptacion(ArrayList<String> estadosAceptacion) {
        this.estadosAceptacion = estadosAceptacion;
    }

    public void setTransiciones(HashMap<String, ArrayList<String>> transiciones) {
        this.transiciones = transiciones;
    }

}
