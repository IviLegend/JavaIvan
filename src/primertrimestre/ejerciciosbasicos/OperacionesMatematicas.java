package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class OperacionesMatematicas
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        double number1 = 0;
        double number2 = 0;

        int userAnswer = 0;

        double result = 0;
        String choosenOption = "";

        System.out.println("--- CALCULADORA ---");
        System.out.println("Bienvenido al menú, elige el número de opción que quieras hacer");
        System.out.println("1 - Suma");
        System.out.println("2 - Resta");
        System.out.println("3 - Potencia");
        System.out.println("4 - Raíz cuadrada");
        System.out.println("5 - Redondeo hacia abajo");
        System.out.println("6 - Redondeo");
        System.out.println("7 - Máximo");
        System.out.println("8 - Mínimo");
        System.out.println("9 - Mostrar PI");

        userAnswer = scanner.nextInt();

        switch(userAnswer)
        {
            case 1:
                System.out.println("Has elegido sumar, dime el primer número:");
                number1 = scanner.nextDouble();
                System.out.println("Dime el segundo número:");
                number2 = scanner.nextDouble();

                choosenOption = "suma";
                result = number1 + number2;
                break;

            case 2:
                System.out.println("Has elegido restar, dime el primer número:");
                number1 = scanner.nextDouble();
                System.out.println("Dime el segundo número:");
                number2 = scanner.nextDouble();

                choosenOption = "resta";
                result = number1 - number2;
                break;

            case 3:
                System.out.println("Has elegido potencia, dime la base:");
                number1 = scanner.nextDouble();
                System.out.println("Dime el exponente:");
                number2 = scanner.nextDouble();

                choosenOption = "potencia";
                result = Math.pow(number1, number2);
                break;

            case 4:
                System.out.println("Has elegido raíz cuadrada, dime el radicando:");
                number1 = scanner.nextDouble();

                choosenOption = "raíz cuadrada";
                result = Math.sqrt(number1);
                break;

            case 5:
                System.out.println("Has elegido redondear hacia abajo, dime el número:");
                number1 = scanner.nextDouble();

                choosenOption = "redondeo hacia abajo";
                result = Math.floor(number1);
                break;

            case 6:
                System.out.println("Has elegido redondear, dime el número:");
                number1 = scanner.nextDouble();

                choosenOption = "redondeo";
                result = Math.round(number1);
                break;

            case 7:
                System.out.println("Has elegido máximo, dime el primer número:");
                number1 = scanner.nextDouble();
                System.out.println("Dime el segundo número");
                number2 = scanner.nextDouble();

                choosenOption = "máximo";
                result = Math.max(number1, number2);
                break;

            case 8:
                System.out.println("Has elegido mínimo, dime el primer número:");
                number1 = scanner.nextDouble();
                System.out.println("Dime el segundo número");
                number2 = scanner.nextDouble();

                choosenOption = "mínimo";
                result = Math.min(number1, number2);
                break;

            case 9:
                System.out.println("Has elegido mostrar PI, aquí tienes:");

                System.out.println(Math.PI);
                break;

            default:
                System.out.println("Eso no estaba entre las opciones...");
        }

        if (userAnswer != 9)
        {
            System.out.println("El resultado de tu " + choosenOption + " es: " + result);
        }
    }
}
