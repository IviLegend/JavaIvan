package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class TablasDeMultiplicarScanner
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int multiplicationNumber = 0;
        int result = 0;

        System.out.println("Hola, dime un número y te enseño la tabla de multiplicar de ese número:");
        multiplicationNumber = scanner.nextInt();

        for (int cont = 0; cont <= 10; cont++)
        {
            result = multiplicationNumber * cont;
            System.out.println(multiplicationNumber + " x " + cont + " = " + result);
        }
    }
}
