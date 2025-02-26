package primertrimestre.ejerciciosavanzados;/*
    POSIBLES VICTORIAS
    (ignorando si gana un jugador u otro)

    | X | X | X |           | X |   |   |           | X |   |   |
    |   |   |   |           | X |   |   |           |   | X |   |
    |   |   |   |           | X |   |   |           |   |   | X |

    |   |   |   |           |   | X |   |           |   |   | X |
    | X | X | X |           |   | X |   |           |   | X |   |
    |   |   |   |           |   | X |   |           | X |   |   |

    |   |   |   |           |   |   | X |
    |   |   |   |           |   |   | X |
    | X | X | X |           |   |   | X |

 */

import java.util.Scanner;

public class TicTacToe
{
    String tablero[][] = new String[3][3];      // Crear un tablero 3x3

    int deQuienEsElTurno = 0;               // Jugador del cual es el turno (1 o 2)
    int alguienHaGanado = 0;                // ¿Qué jugador ha ganado?

    String letraTurno = "";                 // Cuál es la letra de cada jugador (X o O)

    int numeroTemporal = 0;                 // Número que recibe el programa
    boolean casillaValida = false;          // ¿Ha puesto una pieza bien?
    boolean tableroLleno = false;
    boolean quierenSeguirJugando = true;

    boolean coloresActivados = true;

    int victoriasJugador1 = 0;
    int victoriasJugador2 = 0;
    int empates = 0;

    public void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);   // Declarar el Scanner

        /* Valores en tablero
         * ' ' -> Vacío
         * 'X' -> Cruz
         * 'O' -> Círculo
         */

        /// Pruebas
        /*tablero[0][0] = "A";
        tablero[0][1] = "B";
        tablero[0][2] = "C";

        tablero[1][0] = "D";
        tablero[1][1] = "E";
        tablero[1][2] = "F";

        tablero[2][0] = "G";
        tablero[2][1] = "H";
        tablero[2][2] = "I";

        tablero[0][0] = "X";
        tablero[0][1] = "O";
        tablero[0][2] = "O";

        tablero[1][0] = "O";
        tablero[1][1] = "X";
        tablero[1][2] = "X";

        tablero[2][0] = "X";
        tablero[2][1] = " ";
        tablero[2][2] = "0";
*/


        /// ESCRIBIMOS LAS POSICIONES PARA QUE LOS JUGADORES LAS CONOZCAN
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| 1 | 2 | 3 |");

        System.out.println();

        /*while (quierenSeguirJugando)
        {*/
            System.out.println("SE VIENE PARTIDA ÉPICA DEL TRES EN RAYA");
            System.out.println("Jugador 1: X   |   Jugador 2: O");

            System.out.println();

            System.out.println("COMIENZA LA PARTIDA!");

            /// Rellenar el array con huecos en blanco
            for (int i = 0; i < tablero.length; i++)
            {
                for (int j = 0; j < tablero[i].length; j++)
                {
                    tablero[i][j] = " ";
                }
            }

            /// Escribe el tablero vacío al principio
            ImprimirTablero();

            while (alguienHaGanado == 0)
            {
                /// Asigna el turno al jugador que le toque
                if (deQuienEsElTurno == 0) { deQuienEsElTurno = 1; }
                else if (deQuienEsElTurno == 1) { deQuienEsElTurno = 2; }
                else { deQuienEsElTurno = 1; }

                /// Dice de quien es el turno
                System.out.print("TURNO DEL JUGADOR " + deQuienEsElTurno + ". Elige la casilla: ");

                while (!casillaValida)
                {
                    /// Recibe la casilla de la siguiente jugada
                    numeroTemporal = scanner.nextInt();

                    if (deQuienEsElTurno == 1) { letraTurno = "X"; }
                    else { letraTurno = "O"; }

                    /// Asgina la casilla
                    switch (numeroTemporal)
                    {
                        case 1:
                        {
                            if (tablero[2][0].equals(" "))
                            {
                                tablero[2][0] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 2:
                        {
                            if (tablero[2][1].equals(" "))
                            {
                                tablero[2][1] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 3:
                        {
                            if (tablero[2][2].equals(" "))
                            {
                                tablero[2][2] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 4:
                        {
                            if (tablero[1][0].equals(" "))
                            {
                                tablero[1][0] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 5:
                        {
                            if (tablero[1][1].equals(" "))
                            {
                                tablero[1][1] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 6:
                        {
                            if (tablero[1][2].equals(" "))
                            {
                                tablero[1][2] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 7:
                        {
                            if (tablero[0][0].equals(" "))
                            {
                                tablero[0][0] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 8:
                        {
                            if (tablero[0][1].equals(" "))
                            {
                                tablero[0][1] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                        case 9:
                        {
                            if (tablero[0][2].equals(" "))
                            {
                                tablero[0][2] = letraTurno;
                                casillaValida = true;
                            } else
                            {
                                System.out.print("¡Esa casilla ya está ocupada! Elige otra: ");
                            }
                            break;
                        }
                    }
                }

                casillaValida = false;

                /// Imprime el tablero en cada turno
                ImprimirTablero();

                /// Comprueba las victorias
                ComprobarVictorias("X", 1);
                ComprobarVictorias("O", 2);

                ComprobarEmpates();

                // Comprueba las victorias
                if (alguienHaGanado != 0)
                {
                    if (alguienHaGanado == 1) { victoriasJugador1++; System.out.println("¡Gana el jugador 1!"); }
                    else if (alguienHaGanado == 2) { victoriasJugador2++; System.out.println("¡Gana el jugador 2!"); }
                    else if ((alguienHaGanado == 3) && (tableroLleno)) { empates++; System.out.println("¡Empate!"); }

                    /*scanner.nextLine();

                    System.out.println();
                    System.out.println("Jugador 1: " + victoriasJugador1 + " | Jugador 2: " + victoriasJugador2 + " | Empates: " + empates);
                    System.out.println();
                    System.out.println("¿Queréis seguir jugando? (Si/No)");

                    String respuesta = "";
                    respuesta = scanner.nextLine();

                    if (respuesta.equalsIgnoreCase("si"))
                    {
                        quierenSeguirJugando = true;
                    }
                    else if (respuesta.equalsIgnoreCase("no"))
                    {
                        quierenSeguirJugando = false;
                        System.out.println("Okey, ¡chao!");
                        System.exit(0);
                    }*/
                }
            }
        //}
    }

    public void ImprimirTablero()
    {
        for (int i = 0; i < tablero.length; i++)
        {
            for (int j = 0; j < tablero[i].length; j++)
            {
                if (coloresActivados)
                {
                    if (j != tablero[i].length - 1)
                    {
                        if (tablero[i][j].equalsIgnoreCase("X"))
                        {
                            System.out.print("| " + ConsoleColors.BLUE + tablero[i][j] + ConsoleColors.RESET + " ");
                        }
                        else if (tablero[i][j].equalsIgnoreCase("O"))
                        {
                            System.out.print("| " + ConsoleColors.RED + tablero[i][j] + ConsoleColors.RESET + " ");
                        }
                        else
                        {
                            System.out.print("| " + tablero[i][j] + " ");
                        }
                    }
                    else
                    {
                        if (tablero[i][j].equalsIgnoreCase("X"))
                        {
                            System.out.print("| " + ConsoleColors.BLUE + tablero[i][j] + ConsoleColors.RESET + " |");
                        }
                        else if (tablero[i][j].equalsIgnoreCase("O"))
                        {
                            System.out.print("| " + ConsoleColors.RED + tablero[i][j] + ConsoleColors.RESET + " |");
                        }
                        else
                        {
                            System.out.print("| " + tablero[i][j] + " |");
                        }
                    }
                }
                else
                {
                    if (j != tablero[i].length - 1)
                    {
                        if (tablero[i][j].equalsIgnoreCase("X"))
                        {
                            System.out.print("| " + ConsoleColors.BLUE + tablero[i][j] + ConsoleColors.RESET + " ");
                        }
                        else if (tablero[i][j].equalsIgnoreCase("O"))
                        {
                            System.out.print("| " + ConsoleColors.RED + tablero[i][j] + ConsoleColors.RESET + " ");
                        }
                        else
                        {
                            System.out.print("| " + tablero[i][j] + " ");
                        }
                    }
                    else
                    {
                        if (tablero[i][j].equalsIgnoreCase("X"))
                        {
                            System.out.print("| " + ConsoleColors.BLUE + tablero[i][j] + ConsoleColors.RESET + " |");
                        }
                        else if (tablero[i][j].equalsIgnoreCase("O"))
                        {
                            System.out.print("| " + ConsoleColors.RED + tablero[i][j] + ConsoleColors.RESET + " |");
                        }
                        else
                        {
                            System.out.print("| " + tablero[i][j] + " |");
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ComprobarVictorias(String letra, int jugador)
    {
        for (int i = 0; i < tablero.length; i++)
        {
            // Verifica las victorias horizontales
            if (tablero[i][1].equals(letra))
            {
                if (tablero[i][0].equals(letra) && tablero[i][2].equals(letra)) { alguienHaGanado = jugador; break; }
            }
            // Verifica las victorias verticales
            else if (tablero[1][i].equals(letra))
            {
                if (tablero[0][i].equals(letra) && tablero[2][i].equals(letra)) { alguienHaGanado = jugador; break; }
            }
            // Verifica las victorias en diagonal mayor
            else if (tablero[0][0].equals(letra) && tablero[1][1].equals(letra) && tablero[2][2].equals(letra)) { alguienHaGanado = jugador; break; }
            // Verifica las victorias en diagonal menor
            else if (tablero[0][2].equals(letra) && tablero[1][1].equals(letra) && tablero[2][0].equals(letra)) { alguienHaGanado = jugador; break; }
        }
    }

    public void ComprobarEmpates()
    {
        tableroLleno = true;

        for (int i = 0; i < tablero.length; i++)
        {
            for (int j = 0; j < tablero[i].length; j++)
            {
                boolean haTerminadoDeComrpobar = false;

                if (tablero[i][j].equals(" ")) { tableroLleno = false; }

                if ((i == 2) && (j == 2)) { haTerminadoDeComrpobar = true; }

                if ((alguienHaGanado == 0) && (tableroLleno) && (haTerminadoDeComrpobar)) { alguienHaGanado = 3; break; }
            }
        }
    }

    public class ConsoleColors {

        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String BLUE = "\033[0;34m";    // BLUE
    }
}
