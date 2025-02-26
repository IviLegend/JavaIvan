package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class CalculadoraFechas
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int dia1 = 0;
        int mes1 = 0;

        int dia2 = 0;
        int mes2 = 0;

        boolean diaValido = false;
        boolean mesValido = false;



        System.out.println("Hola, voy a calcularte cuantos días hay entre dos fechas :O. Dime el primer día");
        while (!diaValido)
        {
            dia1 = scanner.nextInt();

            if ((dia1 < 0) || (dia1 > 30))
            {
                System.out.println("Dime un día válido >:(");
            }
            else
            {
                diaValido = true;
            }
        }
        System.out.println("Dime el primer mes en número.");
        while (!mesValido)
        {
            mes1 = scanner.nextInt();

            if ((mes1 < 0) || (mes1 > 12))
            {
                System.out.println("Dime un mes válido >:(");
            }
            else
            {
                mesValido = true;
            }
        }

        diaValido = false;
        mesValido = false;

        System.out.println("Dime el segundo día.");
        while (!diaValido)
        {
            dia2 = scanner.nextInt();

            if ((dia2 < 0) || (dia2 > 30))
            {
                System.out.println("Dime un día válido >:(");
            }
            else
            {
                diaValido = true;
            }
        }
        System.out.println("Dime el segundo mes en número.");
        while (!mesValido)
        {
            mes2 = scanner.nextInt();

            if ((mes2 < 0) || (mes2 > 12))
            {
                System.out.println("Dime un mes válido >:(");
            }
            else
            {
                mesValido = true;
            }
        }

        System.out.println("Genial, ahora voy a calcular cuantos días hay entre esas dos fechas");

        int diferenciaDeDias = 0;

        int diferenciaDeMeses = (mes1 * 30) - (mes2 * 30);
        diferenciaDeDias = Math.abs(diferenciaDeMeses + (dia1 - dia2));

        System.out.println("La diferencia de días es de " + diferenciaDeDias);
    }
}
