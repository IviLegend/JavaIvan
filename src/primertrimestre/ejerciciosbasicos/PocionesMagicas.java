package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;

public class PocionesMagicas
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String[] listaPocimas = new String[5];

        System.out.println("Bienvenido aprendiz, dime 5 de tus mejores pócimas");

        int contador = 0;

        for (int i = 0; i < listaPocimas.length; i++)
        {
            contador +=1;
            System.out.println("Dime la pócima nº" + contador);
            listaPocimas[i] = scanner.nextLine();
        }

        System.out.print("Así que estas son tus pócimas: ");

        for (int i = 0; i < listaPocimas.length; i++)
        {
            System.out.print(listaPocimas[i]);

            if (i != listaPocimas.length-1)
            {
                System.out.print(", ");
            }
            else
            {
                System.out.print(".");
            }
        }
    }
}
