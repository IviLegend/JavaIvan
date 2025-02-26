package primertrimestre.ejerciciosavanzados;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* TODO - Tarea Principal
    o | Llenar el tablero en blanco.
    o | Poner un @ en el medio que será el jugador.
    o | Pedir al usuario a donde se quiere mover.
    o | Mover al jugador.
    o | Que no se pueda salir del mapa.
    o | Sistema PAC-MAN

   TODO - Opcional
    o | Sistema de puntuación
    o | Generar puntos.
    o | Al llegar a x puntos ganas.
    o | Los puntos no se generan en la pos del jugador.
    o | Tamaño de mapa variable
    o | Personalización de jugador
    o | Refactor de MoverJugador()
 */

public class ElMapa
{
    /// OBJETOS
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    ///  VARIABLES DE PUNTUACIÓN
    int puntos = 0;
    int puntosParaGanar = 10;

    ///  VARIABLES DE JUEGO
    final int tamaño = 5;     // Tamaño del mapa
    String[][] mapa = new String[tamaño][tamaño];

    String simboloJugador = "@";         // Símbolo que usa el jugador
    String simboloPuntos = "x";          // Símbolo para los puntos

    boolean sistemaPACMAN = true;
    boolean activarColores = false;

    /// VARIABLES DE POSICIÓN
    //int posFila = (int)(tamaño / 2);      // Posición del jugador en las filas
    int posFila = 0;
    int posColumna = (int)(tamaño / 2);   // Posción del jugador en las columnas

    boolean nuevaPosicionValida = false;
    boolean moverJugador = true;

    /// OTRAS VARIABLES
    String respuesta = "";

    public void main(String[] args)
    {
        if (simboloJugador.equalsIgnoreCase(simboloPuntos)) { simboloPuntos = "o"; }

        System.out.println();
        System.out.println("Bienvenido jugador, ¡tu objetivo será alcanzar los " + puntosParaGanar + " puntos!");

        VaciarMapa();
        mapa[posFila][posColumna] = simboloJugador;
        GenerarPunto();
        ImprimirMapa();

        System.out.print("Indica con WASD a donde quieres moverte (también puedes decir SALIR para terminar antes el juego): ");

        while (true)
        {
            while(!nuevaPosicionValida)
            {
                respuesta = scanner.nextLine();
                respuesta = respuesta.trim();
                CalcularPosicionJugador();
                CalcularSiguientePosicion();
            }
            ImprimirMapa();
            ComprobarVictoria();
            nuevaPosicionValida = false;

            System.out.println();
            System.out.print("Indica la siguiente casilla: ");
        }
    }
    public void VaciarMapa()
    {
        for (int fila = 0; fila < mapa.length; fila++)
        {
            Arrays.fill(mapa[fila], " ");
        }
    }

    public void ImprimirMapa()
    {
        for (int fila = 0; fila < mapa.length; fila++)
        {
            for (int columna = 0; columna < mapa[fila].length; columna++)
            {
                if (columna != mapa[fila].length - 1)
                {
                    if (!activarColores)
                    {
                        System.out.print("| " + mapa[fila][columna] + " ");
                    }
                    else
                    {
                        if (mapa[fila][columna].equalsIgnoreCase(simboloPuntos))
                        {
                            System.out.print("| " + ConsoleColors.BLUE + mapa[fila][columna] + ConsoleColors.RESET + " ");
                        }
                        else
                        {
                            System.out.print("| " + mapa[fila][columna] + " ");
                        }
                    }
                }
                else
                {
                    if (!activarColores)
                    {
                        System.out.print("| " + mapa[fila][columna] + " |");
                    }
                    else
                    {
                        if (mapa[fila][columna].equalsIgnoreCase(simboloPuntos))
                        {
                            System.out.print("| " + ConsoleColors.BLUE + mapa[fila][columna] + ConsoleColors.RESET + " |");
                        }
                        else
                        {
                            System.out.print("| " + mapa[fila][columna] + " |");
                        }
                    }
                }
            }

            System.out.println();
        }
    }

    public void CalcularPosicionJugador()
    {
        for (int fila = 0; fila < mapa.length; fila++)
        {
            for (int columna = 0; columna < mapa[fila].length; columna++)
            {
                if (mapa[fila][columna].equals(simboloJugador))
                {
                    posFila = fila;
                    posColumna = columna;
                }
            }
        }
    }

    public void CalcularSiguientePosicion()
    {
        int nuevaFila = -1;
        int nuevaColumna = -1;

        moverJugador = true;

        if (respuesta.equalsIgnoreCase("W"))    /// ARRIBA
        {
            if ((posFila - 1) > -1)
            {
                nuevaFila = posFila - 1;
                nuevaColumna = posColumna;
            }
            else
            {
                if (sistemaPACMAN)
                {
                    nuevaFila = mapa.length - 1;
                    nuevaColumna = posColumna;
                }
                else { ErrorDeMovimiento("arriba"); }
            }
        }
        else if (respuesta.equalsIgnoreCase("S"))  ///  ABAJO
        {
            if ((posFila + 1) < mapa[posColumna].length)
            {
                nuevaFila = posFila + 1;
                nuevaColumna = posColumna;
            }
            else
            {
                if (sistemaPACMAN)
                {
                    nuevaFila = 0;
                    nuevaColumna = posColumna;
                }
                else { ErrorDeMovimiento("abajo"); }
            }
        }
        else if (respuesta.equalsIgnoreCase("A"))   /// IZQUIERDA
        {
            if ((posColumna) > 0)
            {
                nuevaFila = posFila;
                nuevaColumna = posColumna - 1;
            }
            else
            {
                if (sistemaPACMAN)
                {
                    nuevaFila = posFila;
                    nuevaColumna = mapa.length - 1;
                }
                else { ErrorDeMovimiento("a la izquierda"); }
            }
        }
        else if (respuesta.equalsIgnoreCase("D"))   /// DERECHA
        {
            if ((posColumna + 1) < mapa[posFila].length)
            {
                nuevaFila = posFila;
                nuevaColumna = posColumna + 1;
            }
            else
            {
                if (sistemaPACMAN)
                {
                    nuevaFila = posFila;
                    nuevaColumna = 0;

                }
                else { ErrorDeMovimiento("a la derecha"); }
            }
        }
        else if (respuesta.equalsIgnoreCase("SALIR"))   /// SALIR
        {
            System.out.println("¡Okey, adios!");
            System.exit(0);
        }
        else /// CUALQUIER OTRA COSA
        {
            System.out.print("Dime una dirección de movimiento válida: ");
        }

        if (moverJugador) { MoverAlJugador(nuevaFila, nuevaColumna); }
    }

    public void MoverAlJugador(int nuevaFila, int nuevaColumna)
    {
        mapa[posFila][posColumna] = " ";

        if (mapa[nuevaFila][nuevaColumna].equalsIgnoreCase(simboloPuntos)) /// VERIFICA SI HA COGIDO UN PUNTO
        {
            puntos++;
            mapa[nuevaFila][nuevaColumna] = simboloJugador;
            GenerarPunto();
            System.out.println();
            System.out.println(ConsoleColors.BLUE + "+1 PUNTO" + ConsoleColors.RESET + ". Total puntos: " + puntos);
        }
        else { mapa[nuevaFila][nuevaColumna] = simboloJugador; }   /// SI NO SIMPLEMENTE SE MUEVE

        nuevaPosicionValida = true;
    }

    public void GenerarPunto()
    {
        boolean puntoGenerado = false;

        int posicionAleatoriaX = random.nextInt(tamaño);
        int posicionAleatoriaY = random.nextInt(tamaño);

        while(!puntoGenerado)
        {
            if (mapa[posicionAleatoriaX][posicionAleatoriaY].equals(simboloJugador))
            {
                posicionAleatoriaX = random.nextInt(tamaño);
                posicionAleatoriaY = random.nextInt(tamaño);
            }
            else
            {
                mapa[posicionAleatoriaX][posicionAleatoriaY] = simboloPuntos;
                puntoGenerado = true;
            }
        }
    }

    public void ErrorDeMovimiento(String direccionIncorrecta)
    {
        System.out.println();
        System.out.print("¡No puedes ir " + direccionIncorrecta + "! Indica otra casilla: ");
        respuesta = scanner.nextLine();
        CalcularSiguientePosicion();

        moverJugador = false;
    }

    public void ComprobarVictoria()
    {
        if (puntos >= puntosParaGanar)
        {
            System.out.println("¡Has alcanzado los " + puntosParaGanar + " puntos! Fin de la partida");
            System.exit(0);
        }
    }

    public class ConsoleColors
    {
        // Reset
        public static final String RESET = "\033[0m"; // Resetea el color

        // Colores
        public static final String BLUE = "\033[0;34m"; // Azul
    }
}
