package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class ContadorDeVocales
{
    public static void main(String[] args)
    {
        int[] contadorVocales = new int[5];
        /*
         * 0 - A
         * 1 - E
         * 2 - I
         * 3 - O
         * 4 - U
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hola, dime una frase y te cuento las vocales: ");
        String fraseUsuario = scanner.nextLine();

        fraseUsuario = fraseUsuario.trim().toLowerCase();

        for (int i = 0; i < fraseUsuario.length(); i++)
        {
            char letraActual = fraseUsuario.charAt(i);

            if (letraActual == 'a') { contadorVocales[0]++; }
            else if (letraActual == 'e') { contadorVocales[1]++; }
            else if (letraActual == 'i') { contadorVocales[2]++; }
            else if (letraActual == 'o') { contadorVocales[3]++; }
            else if (letraActual == 'u') { contadorVocales[4]++; }
        }

        System.out.println("Contador de A: " + contadorVocales[0]);
        System.out.println("Contador de E: " + contadorVocales[1]);
        System.out.println("Contador de I: " + contadorVocales[2]);
        System.out.println("Contador de O: " + contadorVocales[3]);
        System.out.println("Contador de U: " + contadorVocales[4]);
    }
}
