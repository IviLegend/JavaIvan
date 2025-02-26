package primertrimestre.ejerciciosavanzados;

import java.util.Arrays;
import java.util.Scanner;

public class Ajedrez
{
    public static String[][] tablero = new String[8][8];

    public static String[] letrasFilas = {"a", "b", "c", "d", "e", "f", "g", "h"};
    public static String[] numeroColumnas = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public static Scanner scanner = new Scanner(System.in);

    // Las fichas de ajedrez, en este orden (SOLO PARA ESTE STRING):
    // Rey, Reina, Torre, Alfil, Caballo, Peón
    //  0     1      2      3       4      5
    public static String[] fichasBlancas = {"♔", "♕", "♖", "♗", "♘", "♙"};
    public static String[] fichasNegras = {"♚", "♛", "♜", "♝", "♞", "♟"};

    // Valores internos de las fichas
    /*
     * 0 Vacío
     * 1 Rey blanco        -1 Rey negro
     * 2 Reina blanca      -2 Reina negra
     * 3 Torre blanca      -3 Torre negra
     * 4 Alfil blanco      -4 Alfil negro
     * 5 Caballo blanco    -5 Caballo negro
     * 6 Peón blanco       -6 Peón negro
     */

    public static int ganador = 0;
    /* 0  - Nadie ha ganado
     * 1  - Han ganado las blancas
     * -1 - Han ganado las negras
     */

    public static String movimiento = "";

    public static int fila = 0;
    public static int columna = 0;

    public static void main(String[] args)
    {
        ImprimirCoordenadas();
        System.out.println();
        /*ImprimirCoordenadasArray();
        System.out.println();*/
        ReiniciarTablero();
        ImprimirTablero();

        System.out.println("Es el turno de las blancas");
        //movimiento = scanner.nextLine();

        while(true)
        {
            String caca = scanner.nextLine();

            int poop = BuscarFichaAlgebraico(caca);
            System.out.println(poop);
        }

        //HacerMovimiento();
    }

    // Esta función reinicia el tablero, poniendo cada ficha como estaría al principio de una partida
    public static void ReiniciarTablero()
    {
        /// VACIAR EL TABLERO
        for (int i = 0; i < tablero.length; i++)
        {
            Arrays.fill(tablero[i], " ");
        }

        ///  FICHAS NEGRAS
        // Torres
        tablero[0][0] = fichasNegras[2];
        tablero[0][7] = fichasNegras[2];
        // Caballos
        tablero[0][1] = fichasNegras[4];
        tablero[0][6] = fichasNegras[4];
        // Alfiles
        tablero[0][2] = fichasNegras[3];
        tablero[0][5] = fichasNegras[3];
        // Rey
        tablero[0][3] = fichasNegras[0];
        // Reina
        tablero[0][4] = fichasNegras[1];
        // Peones
        for (int fila = 0; fila < tablero.length; fila++)
        {
            tablero[1][fila] = fichasNegras[5];
        }

        /// FICHAS BLANCAS
        // Torres
        tablero[7][0] = fichasBlancas[2];
        tablero[7][7] = fichasBlancas[2];
        // Caballos
        tablero[7][1] = fichasBlancas[4];
        tablero[7][6] = fichasBlancas[4];
        // Alfiles
        tablero[7][2] = fichasBlancas[3];
        tablero[7][5] = fichasBlancas[3];
        // Rey
        tablero[7][3] = fichasBlancas[0];
        // Reina
        tablero[7][4] = fichasBlancas[1];
        // Peones
        for (int fila = 0; fila < tablero.length; fila++)
        {
            tablero[6][fila] = fichasBlancas[5];
        }
    }

    // Esta función imprime las coordenadas algebraicas
    public static void ImprimirCoordenadas()
    {
        for (int filas = 0; filas < tablero.length; filas++)
        {
            for (int columnas = 0; columnas < tablero[filas].length; columnas++)
            {
                tablero[filas][columnas] = letrasFilas[filas] + numeroColumnas[columnas];
                System.out.print(letrasFilas[filas] + numeroColumnas[columnas]);
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    // Esta función imprime las coordenadas del array
    public static void ImprimirCoordenadasArray()
    {
        for(int filas=0;filas<tablero.length;filas++)
        {
            for (int columnas = 0; columnas < tablero[filas].length; columnas++)
            {
                System.out.print(filas);
                System.out.print(columnas);
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    // Esta función imprime el tablero de ajedrez
    public static void ImprimirTablero()
    {
        for (int filas = 0; filas < tablero.length; filas++)
        {
            for (int columnas = 0; columnas < tablero[filas].length; columnas++)
            {
                if (columnas != tablero[filas].length - 1)
                {
                    System.out.print("| " + tablero[filas][columnas]);
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("| " + tablero[filas][columnas] + " |");
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    // Esta función busca que ficha hay en base a una casilla en algebraico, por ejemplo en la g5
    // Devuelve el número de la pieza especificado arriba
    public static int BuscarFichaAlgebraico(String casilla)
    {
        int numeroFicha = 33;

        String letraCasilla = casilla.substring(0, 1);
        int numeroCasilla = Integer.parseInt(casilla.substring(1, 2));

        int letraCasillaInt = 33;

        switch (letraCasilla)
        {
            case "a" -> letraCasillaInt = 0;
            case "b" -> letraCasillaInt = 1;
            case "c" -> letraCasillaInt = 2;
            case "d" -> letraCasillaInt = 3;
            case "e" -> letraCasillaInt = 4;
            case "f" -> letraCasillaInt = 5;
            case "g" -> letraCasillaInt = 6;
            case "h" -> letraCasillaInt = 7;
            default -> letraCasillaInt = 33;
        }

        int numeroCasillaInt = 33;

        switch (numeroCasilla)
        {
            case 8 -> numeroCasillaInt = 0;
            case 7 -> numeroCasillaInt = 1;
            case 6 -> numeroCasillaInt = 2;
            case 5 -> numeroCasillaInt = 3;
            case 4 -> numeroCasillaInt = 4;
            case 3 -> numeroCasillaInt = 5;
            case 2 -> numeroCasillaInt = 6;
            case 1 -> numeroCasillaInt = 7;
            default -> numeroCasillaInt = 33;
        }

        String ficha = tablero[letraCasillaInt][numeroCasillaInt];

        switch (ficha)
        {
            case " " -> numeroFicha = 0;
            case "♔" -> numeroFicha = 1;
            case "♚" -> numeroFicha = -1;
            case "♕" -> numeroFicha = 2;
            case "♛" -> numeroFicha = -2;
            case "♖" -> numeroFicha = 3;
            case "♜" -> numeroFicha = -3;
            case "♗" -> numeroFicha = 4;
            case "♝" -> numeroFicha = -4;
            case "♘" -> numeroFicha = 5;
            case "♞" -> numeroFicha = -5;
            case "♙" -> numeroFicha = 6;
            case "♟" -> numeroFicha = -6;
        }

        return numeroFicha;
    }

    // Esta función busca que ficha hay en base a las filas y columnas
    // Devuelve el número de la pieza especificado arriba
    public static int BuscarFicha(int fila, int columna)
    {
        String ficha = tablero[fila][columna];
        int numeroFicha = 143;

        switch (ficha)
        {
            case " " -> numeroFicha = 0;
            case "♔" -> numeroFicha = 1;
            case "♚" -> numeroFicha = -1;
            case "♕" -> numeroFicha = 2;
            case "♛" -> numeroFicha = -2;
            case "♖" -> numeroFicha = 3;
            case "♜" -> numeroFicha = -3;
            case "♗" -> numeroFicha = 4;
            case "♝" -> numeroFicha = -4;
            case "♘" -> numeroFicha = 5;
            case "♞" -> numeroFicha = -5;
            case "♙" -> numeroFicha = 6;
            case "♟" -> numeroFicha = -6;
        }

        return numeroFicha;
    }

    // Esta función hace los movimientos
    public static void HacerMovimiento()
    {
        //g6f6
        /// SEPARA LA CASILLA DE INICIO DE LA CASILLA DE FIN
        String casillaInicio = movimiento.substring(0, 2);
        String casillaDestino = movimiento.substring(2, 4);

        /// MIRA QUE PIEZA HAY EN LA CASILLA INICIAL
        int fichaAMover = BuscarFichaAlgebraico(casillaInicio);

        switch (fichaAMover)
        {
            case 1: // Rey blanco
            {

            }
            case -1: // Rey negro
            {

                break;
            }

            case 2: // Reina blanca
            {

            }
            case -2: // Reina negra
            {

                break;
            }
        }
    }

    // Esta función transforma el lenguaje algebraico a coordenadas en el array
    // Por ejemplo, la casilla a5. Recibe a y 5 y devuelve respectivamente 0 y 3
    public static void TransformarCoordenadas(String letra, int numero)
    {
        switch (letra)
        {
            case "a" -> fila = 0;
            case "b" -> fila = 1;
            case "c" -> fila = 2;
            case "d" -> fila = 3;
            case "e" -> fila = 4;
            case "f" -> fila = 5;
            case "g" -> fila = 6;
            case "h" -> fila = 7;
            default -> fila = 33;
        }

        switch (numero)
        {
            case 8 -> columna = 0;
            case 7 -> columna = 1;
            case 6 -> columna = 2;
            case 5 -> columna = 3;
            case 4 -> columna = 4;
            case 3 -> columna = 5;
            case 2 -> columna = 6;
            case 1 -> columna = 7;
            default -> columna = 33;
        }
    }
}
