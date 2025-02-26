package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class Sueldo
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int firstFee = 12;
        int secondFee = 15;
        int thirdFee = 25;

        int firstFeeHours = 20;
        int secondFeeHours = 30;

        int workedHours = 0;

        int salary = 0;

        System.out.println("Hola, voy a calcular tu sueldo!!! Dime cuantas horas has trabajado: ");
        workedHours = scanner.nextInt();

        if (workedHours >= firstFeeHours)
        {
            salary = firstFeeHours * firstFee;

            workedHours -= firstFeeHours;

            if (workedHours >= secondFeeHours)
            {
                salary += secondFeeHours * firstFee;
            }
        }
    }
}
