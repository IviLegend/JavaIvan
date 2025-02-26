package primertrimestre.examenfinal;

import java.util.Scanner;

public class Ej4_Ivan_Gomez
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HOLA, DIME CUANTOS NOMBRES QUIERES INTRODUCIR: ");
        int numNombresPedidos = scanner.nextInt();
        scanner.nextLine();

        String[] nombres = new String[numNombresPedidos];

        int numeroNombre = 0;

        for (int posicion = 0; posicion < nombres.length; posicion++)
        {
            numeroNombre++;
            System.out.print("Dime el nombre " + numeroNombre + ": ");
            nombres[posicion] = scanner.nextLine().trim();
        }

        System.out.println("AHORA DIME UNA DE ESTAS OPCIONES, DEL 1 AL 5");
        System.out.println("1- CADENA MÁS LARGA");
        System.out.println("2- MOSTRAR TODAS");
        System.out.println("3- COMPARACIÓN CADENAS");
        System.out.println("4- BUSCAR CARÁCTER");
        System.out.println("5- SALIR");

        int opcionUsuario = scanner.nextInt();
        scanner.nextLine();

        switch(opcionUsuario)
        {
            case 1:
            {
                /// BUSCAMOS EL NOMBRE CON MÁS LETRAS
                int nombresMismoNumeroLetras = 0;
                int longitudMaxima = nombres[0].length();

                // Busca la longitud máxima
                for (int posicion = 0; posicion < nombres.length; posicion++)
                {
                    if (nombres[posicion].length() > longitudMaxima)
                    {
                        longitudMaxima = nombres[posicion].length();
                    }
                }

                // Busca cuantos nombres hay con esas letras
                for (int posicion = 0; posicion < nombres.length; posicion++)
                {
                    if (nombres[posicion].length() == longitudMaxima)
                    {
                        nombresMismoNumeroLetras++;
                    }
                }
                String[] nombresMasLargos = new String[nombresMismoNumeroLetras];

                int contadorIndex = 0;

                // Almacena esos nombres
                for (int posicion = 0; posicion < nombres.length; posicion++) {
                    if (nombres[posicion].length() == longitudMaxima) {
                        nombresMasLargos[contadorIndex] = nombres[posicion];
                        System.out.print(nombresMasLargos[contadorIndex] + " ");
                        contadorIndex++;
                    }
                }
                break;
            }

            case 2:
            {
                for (int posicionNombre = 0; posicionNombre < nombres.length; posicionNombre++)
                {
                    if ((posicionNombre % 2) == 0)
                    {
                        System.out.print(nombres[posicionNombre].toUpperCase() + " ");
                    }
                    else
                    {
                        System.out.print(nombres[posicionNombre].toLowerCase() + " ");
                    }
                }
                break;
            }

            case 3:
            {
                System.out.print("DIME LA POSICIÓN DEL PRIMER NOMBRE (ENTRE 1 Y " + numNombresPedidos + "): ");
                int posicion1 = scanner.nextInt()-1;
                scanner.nextLine();
                System.out.print("DIME LA POSICIÓN DEL SEGUNDO NOMBRE (ENTRE 1 Y " + numNombresPedidos + "): ");
                int posicion2 = scanner.nextInt()-1;
                scanner.nextLine();

                if (nombres[posicion1].equalsIgnoreCase(nombres[posicion2]))
                {
                    System.out.println("SON IGUALES");
                }
                else
                {
                    System.out.println("NO SON IGUALES");
                }

                break;
            }

            case 4:
            {
                System.out.print("DIME EL CARACTER QUE VAMOS A BUSCAR: ");
                String caracterBuscado = scanner.nextLine();

                boolean hayCoincidencias = false;

                for (int caracter = 0; caracter < nombres.length; caracter++)
                {
                    if (nombres[caracter].contains(caracterBuscado))
                    {
                        hayCoincidencias = true;
                        System.out.print(nombres[caracter] + " ");
                    }
                }

                if (!hayCoincidencias)
                {
                    System.out.println("No hay nombres con esa letra");
                }

                break;
            }

            case 5:
            {
                System.out.println("OKEY, ¡ADIÓS!");
                break;
            }
        }
    }
}
