package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class NotasAlumnosMatrices
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] asignatura = {"Lenguaje de Marcas", "Programación", "Sistemas Informáticos", "Bases de Datos", "Entornos de Desarrollo"};
        int numAlumnos = 4;
        int numAsignaturas = asignatura.length;
        double[][] notas = new double[numAlumnos][numAsignaturas];

        System.out.println("¡Hola! Vamos a introducir las notas de varios alumnos");

        /// RECIBIR LAS NOTAS
        for (int i = 0; i < notas.length; i++)
        {
            int numeroAlumno = i+1;

            System.out.println("Introduce las notas del Alumno " + numeroAlumno + ": ");

            for (int j = 0; j < notas[i].length; j++)
            {
                System.out.print(asignatura[j] + ": ");
                notas[i][j] = scanner.nextDouble();
            }
        }

        /// CÁLCULOS SATÁNICOS

        double[] notaMaxima = new double[numAlumnos];
        double[] notaMinima = new double[numAlumnos];
        double[] notaMedia = new double[numAlumnos];

        // Calcular la nota máxima de cada alumno
        for (int alumno = 0; alumno < notas.length; alumno++)
        {
            for (int i = 0; i < notaMaxima.length; i++)
            {
                if (notaMaxima[alumno] > notas[i][alumno])
                {
                    notaMaxima[alumno] = notas[i][alumno];
                }
            }
        }

        for (int i = 0; i < numAlumnos; i++)
        {
            for (int j = 0; j < numAsignaturas; j++)
            {
                System.out.println(notaMaxima[i]);
            }
        }
    }
}
