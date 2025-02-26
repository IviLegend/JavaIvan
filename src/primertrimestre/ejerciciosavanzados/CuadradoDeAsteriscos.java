package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class CuadradoDeAsteriscos
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int longitudLado = 0;

        System.out.println("Hola, dime un número y te dibujo un cuadrado de ese lado");
        longitudLado = scanner.nextInt();

        // Dibujamos la parte de arriba
        for (int i = 1; i <= longitudLado; i++)
        {
            System.out.print("*");
        }

        System.out.println("");
        int numeroDeFilasDelCuadrado = longitudLado - 2;
        //Dibujamos la parte del medio
        for (int i = 0; i < numeroDeFilasDelCuadrado; i++) // Este for va recorriendo las filas del medio
        {
            System.out.print("*"); // Dibujamos el primer asterisco de la fila

            for (int j = 0; j < numeroDeFilasDelCuadrado; j++) // Dibujamos los espacios que necesitemos.
            {
                System.out.print(" ");
            }

            System.out.print("*"); // Dibujamos el último asterisco de la fila
            System.out.println("");
        }

        // Dibujamos la parte final
        for (int i = 1; i <= longitudLado; i++)
        {
            System.out.print("*");
        }
    }
}

/*

    Lado 6

    ******
    *----*
    *----*
    *----*
    *----*
    ******

 */
