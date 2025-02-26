package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class ArraysNaturales
{
    public static int[] arrayNaturales;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola, voy a crear un array de la longitud que me digas y lo rellenaré con los números naturales que hasta que me digas");

        int respuesta = scanner.nextInt();

        arrayNaturales = CrearArraysNaturales(respuesta);

        MostrarArrays(arrayNaturales);

        System.out.println();

        System.out.println("Ahora te voy a hacer la suma de todos esos números:");
        int suma = SumaArrays(arrayNaturales);
        System.out.println("suma = " + suma);

        System.out.println("Ahora te voy a hacer la media de todos esos números:");
        double media = MediaArrays(arrayNaturales);
        System.out.println("media = " + media);
    }

    public static int[] CrearArraysNaturales(int longitudArray)
    {
        if (longitudArray > 1)
        {
            int[] arrayNaturales = new int[longitudArray];
            int cont = 1;
            for (int i = 0; i < arrayNaturales.length; i++)
            {
                arrayNaturales[i] = cont+i;
            }

            return arrayNaturales;
        }
        else
        {
            System.out.println("Valor no válido");
            System.exit(0);
            return null;
        }
    }

    public static int SumaArrays(int[] arrayParaSumar)
    {
        int suma = 0;

        for (int i = 0; i < arrayParaSumar.length; i++)
        {
            suma += arrayParaSumar[i];
        }

        return suma;
    }

    public static double MediaArrays(int[] arrayParaMedia)
    {
        double suma = SumaArrays(arrayNaturales);

        double media = suma / arrayNaturales.length;

        return media;
    }

    public static void MostrarArrays(int[] arrayParaMostrar)
    {
        for (int i = 0; i < arrayParaMostrar.length; i++)
        {
            System.out.print(arrayParaMostrar[i] + " ");
        }
    }
}
