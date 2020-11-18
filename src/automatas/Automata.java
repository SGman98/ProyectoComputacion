package automatas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

// Clase abstracta con la mayoria de los atributos y metodos necesarios para todas las clases

public abstract class Automata {
    ArrayList<String> alfabeto; // Lenguaje de Cinta Sigma (Para automatas con pila)
    ArrayList<String> estados;
    String estadoInicial;
    ArrayList<String> estadosAceptacion;
    HashMap<String, ArrayList<String>> transiciones; // transicion q0:a>q1 --> <q0:a, q1>

    public Automata(ArrayList<String> alfabeto, ArrayList<String> estados, String estadoInicial,
            ArrayList<String> estadosAceptacion, HashMap<String, ArrayList<String>> transiciones) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosAceptacion = estadosAceptacion;
        this.transiciones = transiciones;
    }

    public Automata(String nombreArchivo) {
        // Idea: El archivo esta dividido en secciones Leer el inicio de la seccion y
        // comenzar un bucle de lectura hasta que encuentre otra seccion
        this.alfabeto = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.estadosAceptacion = new ArrayList<>();
        this.transiciones = new HashMap<>();
        try {
            // Al usar los test en visual studio se crea una carpeta bin,
            // por lo que esto es para diferenciar los test
            boolean inTest = Files.exists(Paths.get("bin"), LinkOption.NOFOLLOW_LINKS);
            int index = nombreArchivo.lastIndexOf('.');
            String extension = (index > 0) ? nombreArchivo.substring(index + 1) : "";
            if (!Files.exists(Paths.get((inTest ? "bin\\" : "") + "resources\\" + nombreArchivo),
                    LinkOption.NOFOLLOW_LINKS)) {
                System.out.println("El archivo " + nombreArchivo + " no existe. Cargando archivo por defecto: default."
                        + extension);
                nombreArchivo = (inTest ? "bin\\" : "") + "resources\\default." + extension;
            } else {
                nombreArchivo = (inTest ? "bin\\" : "") + "resources\\" + nombreArchivo;
            }
            File myFile = new File(nombreArchivo);
            Scanner myReader = new Scanner(myFile);
            String seccion = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("#") || data.equals(""))
                    seccion = data;
                else {
                    switch (seccion) {
                        case "#alphabet":
                            this.alfabeto.add(data);
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
                            String transicion = data.split(">")[0];
                            String transicionFinal = data.split(">")[1];
                            this.transiciones.put(transicion, new ArrayList<>(Arrays.asList(transicionFinal)));
                            break;
                        default:
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
        String string = "";
        if (!this.alfabeto.isEmpty()) {
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
        if (!this.transiciones.isEmpty()) {
            string += "#transitions\n";
            for (Iterator<Map.Entry<String, ArrayList<String>>> it = this.transiciones.entrySet().iterator(); it
                    .hasNext();) {
                Map.Entry<String, ArrayList<String>> pair = it.next();
                string += pair.getKey() + ">" + pair.getValue().get(0) + "\n";
            }
            // string += "\n";
        }

        return string;
    }

    // Metodos Utiles no propuestos

    abstract String procesarCadenaTexto(String cadena); // Procesa la cadena y devuelve el texto

    public void toFile(String nombreArchivo) {
        try {
            FileWriter myWriter = new FileWriter(createOutFile(nombreArchivo));
            myWriter.write(this.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Deberia si o si crear un archivo
    File createOutFile(String nombreArchivo) throws IOException {
        // Intenta crear el archivo y revisa si el metodo fue llamado desde un JUnit
        // Test
        boolean inTest = Files.exists(Paths.get("bin"), LinkOption.NOFOLLOW_LINKS);
        File myFile = new File((inTest ? "bin\\" : "") + "resources\\" + nombreArchivo);
        int index = nombreArchivo.lastIndexOf('.');
        String extension = (index > 0) ? nombreArchivo.substring(index + 1) : "";

        if (myFile.createNewFile()) {
            System.out.println("Archivo Creado: " + myFile.getName());
        } else {
            // Si no existe crea un archivo con un nobre por defecto
            System.out.println("El archivo " + myFile.getName() + " ya existe. Creando archivo por defecto");
            myFile = new File((inTest ? "bin\\" : "") + "resources\\default." + extension);
            int filenum = 0;

            if (myFile.exists() && !myFile.isDirectory()) {
                while (myFile.exists()) {
                    filenum++;
                    myFile = new File((inTest ? "bin\\" : "") + "resources\\default " + filenum + "." + extension);
                }
            }
            myFile.createNewFile();
            System.out.println("Archivo Creado: " + myFile.getName());
        }
        return myFile;
    }

    boolean verificarAlfabeto(String cadena) { // Verifica Alfabeto Sigma
        String regex = "[";
        for (String string : alfabeto)
            regex = regex + string;
        regex = regex + "]*";
        // String regex = this.alfabeto.toString().replaceAll(", ", "") + "*"; //
        // Verifica si la cadena entregada esta
        // conformada unicamente por caracteres en
        // el alfabeto
        return cadena.matches(regex);
    }

}