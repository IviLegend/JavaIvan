package tercertrimestre.ficheros.estudiantesyasignaturas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LecturaPersonasAsignaturas
{
    public static void main(String[] args)
    {
        Path rutaArchivoEstudiantes = Paths.get("res", "ficheros", "estudiantesyasignaturas", "estudiantes_cursos_unicos_50.txt");

        try
        {
            // Añadir todos los estudiantes de un fichero a una lista.
            List<Estudiante> listaEstudiantes = new ArrayList<>();
            List<String> lineasFichero = Files.readAllLines(rutaArchivoEstudiantes);

            for(String linea : lineasFichero)
            {
                String[] valores = linea.split(",");

                String nombre = valores[0];
                Set<String> asignaturas = new HashSet<>();

                for (int i = 1; i < valores.length; i++)
                {
                    asignaturas.add(valores[i]);
                }

                Estudiante estudiante = new Estudiante(nombre, asignaturas);
                listaEstudiantes.add(estudiante);
            }

            // Almacenar en un Mapa el número de alumnos por asignatura
            Map<String, Integer> mapaNumAlumnosPorAsignatura = new HashMap<>();

            // Para cada estudiante
            for (Estudiante est : listaEstudiantes)
            {
                // Nos metemos en sus asignaturas
                for (String asignatura : est.listaAsignaturas)
                {
                    // La clave va a ser el nombre de la asignatura
                    // Y el valor va a ser el valor que ya había, más 1.
                    Integer valor = mapaNumAlumnosPorAsignatura.get(asignatura);

                    if (mapaNumAlumnosPorAsignatura.get(asignatura) == null)
                    {
                        mapaNumAlumnosPorAsignatura.put(asignatura, 1);
                    }
                    else
                    {
                        mapaNumAlumnosPorAsignatura.put(asignatura, valor + 1);
                    }
                }
            }

            // Mostrar los estudiantes.
            listaEstudiantes.forEach(System.out::println);

            // Mostrar el mapa
            System.out.println(mapaNumAlumnosPorAsignatura);
        }
        catch (IOException e)
        {
            System.err.printf("Error al leer el fichero: %s", e);
        }
    }
}
