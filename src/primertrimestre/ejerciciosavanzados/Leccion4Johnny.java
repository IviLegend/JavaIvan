package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class Leccion4Johnny
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numerosDeSucesion = 0;

        long segundoNumeroAnterior = 0;
        long primerNumeroAnterior = 1;

        long numeroActual = 0;

        System.out.println("¿Cuantos números de la sucesión de Fibonacci quieres que te diga?");
        numerosDeSucesion = scanner.nextInt();

        System.out.println("0");
        System.out.println("1");

        for (int i = 3; i < numerosDeSucesion; i++)
        {
            numeroActual = primerNumeroAnterior + segundoNumeroAnterior;

            System.out.println(numeroActual);

            segundoNumeroAnterior = primerNumeroAnterior;
            primerNumeroAnterior = numeroActual;
        }
    }
}
