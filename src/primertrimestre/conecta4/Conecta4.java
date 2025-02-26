package primertrimestre.conecta4;

import java.util.Random;
import java.util.Scanner;

public class Conecta4
{
    public static int filasTablero = 6;
    public static int columnasTablero = 7;

    /**
     * Este es el tablero de juego, el que se va a mostrar y el que
     * almacena las fichas
     */
    public static String[][] tablero = new String[filasTablero][columnasTablero];

    /**
     * Los movimientos que se han hecho a lo lago de la partida
     */
    public static int movimientos = 0;

    /**
     * La cantidad máxima de movimientos posibles.
     * Si los movimientos son los máximos, entonces ha habido un empate
     */
    public static int movimientosMaximos = filasTablero * columnasTablero;

    /**
     * Las fichas de cada jugador.
     */
    public static String[] fichasJugadores = {"x", "o"};
    
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Cuantas fichas hay que conectar para ganar.
     */
    public static final int fichasParaGanar = 4;

    /**
     * La columna elegida para jugar. Por defecto {@code -1}.
     */
    public static int columnaElegida = -1;

    /**
     * De que jugador es el turno
     */
    public static int turno = 0;

    public static String espacioEnBlanco = " ";

    /**
     * Verifica quien ha ganado
     * @value
     * <ul>
     *     <li>{@code -2}  - Ha habido un empate </li>
     *     <li>{@code -1} - Nadie ha ganado pero la partida no ha acabado.</li>
     *     <li>{@code 0}  - Ha ganado el jugador.</li>
     *     <li>{@code 1}  - Ha ganado la IA.</li>
     * </ul>
     */
    public static int ganador = -1;

    public static void main(String[] args)
    {
        mostrarIntroduccion();

        rellenarTablero(tablero, espacioEnBlanco);
        imprimirTablero(tablero);

        // Mientras nadie haya ganado...
        while(ganador == -1)
        {
            // Turno del jugador
            if (turno == 0)
            {
                System.out.print("¡Tu turno! Escribe la columna en la que quieras jugar: ");
                columnaElegida = humanoElegirColumna();
                hacerMovimiento(0, columnaElegida);
                imprimirTablero(tablero);
            }
            // Turno de la máquina
            else if (turno == 1)
            {
                System.out.println("La IA malvada está pensando cómo destruirte...");
                columnaElegida = iaElegircolumna();
                hacerMovimiento(1, columnaElegida);
                esperar(1250);
                imprimirTablero(tablero);
            }

            // Comprueba la victoria para el jugador que acabe de hacer su movimiento
            ganador = comprobarVictoria(turno);

            // Y luego cambia el turno
            if (turno == 0) { turno = 1; }
            else if (turno == 1) { turno = 0; }
        }

        // Muestra los mensajes de victoria correspondientes.
        if (ganador == 0) { System.out.println("¡TU GANAS!"); }
        else if (ganador == 1) { System.out.println("¡LA IA MALVADA TE HA DERROTADO!"); }
        else if (ganador == -2) { System.out.println("¡EMPATE, NADIE HA GANADO!"); }
        System.out.println("** RESUMEN DE LA PARTIDA **");
        System.out.printf("Movimientos totales: %d", movimientos);
    }

    private static int humanoElegirColumna()
    {
        int columnaElegidaHumano = -1;
        boolean movimientoValido = false;

        // Verifica que la columna elegida está dentro de los límites y que tiene al menos una posición
        while(!movimientoValido)
        {
            boolean columnaEnRango = true;
            boolean columnaLlena;
            columnaElegidaHumano = scanner.nextInt();
            // Ajusta la respuesta para que encaje con los arrays
            columnaElegidaHumano--;

            // Verifica primero que la columna está dentro de los límites
            if ((columnaElegidaHumano + 1) > columnasTablero)
            {
                System.err.printf("¡La columna %d está fuera de rango! Elige una columna válida: ", columnaElegidaHumano + 1);
                columnaEnRango = false;
            }

            // Y verifica ya después si la columna ya válida tiene al menos un hueco
            if (columnaEnRango)
            {
                columnaLlena = columnaLlena(columnaElegidaHumano);
                if (columnaLlena)
                {
                    System.err.printf("¡La columna %d está llena! Elige una columna válida: ", columnaElegidaHumano + 1);
                }
                else
                {
                    movimientoValido = true;
                }
            }
        }

        return columnaElegidaHumano;
    }

    /**
     * Rellena todas las posiciones del tablero con un caracter en concreto.
     * @param tableroParaRellenar El tablero que se va a rellenar.
     * @param caracter El caracter con el que se va a rellenar el tablero.
     */
    public static void rellenarTablero(String[][] tableroParaRellenar, String caracter)
    {
        // Recorre el tablero
        for (int fila = 0; fila < tableroParaRellenar.length; fila++)
        {
            for (int columna = 0; columna < tableroParaRellenar[fila].length; columna++)
            {
                // Y asigna el caracter que queramos a cada casilla
                tableroParaRellenar[fila][columna] = caracter;
            }
        }
    }

    /**
     * Imprime el tablero
     * @param tableroParaImprimir el tablero que se va a imprimir
     */
    public static void imprimirTablero(String[][] tableroParaImprimir)
    {
        /// IMPRIME EL NÚMERO DE LAS COLUMNAS
        for (int columnas = 1; columnas <= columnasTablero; columnas++)
        {
            System.out.printf("  %d ", columnas);
        }

        System.out.println();

        /// IMPRIME EL TABLERO EN SÍ
        for (int fila = 0; fila < tableroParaImprimir.length; fila++)
        {
            for (int columna = 0; columna < tableroParaImprimir[fila].length; columna++)
            {
                // Si es la última columna, que ponga la barra de cierre
                if (columna == (columnasTablero - 1))
                {
                    System.out.printf("| %s |", tableroParaImprimir[fila][columna]);
                }
                else // Si no, que no la ponga
                {
                    System.out.printf("| %s ",  tableroParaImprimir[fila][columna]);
                }
            }

            System.out.println();
        }
    }

    /**
     * Procesa el movimiento
     *
     * @param jugador El jugador que va a jugar:
     *         <ul>
     *          <li>{@code 0} - Jugador</li>
     *          <li>{@code 1} - IA malvada</li>
     *        </ul>
     * @param columnaAJugar La columna en la que se va a depositar la ficha.
     *
     */
    public static void hacerMovimiento(int jugador, int columnaAJugar)
    {
        // Primero vemos quién está jugando, y en función de eso asignamos la ficha correspondiente
        String ficha = fichasJugadores[jugador];

        // Le decimos que, hipotéticamente, la primera fila disponible sería la última.
        int primeraFilaDisponible = filasTablero;

        for (int fila = 0; fila < filasTablero; fila++)
        {
            // Si ve que esa fila está disponible, entonces sale del bucle
            if (tablero[primeraFilaDisponible - 1][columnaAJugar].equals(espacioEnBlanco))
            {
                break;
            }
            else
            {
                // Si no que revise la anterior.
                primeraFilaDisponible--;
            }
        }

        // Cuando ya haya encontrado la fila, que reemplace el espacio en blanco por la ficha.
        tablero[primeraFilaDisponible - 1][columnaAJugar] = ficha;

        // Y suma un movimiento.
        movimientos++;
    }

    /**
     * Comprueba si alguien ha ganado.
     *
     * @param jugador El nº de jugador que va a jugar.
     * @return
     * <ul>
     * <li>{@code -2} - Ha habido un empate</li>
     * <li>{@code -1} - No ha ganado nadie pero no ha acabado la partida</li>
     * <li>{@code 0} - Ha ganado el jugador</li>
     * <li>{@code 1} - Ha ganado la IA</li>
     * </ul>
     */
    public static int comprobarVictoria(int jugador)
    {
        int ganador = -1; // Por defecto -1 para que no haya ganado nadie
        int fichasSeguidasEncontradas = 0;

        /// VERIFICAR VICTORIAS EN HORIZONTAL
        // Si aún no se ha encontrado ganador en verificaciones anteriores, que busque las fichas iguales a la derecha
        if (ganador == -1) { fichasSeguidasEncontradas = buscarFichasIguales(1, 0, jugador); }
        if (fichasSeguidasEncontradas >= fichasParaGanar) { ganador = jugador; }

        /// VERIFICAR VICTORIAS EN VERTICAL
        // Si aún no se ha encontrado ganador en verificaciones anteriores, que busque las fichas iguales hacia abajo
        if (ganador == -1) { fichasSeguidasEncontradas = buscarFichasIguales(0, -1, jugador); }
        if (fichasSeguidasEncontradas >= fichasParaGanar) { ganador = jugador; }

        /// VERIFICAR EMPATES
        // Y si el tablero está lleno y después de verificar todas las posibilidades aún no ha ganado nadie, se declara un empate.
        if ((movimientos == movimientosMaximos) && (ganador == -1))
        {
            ganador = -2;
        }

        return ganador;
    }

    /**
     * Esta función busca en el tablero cuantas fichas hay de un mismo tipo desplazandose la
     * cantidad de casillas que se le indique siguiendo las coordenadas cartesianas (x, y).
     * @param x La dirección en el eje x que nos vamos a mover para buscar fichas iguales:
     *          <ul>
     *          <li>{@code -1} Izquierda</li>
     *          <li>{@code 1} Derecha</li>
     *          </ul>
     * @param y La dirección en el eje y que nos vamos a mover para buscar fichas iguales:
     *          <ul>
     *          <li>{@code -1} Abajo</li>
     *          <li>{@code 1} Arriba</li>
     *          </ul>
     * @param jugador El nº de jugador del cuál vamos a buscar la ficha.
     * @return El número máximo de fichas iguales seguidas que se han encontrado.
     */
    private static int buscarFichasIguales(int x, int y, int jugador)
    {
        // Ajustamos los valores por si acaso
        x = (int)Math.signum(x);
        y = (int)Math.signum(y);

        int maxFichasSeguidas = 0;
        String ficha = recibirFichaJugador(jugador); // Cogemos la ficha del jugador

        // Recorre el tablero
        for (int fila = 0; fila < tablero.length; fila++)
        {
            for (int columna = 0; columna < tablero[fila].length; columna++)
            {
                // El número de fichas seguidas que ha encontrado
                // Lo declaramos aquí para evitar que se acumulen las fichas cuando vamos a verificar
                int fichasSeguidas = 0;

                // Si encuentra una ficha...
                if ((tablero[fila][columna].equals(ficha)))
                {
                    try // Que intente hacer la revisión
                    {
                        // Vamos a revisar las casillas hasta el número necesario para ganar
                        for (int contadorFichasIguales = 0; contadorFichasIguales < fichasParaGanar; contadorFichasIguales++) {
                            // Comprobamos las fichas en base a las coordenadas especificadas (empezando por la ficha que acabamos de encontrar)
                            if (tablero[fila + (y * contadorFichasIguales)][columna + (x * contadorFichasIguales)].equalsIgnoreCase(ficha)) // Si encuentra una ficha
                            {
                                fichasSeguidas++; // Suma 1 a fichasSeguidas.
                            }
                            else
                            {
                                break; // Si no, que termine el bucle.
                            }
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e) // Si se sale del tablero...
                    {
                        break; // ...que termine el bucle
                    }
                }

                if (fichasSeguidas > maxFichasSeguidas) // Si ha encontrado más coincidencias que en una de las iteraciones anteriores
                {
                    maxFichasSeguidas = fichasSeguidas; // Que actualice el máximo que ha encontrado
                }
            }
        }

        return maxFichasSeguidas;
    }

    /**
     * Recibe el nº de un jugador y devuelve la ficha con la que juega.
     * @param jugador El nº del jugador.
     * @return El String que representa la ficha del jugador especificado.
     */
    private static String recibirFichaJugador(int jugador)
    {
        return fichasJugadores[jugador];
    }

    /**
     * Comprueba si la columna que le especifiques está llena o no.
     * @param columnaParaVerificar La columna de juego que se va a verificar
     * @return <ul>
     *             <li>{@code true} - Si está llena</li>
     *             <li>{@code false} - Si no está llena</li>
     *         </ul>
     */
    public static boolean columnaLlena(int columnaParaVerificar)
    {
        return !tablero[0][columnaParaVerificar].equals(espacioEnBlanco);
    }

    /**
     * Mira si una casilla en concreto está ocupada o no.
     * @param fila La fila del array
     * @param columna La columna del array
     * @return {@code true} si está ocupada, y {@code false} si está vacia
     */
    public static boolean casillaOcupada(int fila, int columna)
    {
        return !(tablero[fila][columna].equals(espacioEnBlanco));
    }

    /**
     * La IA elige una columna en la que jugar con un algoritmo super <strike>cutre</strike> sofisticado
     *
     * @return La columna en la que va a insertar la ficha
     */
    public static int iaElegircolumna()
    {
        Random random = new Random();

        int columnaElegidaIA = -1;
        boolean columnaValida = false;

        while (!columnaValida)
        {
            // Genera una columna aleatoria dentro del rango
            columnaElegidaIA = random.nextInt(columnasTablero)+1;
            // Ajusta la columna
            columnaElegidaIA--;
            // Y mira a ver si está llena
            boolean estaLlena = columnaLlena(columnaElegidaIA);

            // Si no está llena, entonces podemos seguir
            if (!estaLlena) columnaValida = true;
        }

        return columnaElegidaIA;
    }

    /**
     * Muestra la introducción del juego.
     */
    public static void mostrarIntroduccion()
    {
        System.out.println("*** CONECTA 4 ***");
        System.out.println("¡Bienvenido al Conecta 4! Tu objetivo en este juego será");
        System.out.println("derrotar a una IA en el clásico juego de Conecta 4.\n");

        System.out.println("** ¿Cómo se juega? **");
        System.out.printf("Para ganar tienes que alinear %d fichas seguidas y evitar que\n", fichasParaGanar);
        System.out.println("la IA logre este mismo objetivo. Para elegir la columna en la");
        System.out.println("que quieres jugar, deberás escribir el número de esa columna.\n");

        System.out.println("¡QUE EMPIECE LA PARTIDA!");
    }

    /**
     * Espera la cantidad de milisegundos especificada.
     *
     * @param milisegundos La cantidad de milisegundos que va a esperar.
     * @see <a href="https://stackoverflow.com/questions/15528140/java-thread-sleep-and-interrupted-exception">Stack Overflow</a>
     */
    public static void esperar(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
