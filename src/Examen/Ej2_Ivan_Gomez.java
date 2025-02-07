package Examen;

import java.util.Scanner;

public class Ej2_Ivan_Gomez
{
    public static void main(String[] args)
    {
        /// DECLARACIÓN DE VARIABLES
        Scanner scanner = new Scanner(System.in);

        double eurosUsuario = 0;
        String divisaUsuario = "";
        /* Opciones
         * LIBRA
         * USD
         * BTC
         */

        double resultado = 0.0;
        double decimalesResultado = 0.0;
        int enteroResultado = 0;

        double valorLIBRA = 0.83;
        double valorUSD = 1.17;
        double valorBTC = 0.00001104;

        double valorConversion = 0.0;

        boolean opcionValida = false;

        /// PEDIR LOS DATOS AL USUARIO
        System.out.println("*** BIENVENIDO AL SISTEMA DE CAMBIO DE DIVISA ***");
        System.out.println("Introduzca el importe en euros: ");
        eurosUsuario = scanner.nextDouble();
        scanner.nextLine(); // Limpiamos el búffer
        System.out.println("Introduzca divisa final:");

        while (!opcionValida)
        {
            divisaUsuario = scanner.nextLine().toUpperCase().trim();
            switch (divisaUsuario)
            {
                case "LIBRAS":
                {
                    valorConversion = valorLIBRA;
                    opcionValida = true;
                    break;
                }

                case "USD":
                {
                    valorConversion = valorUSD;
                    opcionValida = true;
                    break;
                }

                case "BTC":
                {
                    valorConversion = valorBTC;
                    opcionValida = true;
                    break;
                }

                default:
                {
                    System.out.println("Introduce una opción válida:");
                }
            }
        }

        resultado = eurosUsuario * valorConversion;

        /// REDONDEAR A 4 DECIMALES

        enteroResultado = (int)resultado;
        decimalesResultado = resultado - enteroResultado;

        decimalesResultado *= 10000;

        decimalesResultado = Math.round(decimalesResultado);

        decimalesResultado /= 10000;

        System.out.println(decimalesResultado);

        resultado = enteroResultado;

        resultado += decimalesResultado;

        System.out.println("**** RESULTADO ****");
        System.out.println("EL CAMBIO DE " + eurosUsuario + " EUROS A " + divisaUsuario + " ES " + resultado);
    }
}
