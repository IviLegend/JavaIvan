package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class NumeroPrimo
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numeroUsuario = 0;
        boolean esPrimo = false;
        int factores = 0;

        System.out.println("Hola, dime un numero entero positivo y te digo si es primo o no :O");
        numeroUsuario = scanner.nextInt();

        for (int i = 1; i <= numeroUsuario; i++)
        {
            int numeroCalculo = numeroUsuario % i;

            if (numeroCalculo == 0)
            {
                factores++;
            }
        }

        if (factores == 2) { esPrimo = true; }

        if (esPrimo)
        {
            System.out.println("El número " + numeroUsuario + " es primo!!!");
        }
        else
        {
            System.out.println("El número " + numeroUsuario + " NO es primo D:");
        }
    }
}
