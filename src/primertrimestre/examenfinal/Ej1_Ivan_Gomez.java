package primertrimestre.examenfinal;

import java.util.Arrays;
import java.util.Random;

public class Ej1_Ivan_Gomez
{
    public static void main(String[] args)
    {
        /// DECLARACIÓN DE VARIABLES
        Random random = new Random();

        int[][] numerosBingo = new int[3][5];

        int[] numerosRegistrados = new int[15];

        Arrays.fill(numerosRegistrados, -1);

        int numeroAleatorio = 0;
        int posicionArrayRegistrados = 0;

        /// RELLENAR EL CARTÓN
        for (int fila = 0; fila < numerosBingo.length; fila++)
        {
            for (int columna = 0; columna < numerosBingo[fila].length; columna++)
            {
                numeroAleatorio = random.nextInt(91);

                boolean numeroValido = false;

                while (!numeroValido)
                {
                    boolean haVueltoAGenerar = false;

                    // Recorremos la lista de números registrados entera
                    for (int posicion = 0; posicion < numerosRegistrados.length; posicion++)
                    {
                        if (numeroAleatorio == numerosRegistrados[posicion]) // Si encontramos un número repetido
                        {
                            numeroAleatorio = random.nextInt(91); // Lo genera de nuevo
                            haVueltoAGenerar = true;
                        }
                    }
                    if (!haVueltoAGenerar)
                    {
                        numeroValido = true;
                    }
                }

                numerosBingo[fila][columna] = numeroAleatorio;
                numerosRegistrados[posicionArrayRegistrados] = numeroAleatorio;
                posicionArrayRegistrados++;
            }
        }

        /// MOSTRAR EL CARTÓN
        System.out.println("*** BIENVENIDO AL BINGO ***");
        System.out.println("Tu cartón es:");
        for (int fila = 0; fila < numerosBingo.length; fila++)
        {
            for (int columna = 0; columna < numerosBingo[fila].length; columna++)
            {
                System.out.print(numerosBingo[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}
