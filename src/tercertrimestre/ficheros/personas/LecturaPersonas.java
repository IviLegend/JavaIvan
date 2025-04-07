package tercertrimestre.ficheros.personas;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Con la clase "Persona" que tenemos, vais a crear una lista de objetos de la clase Persona, con valores que os inventéis.
 * Vais a crear un fichero en una carpeta "exportaciones", con nombre "personas.csv", que contenga información de las personas.
 * Cada persona en una línea, con sus valores separados por comas.
 * Controlar las posibles excepciones y mostrar mensajes acordes.
 */
public class LecturaPersonas
{
    public static void main(String[] args)
    {
        List<Persona> listaPersonas = new ArrayList<>();

        Path rutaCarpetas = Paths.get("res/ficheros/personas/exportaciones");
        Path rutaArchivo = Paths.get("res/ficheros/personas/exportaciones/persona.csv");

        List<Persona> listaAAnadir = new ArrayList<>();
        Persona manolo = new Persona("Manolo", "Gutiérrez", 80, "IJKL");
        Persona alberto = new Persona("Alberto", "Corazón", 19, "MNOP");
        listaAAnadir.add(manolo);
        listaAAnadir.add(alberto);

        try
        {
            crearDirectorios(rutaCarpetas);

            if (!(Files.exists(rutaArchivo)))
            {
                Files.createFile(rutaArchivo);
            }

            // Añadir personas
            for (Persona persona : listaAAnadir)
            {
                String infoPersona = persona.toCsv();
                Files.writeString(rutaArchivo, infoPersona);
            }

            // Extraer personas
            List<String> lineas = Files.readAllLines(rutaArchivo);
            for (String linea : lineas)
            {
                String[] valores = linea.split(",");
                Persona persona = new Persona(valores[0], valores[1], Integer.parseInt(valores[2]), valores[3]);
                listaPersonas.add(persona);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        for (Persona persona : listaPersonas)
        {
            System.out.println(persona);
        }
    }

    public static void crearDirectorios(Path ruta) throws IOException
    {
        Files.createDirectories(ruta);
    }
}
