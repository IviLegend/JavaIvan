package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class CodigoMorse
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        char[] listaLetras = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                              'H', 'I', 'J', 'K', 'L', 'M', 'N',
                              'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                              'V', 'W', 'X', 'Y', 'Z', ' '};

        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                           "....", "..", ".---", "-.-", ".-..", "--", "-.",
                           "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                           "...-", ".--", "-..-", "-.--", "--..", "  "};

        int opcion = 0;
        // 0 - De normal a morse
        // 1 - De morse a normal

        int indiceLetra = -1;

        String cadenaUsuario = "";

        /// SALUDAMOS
        System.out.println("¡Hola, soy un traductor morse!");

        /// PEDIMOS LA OPCIÓN QUE QUIERE
        System.out.println("Escribe 0 si quieres que te traduzca de normal a morse y 1 si quieres que te pase de morse a normal");
        opcion = scanner.nextInt();

        if (opcion == 0)
        {
            System.out.println("Perfecto, pasaremos de normal a morse. Dime algo:");
            scanner.nextLine();
            cadenaUsuario = scanner.nextLine();
        }
        else if (opcion == 1)
        {
            System.out.println("Perfecto, pasaremos de morse a normal. Dime una frase en morse CON ESPACIOS ENTRE LAS LETRAS:");
            scanner.nextLine();
            cadenaUsuario = scanner.nextLine();
        }
        else if (opcion == 2)
        {
            System.out.println("Perfecto, haremos la ampliación rara. Dime algo:");
            scanner.nextLine();
            cadenaUsuario = scanner.nextLine();
        }
        else
        {

        }

        /// AJUSTAMOS LA CADENA
        cadenaUsuario = cadenaUsuario.trim().toUpperCase();

        if (opcion == 1)
        {
            cadenaUsuario = " " + cadenaUsuario + " ";
        }

        /// CONVERTIMOS
        switch (opcion)
        {
            case 0: // De normal a morse
            {
                char[] cadenaUsuarioChar = cadenaUsuario.toCharArray(); // Separamos cada letra de la cadena

                for (int letra = 0; letra < cadenaUsuarioChar.length; letra++) // Recorremos todas las letras de la cadena
                {
                    for (int i = 0; i < listaLetras.length; i++) // En cada letra buscamos el índice de esa letra, que es su correspondiente en morse
                    {
                        if (cadenaUsuarioChar[letra] == listaLetras[i]) // Cuando lo encuentre
                        {
                            indiceLetra = i; // Que lo guarde
                            break; // Salga del bucle
                        }
                    }

                    System.out.print(morse[indiceLetra] + " "); // Y lo muestre por pantalla
                }

                break;
            }

            case 1: // De morse a normal
            {
                char[] cadenaUsuarioChar = cadenaUsuario.toCharArray(); // Separamos cada letra de la cadena

                String letraEnMorseLeyendo = "";

                for (int letra = 0; letra < cadenaUsuarioChar.length; letra++) // Recorremos letra a letra
                {
//                    if (letra)
                }

                break;
            }

            case 2: // Ampliación rara
            {
                char[] cadenaUsuarioChar = cadenaUsuario.toCharArray(); // Separamos cada letra de la cadena

                String[] fraseMorse = new String[cadenaUsuario.length()];

                for (int posArray = 0; posArray < fraseMorse.length; posArray++)
                {
                    for (int i = 0; i < listaLetras.length; i++) // En cada letra buscamos el índice de esa letra, que es su correspondiente en morse
                    {
                        if (cadenaUsuarioChar[posArray] == listaLetras[i]) // Cuando lo encuentre
                        {
                            fraseMorse[posArray] = morse[posArray];
                        }
                    }
                }

                /// MOSTRAR
                for (int i = 0; i < fraseMorse.length; i++)
                {
                    System.out.print(fraseMorse[i] + " ");
                }
            }
        }
    }
}
