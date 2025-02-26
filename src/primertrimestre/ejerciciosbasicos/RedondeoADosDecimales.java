package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class RedondeoADosDecimales
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        float number = 0.0f;

        number = scanner.nextFloat();

        int intNumber = (int) number;

        System.out.println("intNumber = " + intNumber);

        float magicalNumber = number - intNumber;

        System.out.println("magicalNumber = " + magicalNumber);

        magicalNumber *= 100;
    }
}
