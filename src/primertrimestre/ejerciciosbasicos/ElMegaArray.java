package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;
import java.util.Random;

public class ElMegaArray
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroUsuario = 0;

        int[] listaNumeros = new int[1000];

        int cuantosNumerosHay = 0;

        // Rellenar array

        for (int i = 0; i < listaNumeros.length; i++)
        {
            listaNumeros[i] = random.nextInt(99);
            //System.out.println(listaNumeros[i]);
        }

        System.out.println("Hola, he generado una cadena de MIL NÚMEROS entre el 0 y el 99. Dime ahora tú un número y te digo cuentas veces está en mi cadena");

        numeroUsuario = scanner.nextInt();

        for (int i = 0; i < listaNumeros.length; i++)
        {
            if (numeroUsuario == listaNumeros[i])
            {
                cuantosNumerosHay++;
            }
        }

        System.out.println(cuantosNumerosHay);
    }
}
