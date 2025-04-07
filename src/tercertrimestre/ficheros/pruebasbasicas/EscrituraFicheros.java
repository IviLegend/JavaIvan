package tercertrimestre.ficheros.pruebasbasicas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscrituraFicheros
{
    public static void main(String[] args)
    {
        Path rutaAlFichero = Paths.get("cosas/ficherogrande.txt");

        try
        {
            if (!Files.exists(rutaAlFichero))
            {
                Files.createFile(rutaAlFichero);
            }

            Files.writeString(rutaAlFichero, "Paco");
        }
        catch (IOException e)
        {
            System.err.println("Error: no se ha podido crear el fichero.");
        }
    }
}
