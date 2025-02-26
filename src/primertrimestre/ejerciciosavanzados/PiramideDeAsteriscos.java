package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class PiramideDeAsteriscos
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        int numeroUsuario = 0;

        System.out.println("Dime un número positivo y hago una pirámide to guapa:");
        numeroUsuario = scanner.nextInt();

        int numeroDeEspaciosDelNivel = 0;
        int numeroDeAsteriscosDelNivel = 0;

        // Este for se utiliza para incrementar el nivel de la pirámide.
        for (int nivelPiramide = 1; nivelPiramide <= numeroUsuario; nivelPiramide++)
        {
            numeroDeEspaciosDelNivel = numeroUsuario - nivelPiramide;
            numeroDeAsteriscosDelNivel = (nivelPiramide * 2) - 1;

            // Este for se utiliza para poner los espacios.
            for (int contadorEspacios = 0; contadorEspacios <= numeroDeEspaciosDelNivel; contadorEspacios++)
            {
                System.out.print(" ");
            }

            // Este for se utiliza para poner los asteriscos.
            for (int contadorAsteriscos = 0; contadorAsteriscos < numeroDeAsteriscosDelNivel; contadorAsteriscos++)
            {
                System.out.print("*");
            }

            System.out.println(); // Imprimimos una línea vacía.
        }
    }
}

/* Nivel = 1 (1)  -> -----*
 * Nivel = 2 (3)  -> ----***
 * Nivel = 3 (5)  -> ---*****
 * Nivel = 4 (7)  -> --*******
 * Nivel = 5 (9)  -> -*********
 * Nivel = 6 (11) -> ***********
 *
 * Asteriscos por nivel = (Nivel * 2) - 1
 * Nivel 1 = (1 * 2) - 1 = 1
 * Nivel 2 = (2 * 2) - 1 = 3
 *
 * Espacios por nivel = NumeroUsuario - Nivel
 *
 */