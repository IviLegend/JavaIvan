package Examen;

import java.util.Scanner;

public class Ej3_Ivan_Gomez
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int ciudadesParaCalcular = 0;

        System.out.println("*** BIENVENIDO A LA MONITORIZACIÓN CLIMÁTICA ***");
        System.out.println("¿Cuántas ciudades calculamos?");
        ciudadesParaCalcular = scanner.nextInt();
        scanner.nextLine();

        String datos = "";

        String[] ciudades = new String[ciudadesParaCalcular];
        double[] temperatura = new double[ciudadesParaCalcular];
        double[] humedad = new double[ciudadesParaCalcular];

        double[] ITC = new double[ciudadesParaCalcular];

        int contadorCiudad = 0;

        String temperaturaString = "";
        String humedadString = "";

        /// PEDIR LOS DATOS DE CADA CIUDAD
        for (int numeroCiudad = 0; numeroCiudad < ciudadesParaCalcular; numeroCiudad++)
        {
            contadorCiudad++;
            System.out.println("- INTRODUCE DATOS DE CIUDAD " + contadorCiudad);
            datos = scanner.nextLine();

            /// REESCRIBE LA CADENA PARA EVITAR PROBLEMAS CON LOS DOUBLE
            datos = datos.replace(',', '.');

            /// INTERPRETA Y SEPARA LOS DATOS
            int posicionPrimerEspacio = datos.indexOf(" ");
            int posicionSegundoEspacio = datos.lastIndexOf(" ");

            ciudades[numeroCiudad] = datos.substring(0, posicionPrimerEspacio);

            temperaturaString = datos.substring(posicionPrimerEspacio, posicionSegundoEspacio);
            temperatura[numeroCiudad] = Double.parseDouble(temperaturaString);

            humedadString = datos.substring(posicionSegundoEspacio, datos.length()-1);
            humedad[numeroCiudad] = Double.parseDouble(humedadString);

            ITC[numeroCiudad] = temperatura[numeroCiudad]+(humedad[numeroCiudad]/100)*10;
        }

        String nivel = "";

        /// MOSTRAR RESULTADOS
        System.out.println();
        System.out.println("***** RESULTADO *****");
        for (int numeroCiudad = 0; numeroCiudad < ciudadesParaCalcular; numeroCiudad++)
        {
            if(ITC[numeroCiudad] < 25) { nivel = "Bajo"; }
            else if (ITC[numeroCiudad] < 35) { nivel = "Medio"; }
            else { nivel = "Alto"; }

            System.out.println(ciudades[numeroCiudad] + ": " + nivel);
        }
    }
}
