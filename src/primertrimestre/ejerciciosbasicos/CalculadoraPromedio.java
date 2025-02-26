package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class CalculadoraPromedio
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el primer número:");
        int num1 = scanner.nextInt();

        System.out.println("Introduce el segundo número:");
        int num2 = scanner.nextInt();

        System.out.println("Introduce el tercer número:");
        int num3 = scanner.nextInt();

        // Aquí debería calcularse el promedio de los tres números
        double promedio = calcularPromedio(num1, num2, num3);

        // Imprimir el resultado
        System.out.println("El promedio es: " + promedio);
    }
    // Función para calcular el promedio
    public static double calcularPromedio(int a, int b, int c)
    {
        /* FIX:
         * La variable suma debe ser un double en vez de un int para que al hacer
         * la división nos devuelva también los decimales.
         */
        double suma = a + b + c;
        double promedio = suma / 3;
        return promedio;
    }
}

