package segundotrimestre.estudiantes;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crear la clase Estudiante, que hereda de alguna de las clases de Persona que tengais (que tenga nombre, apellidos, dni). La clase Estudiante deberá incluir además el nº de matricula.
 * Crear un arraylist de clase Estudiante, e incluir 3 alumnos con toda su información.
 * Después, pedir por pantalla la informacion de un estudiante -> nombre, apellidos, dni y nº matricula
 * Comprobar usando contains o indexOf si ese estudiante se puede incluir en la lista. No queremos estudiantes repetidos.
 * Hacer esto en bucle para probar distintos casos
 *
 * {@code COMPLETADO: 8-9 minutos}
 */
public class ProgramaEstudiantes
{
    public static void main(String[] args)
    {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        ProgramaEstudiantes programa = new ProgramaEstudiantes();

        Estudiante ivan = new Estudiante("Ivan", "Gomez", "123", 18, 1);
        EstudianteExtranjero nico = new EstudianteExtranjero("Nicoleta", "Grigoras", "456", 19, 1, "Moldavia");
        Estudiante victor = new Estudiante("Victor", "Villaescusa", "789", 21, 1);

        Estudiante[] listaEstudiantes = {ivan, nico, victor};

        while (true)
        {
            System.out.println("Dime el DNI del estudiante que quieras añadir\n(También puedes escribir:\n'LISTA' para mostrar la lista\n'SALIR' para salir\n'BUSCAR' para buscar estudiante): ");
            String dniRecibido = scanner.nextLine();
            Estudiante estudianteAnadir = null;

            if ((!(dniRecibido.equalsIgnoreCase("lista")))
             && (!(dniRecibido.equalsIgnoreCase("salir")))
             && (!(dniRecibido.equalsIgnoreCase("buscar"))))
            {
                for (Estudiante listaEstudiante : listaEstudiantes)
                {
                    if (dniRecibido.equalsIgnoreCase(listaEstudiante.dni))
                    {
                        estudianteAnadir = listaEstudiante;
                        programa.anadirEstudiante(estudiantes, estudianteAnadir);
                        break;
                    }
                }
                if (estudianteAnadir == null)
                {
                    System.err.println("No se ha encontrado ningún alumno con ese DNI");
                }
            }
            else
            {
                if (dniRecibido.equalsIgnoreCase("lista")) { programa.mostrarLista(estudiantes); }
                if (dniRecibido.equalsIgnoreCase("salir")) { System.out.println("Saliendo..."); System.exit(1); }
                if (dniRecibido.equalsIgnoreCase("buscar"))
                {
                    System.out.println("Dime el DNI del alumno que quieras buscar y te digo su nombre y su posición en la lista: ");
                    String dniBuscado = scanner.nextLine();
                    Estudiante estudianteBuscado = new Estudiante("", "", dniBuscado, 0, 0);
                    int posicionAlumno = estudiantes.indexOf(estudianteBuscado);
                    if (posicionAlumno != -1)
                    {
                        System.out.printf("El alumno con el DNI %s es %s y está en la posición %d\n", dniBuscado, estudiantes.get(posicionAlumno), posicionAlumno + 1);
                    }
                    else
                    {
                        System.err.println("No hay alumno con ese DNI en la lista");
                    }
                }
            }
        }
    }

    public void anadirEstudiante(ArrayList<Estudiante> lista, Estudiante estudiante)
    {
        if (lista.contains(estudiante))
        {
            System.err.println("¡" + estudiante + " ya está en la lista!");
        }
        else
        {
            System.out.println(estudiante + " se ha añadido a la lista de estudiantes.");
            lista.add(estudiante);
        }
    }

    public void mostrarLista(ArrayList<Estudiante> lista)
    {
        if (lista.isEmpty()) { System.err.println("¡¡La lista está vacía!!"); }

        for (int i = 0; i < lista.size(); i++)
        {
            if (lista.get(i) instanceof EstudianteExtranjero)
            {
                System.out.printf("%d. [%s] %s\n", i + 1, ((EstudianteExtranjero) lista.get(i)).nacionalidad, lista.get(i));
            }
            else { System.out.printf("%d. %s\n", i + 1, lista.get(i)); }
        }
    }
}
