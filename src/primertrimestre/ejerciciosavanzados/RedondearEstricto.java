package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class RedondearEstricto
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double number = 0;

        double magicalNumber = 0;
        int result = 0;

        System.out.println("Hola, dime el número que voy a redondear (soy muy estricto):");
        number = scanner.nextDouble();

        int integerNumber = (int)number;

//        System.out.println("number = " + number);
//        System.out.println("integerNumber = " + integerNumber);
        
        magicalNumber = number - integerNumber;

//        System.out.println("magicalNumber = " + magicalNumber);

        if (magicalNumber >= 0.9)
        {
            result = integerNumber + 1;
        }
        else
        {
            result = integerNumber;
        }

        System.out.println("El resultado de mi estricto redondeo es " + result);
    }
}
