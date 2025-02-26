package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

/*
 * Menor número de ventas
 * Mayor número de ventas
 * ¿Las ventas del Domingo superan la media?
 *
 *
 * SALIDA:
 * Mayor ventas, Menor ventas, Ha superado el Domingo
 *
 * EJEMPLO QUE TE DAN:
 * ENTRADA
 * 180,50
 * 250,36
 * 163,45
 * 535,20
 * 950,22
 * 450,38
 *
 * SALIDA
 * SABADO JUEVES SI
 */

public class ElBarDeJavier
{
    /* int - string
     * 0 - Martes
     * 1 - Miércoles
     * 2 - Jueves
     * 3 - Viernes
     * 4 - Sábado
     * 5 - Domingo
     */

    public static void main(String[] args)
    {
        /// VARIABLES
        Scanner scanner = new Scanner(System.in);       // Declara el Scanner

        float[] ventasDia = { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };     // Array con las ventas de cada semana
        String[] nombreDia = { "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", "DOMINGO" };

        int diaMayorVentas = 0;                         // Día mayor de ventas (0-5)
        int diaMenorVentas = 0;                         // Día menor de ventas (0-5)

        String diaMayorString = "";                     // Día mayor en String
        String diaMenorString = "";                     // Día menor en String

        float media = 0.0f;                             // Media de la semana
        boolean domingoSuperaLaMedia = false;           // ¿Supera el domingo la media?

        int semanasAnalizadas = 0;                      // Cuantas semanas se han pedido

        /// BIENVENIDA
        System.out.println("¡Bienvenido Javier!");

        while(true)
        {
            System.out.println("Introduce los datos de la nueva semana:");
            System.out.println("(Si quieres terminar el programa, escribe -1 en el Martes)");

            /// PEDIR LOS DATOS
            for (int diaSemana = 0; diaSemana <= 5; diaSemana++) // Pedimos los días
            {
                switch (diaSemana) // Le decimos que día tiene que introducir
                {
                    case 0 -> System.out.print("Martes: ");
                    case 1 -> System.out.print("Miércoles: ");
                    case 2 -> System.out.print("Jueves: ");
                    case 3 -> System.out.print("Viernes: ");
                    case 4 -> System.out.print("Sábado: ");
                    case 5 -> System.out.print("Domingo: ");
                }

                ventasDia[diaSemana] = scanner.nextFloat(); // Recibe las ventas

                if ((diaSemana == 0) && (ventasDia[diaSemana] == -1)) // Si introduce un -1 el Martes...
                {
                    System.out.println("¡Hemos terminado!");

                    // Te indica cuantas semanas se han analizado.
                    if (semanasAnalizadas == 1) { System.out.println("Se han analizado los datos de: " + semanasAnalizadas + " semana."); }
                    else if (semanasAnalizadas == 0) { System.out.println("No se han analizado datos de ninguna semana."); }
                    else { System.out.println("Se han analizado los datos de: " + semanasAnalizadas + " semanas"); }

                    System.exit(0); // Termina el programa
                }
            }

            /// CALCULAR LA MEDIA PARA COMPROBAR SI EL DOMINGO SUPERA LA MEDIA
            for (int numeroActualMedia = 0; numeroActualMedia < ventasDia.length; numeroActualMedia++)
            {
                media += ventasDia[numeroActualMedia]; // Suma todos los valores
            }

            media /= 6; // Hace la media

            // Comprueba si el domingo (5) es mayor a la media
            if (ventasDia[5] > media)
            {
                domingoSuperaLaMedia = true;
            }
            else
            {
                domingoSuperaLaMedia = false;
            }

            /// CALCULAR EL DÍA MAYOR DE VENTAS Y EL DÍA MENOR DE VENTAS

            // Día mayor ventas
            float numeroMayorActual = ventasDia[0];

            for (int diaActual = 0; diaActual < ventasDia.length; diaActual++) // Calculamos el día mayor de ventas.
            {
                if (ventasDia[diaActual] > numeroMayorActual) // Compara
                {
                    numeroMayorActual = ventasDia[diaActual];
                    diaMayorVentas = diaActual;
                }
            }

            // Día menor ventas
            float numeroMenorActual = ventasDia[0];

            for (int diaActual = 0; diaActual < ventasDia.length; diaActual++) // Calculamos el día menor de ventas.
            {
                if (ventasDia[diaActual] < numeroMenorActual) // Compara
                {
                    numeroMenorActual = ventasDia[diaActual];
                    diaMenorVentas = diaActual;
                }
            }

            // Convierte el número de día en String
            diaMayorString = nombreDia[diaMayorVentas];
            diaMenorString = nombreDia[diaMenorVentas];

            /// RESULTADOS

            System.out.println(); // Línea vacía

            // Imprimimos el día con mayores ventas y el dia con menores ventas
            if (ventasDia[diaMayorVentas] != ventasDia[diaMenorVentas])
            {
                System.out.print(diaMayorString + " " + diaMenorString);
            }
            else
            {
                System.out.print("EMPATE");
            }

            // Imprimimos si el Domingo supera o no la media
            if (domingoSuperaLaMedia)
            {
                System.out.println(" SI");
            }
            else
            {
                System.out.println(" NO");
            }

            semanasAnalizadas++; // Sumamos 1 a las semanas analizadas
            System.out.println("¡Hemos terminado con esta semana!");
            System.out.println(); // Línea vacía

            /*for (int i = 0; i < ventasDia.length; i++)
            {
                System.out.print(ventasDia[i] + " ");
            }*/
        }
    }
}
