package primertrimestre.ejerciciosavanzados;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramasIncreibles
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String palabra1 = "";
        String palabra2 = "";

        int esAnagrama = 1;

        /// RECIBIR LAS PALABRAS
        palabra1 = scanner.nextLine().trim().toLowerCase();
        palabra2 = scanner.nextLine().trim().toLowerCase();

        /// COMPROBAR
        if (palabra1.length() != palabra2.length())
        {
            System.out.println("Las palabras no tienen ni el mismo número de letras -_-");
        }
        else
        {
            char[] palabra1Char = palabra1.toCharArray();
            char[] palabra2Char = palabra2.toCharArray();

            Arrays.sort(palabra1Char);
            Arrays.sort(palabra2Char);

            esAnagrama = Arrays.compare(palabra1Char, palabra2Char);

            if (esAnagrama == 0)
            {
                System.out.printf("¡¡¡%s es un anagrama de %s!!!", palabra1, palabra2);
            }
            else
            {
                System.out.printf("%s NO es un anagrama de %s", palabra1, palabra2);
            }
        }

    }
}
