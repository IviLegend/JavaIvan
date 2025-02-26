package primertrimestre.ejerciciosavanzados;

import java.util.Scanner;

public class PalindromoEpico
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String cadenaUsuario = scanner.nextLine().toLowerCase();

        String cadenaUsuarioSinEspacios = "";

        /// ELIMINAR LOS ESPACIOS
        for (int i = 0; i < cadenaUsuario.length(); i++)
        {
            if (cadenaUsuario.charAt(i) != ' ')
            {
                cadenaUsuarioSinEspacios += cadenaUsuario.charAt(i);
            }
        }

        // System.out.println("cadenaUsuarioSinEspacios = " + cadenaUsuarioSinEspacios);
        
        /// DARLE LA VUELTA A LA CADENA
        String cadenaUsuarioDelReves = "";

        for (int i = 0; i < cadenaUsuarioSinEspacios.length(); i++)
        {
            cadenaUsuarioDelReves += cadenaUsuarioSinEspacios.charAt(cadenaUsuarioSinEspacios.length() - 1 - i);
        }

        // System.out.println("cadenaUsuarioDelReves = " + cadenaUsuarioDelReves);

        /// COMPROBAR
        boolean esPalindromo = cadenaUsuarioSinEspacios.equals(cadenaUsuarioDelReves);
        System.out.println("Es un palíndromo: " + esPalindromo);
    }
}
