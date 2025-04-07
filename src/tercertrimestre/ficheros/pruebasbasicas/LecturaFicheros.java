package tercertrimestre.ficheros.pruebasbasicas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LecturaFicheros
{
    public static void main(String[] args)
    {
        String nombreFichero = "estadisticas.txt";

        Path rutaFichero = Paths.get(nombreFichero);

        try
        {
            List<String> lineas = Files.readAllLines(rutaFichero);
            if (!lineas.isEmpty())
            {
                for (String linea : lineas)
                {
                    System.out.println(linea);
                }
            }
            else
            {
                System.out.println("El fichero no tiene líneas.");
            }
        }
        catch (NoSuchFileException e)
        {
            System.err.println("Error: el fichero " + e.getMessage() + " no existe");
        }
        catch (IOException e)
        {
            System.err.println("Error: error al leer el fichero. " + e.getMessage());
        }
    }
}
