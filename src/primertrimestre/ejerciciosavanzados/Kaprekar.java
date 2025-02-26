package primertrimestre.ejerciciosavanzados;

import java.util.Arrays;
import java.util.Scanner;

/* IDEA
 * 1) Para ordenar los números primero cogemos el String que nos
 * dan, que es un número, y lo separamos en una cadena.
 * 2) Luego ordenamos esa cadena con Array.sort.
 * 3) Luego concatenamos cada uno de esos caracteres
 * a un nuevo String.
 * 4) Y finalmente ese String lo parseamos a Integer y ya hacemos
 * las cuentas.
 */

public class Kaprekar
{
    int numAscendente = 0;
    int numDescendente = 0;

    public void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int KAPREKAR_NUMBER = 6174;

        int numerosPedidos = 0;

        /// PEDIR AL USUARIO CUANTOS NÚMEROS SE VAN A ANALIZAR
        System.out.println("- REGLAS -");
        System.out.println("4 digitos");
        System.out.println("Los 4 diferentes");
        System.out.println("¡Hola! Voy a ver en cuantas repeticiones llegamos al número de primertrimestre.Avanzados.Kaprekar. Dime cuantos números quieres que te calcule.");
        numerosPedidos = scanner.nextInt();

        String[] numerosUsuario = new String[numerosPedidos]; // Creamos una lista que guarda los números a analizar
        int[] numeroDeRepeticiones = new int[numerosPedidos]; // Creamos otra lista con el número de repeticiones que ha tomado cada número

        /// PEDIR LOS NÚMEROS EN SI
        System.out.println("Dime entonces " + numerosPedidos + " números de 4 dígitos por favor:");

        /// COMPROBAMOS QUE CADA NÚMERO ESTÉ BIEN
        for (int i = 0; i < numerosUsuario.length; i++)
        {
            boolean numeroValido = false;

            while (!numeroValido)
            {
                numerosUsuario[i] = scanner.nextLine();

                if (numerosUsuario[i].length() == 4) { numeroValido = true; }
                else { System.out.println("Dime un número de 4 cifras por favor: "); }
            }
        }

        /// PARA CADA NÚMERO, HACEMOS LOS CÁLCULOS
        for (int i = 0; i < numerosUsuario.length; i++)
        {
            /// ORDENAMOS ESTE NÚMERO DE FORMA ASCENDENTE
            ordenarNumeroAscendente(numerosUsuario[i]);

            /// ORDENAMOS ESTE NÚMERO DE FORMA DESCENDENTE
            ordenarNumeroDescendente(numerosUsuario[i]);

            /// CALCULOS SATÁNICOS

            int resultado = 0;
            int repeticiones = 0;

            if (!(numerosUsuario[i].equals("6174")))
            {
                while ((resultado != KAPREKAR_NUMBER))
                {
                    resultado = numAscendente - numDescendente;

                    String resultadoString = resultado + "";

                    ordenarNumeroAscendente(resultadoString);
                    ordenarNumeroDescendente(resultadoString);

                    repeticiones++;

                    if (repeticiones == 8)
                    {
                        break;
                    }
                }

                numeroDeRepeticiones[i] = repeticiones;
            }
        }

        /// MOSTRAR RESULTADOS
        for (int i = 0; i < numeroDeRepeticiones.length; i++)
        {
            System.out.println(numeroDeRepeticiones[i]);
        }
    }

    public void ordenarNumeroAscendente(String num)
    {
        int espaciosVacios = 0;

        char[] numUsuarioChar = new char[4];
        numUsuarioChar = num.toCharArray();

        Arrays.sort(numUsuarioChar);

        String numUsuarioAscendenteString = "";

        if (numUsuarioChar.length < 4)
        {
            espaciosVacios = 4 - numUsuarioChar.length;
        }

        for (int i = numUsuarioChar.length; i > 0; i--)
        {
            numUsuarioAscendenteString += numUsuarioChar[i-1];
        }

        if (espaciosVacios != 0)
        {
            for (int i = espaciosVacios; i > 0; i--)
            {
                numUsuarioAscendenteString += "0";
            }
        }
        numAscendente = Integer.parseInt(numUsuarioAscendenteString);
    }

    public void ordenarNumeroDescendente(String num)
    {
        char[] numUsuarioChar = num.toCharArray();

        Arrays.sort(numUsuarioChar);

        String numUsuarioDescendenteString = "";

        for (int i = 0; i < numUsuarioChar.length; i++)
        {
            numUsuarioDescendenteString += numUsuarioChar[i];
        }

        numDescendente = Integer.parseInt(numUsuarioDescendenteString);
    }
}
