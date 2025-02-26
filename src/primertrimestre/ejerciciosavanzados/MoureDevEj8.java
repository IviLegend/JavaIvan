package primertrimestre.ejerciciosavanzados;/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */

/* IDEAS
 * Hacer que cuando encuentre la primera letra compruebe
 * el resto de la palabra y lo que hay antes y después y
 * que se aumente el contador.
 */

import java.util.Scanner;

public class MoureDevEj8
{
    // Esto es una lista de los caracteres que pueden ir antes o después de la palabra buscada.
    // Si aparece cualquiera de estos caracteres antes o después de la palabra se considerará igual.

    char[] caracteresAdmitidos = {' ', '.', ',', '¿', '?', '¡', '!', '-', '_', '"', ';', '[', ']',
                                  '(', ')', '{', '}', '+', '*', '`', '#', '%', '$', '/', '^', '<',
                                  '>', 'º', 'ª', '=', '&', '@', '|', ':', '·', '~'};
    boolean comprobacionValida = false;

    public void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String palabraRepetida = "para";
        String cadenaUsuario = "";
        // cadenaUsuario = "para hola parapara (pArA). paralelepípedo PARA paraparapara dis-para eeeeee pa ra #para paraaa ppara si ¡para!"; // debería salir 6
        //                  1                   2                     3                     4                  5                     6
        int repeticionesPalabra = 0;
        boolean palabraCoincide = true;

        System.out.println("Hola, dime una frase y te cuento cuantas veces se repite la palabra '" + palabraRepetida + "':");

        cadenaUsuario = scanner.nextLine();

        /// AJUSTAMOS LA FRASE
        cadenaUsuario = cadenaUsuario.trim().toLowerCase(); // Eliminamos todos los espacios a los lados y ponemos toda la frase en minúsculas.
        cadenaUsuario = " " + cadenaUsuario + " "; // Ponemos un espacio al principio y al final para que pueda verificar si la palabra sale al principio o al final correctamente.

        /// SEPARAMOS LA FRASE CARÁCTER A CARÁCTER
        char[] cadenaUsuarioChar = cadenaUsuario.toCharArray();

        /// BUSCAR LA PALABRA
        for (int pos = 1; pos < cadenaUsuarioChar.length; pos++) // Recorremos la cadena letra a letra.
        {
            if ((cadenaUsuarioChar[pos] == palabraRepetida.charAt(0))) // Si encuentra la primera letra de nuestra palabra...
            {
                comprobacionValida = false;
                comprobarCaracteres(cadenaUsuarioChar[pos-1]); // Buscamos que en la posición de antes haya un carácter válido.

                if (comprobacionValida) // Si lo encuentra
                {
                    // Seguiremos comprobando las siguientes letras
                    int contador = 1; // Esta será la posición de la letra que vamos a comprobar.
                    palabraCoincide = true; // Le decimos que de momento sí que coincide.

                    while (palabraCoincide)  // Y después comprobamos si coincide completamente.
                    {
                        if (palabraRepetida.length() != 1) // Aunque antes verificamos que la palabra no sea justo de 1 letra.
                        {
                            // Si hay más de una letra y la siguiente letra también coincide sigue.
                            if ((cadenaUsuarioChar[pos + contador]) == palabraRepetida.charAt(contador))
                            {
                                contador++; // Sumamos el contador para buscar la siguiente letra

                                if (contador == palabraRepetida.length()) // Y si llega al final de nuestra cadena
                                {
                                    // Comprobamos que el carácter de después también sea válido
                                    comprobacionValida = false;
                                    comprobarCaracteres(cadenaUsuarioChar[pos + palabraRepetida.length()]);

                                    if (comprobacionValida) // Si lo es, pues perfecto.
                                    {
                                        repeticionesPalabra++; // Suma una repetición
                                        break; // Y sale del bucle
                                    }
                                    else // Y si no pues nada ¯\_(ツ)_/¯
                                    {
                                        // Reseteamos
                                        contador = 1;
                                        break;
                                    }
                                }
                            }
                            else // Si no le decimos directamente que salga del bucle
                            {
                                palabraCoincide = false;
                            }
                        }
                        else // En casa de que solo haya una letra
                        {
                            // Comprobamos inmediatamente el carácter de después para ver si es uno válido
                            comprobacionValida = false;
                            comprobarCaracteres(cadenaUsuarioChar[pos + palabraRepetida.length()]);

                            if (comprobacionValida) // Si fuese un carácter válido...
                            {
                                repeticionesPalabra++; // Suma una repetición
                                break; // Y sale del bucle
                            }
                            else // Y si no pues nada ¯\_(ツ)_/¯
                            {
                                // Reseteamos
                                contador = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }

        /// MOSTRAR RESULTADOS
        System.out.println();
        System.out.println("La palabra '" + palabraRepetida + "' aprece un total de " + repeticionesPalabra + " veces!!!");
    }

    public void comprobarCaracteres(char posicion)
    {
        for (int numeroLista = 0; numeroLista < caracteresAdmitidos.length; numeroLista++) // Recorremos todos los carácteres de nuestra lista de carácteres válidos
        {
            if (posicion == caracteresAdmitidos[numeroLista]) // Y si encuentra al menos uno de los listados.
            {
                comprobacionValida = true; // Le decimos que va bien y que siga
                break; // Salimos del bucle porque ya ha encontrado uno
            }
        }
    }
}
