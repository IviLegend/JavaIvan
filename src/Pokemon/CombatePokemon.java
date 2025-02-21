package Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CombatePokemon
{
    public static Random random = new Random();

    public static Scanner scanner = new Scanner(System.in);

    public static String nombre;

    public static double[][] tablaDeTipos = new double[5][5];

    /*                                          ATACANTE
     *                          NORMAL     FUEGO      PLANTA       AGUA       ELECTRICO
     *            NORMAL          1          1          1            1            1
     *            FUEGO           1         0.5        0.5           2            1
     *  DEFENSOR  PLANTA          1          2         0.5          0.5          0.5
     *            AGUA            1         0.5         2           0.5           2
     *            ELECTRICO       1          1          1            1           0.5
     */

    public static Tipo[] listaTipos = {Tipo.NORMAL, Tipo.FUEGO, Tipo.PLANTA, Tipo.AGUA, Tipo.ELECTRICO};

    public static Ataque ataqueElegido;

    public static double efectividad;

    /**
     * @value
     * <ul>
     * <li>{@code 1} - Tu turno</li>
     * <li>{@code 2} - Turno rival</li>
     * </ul>
     */
    public static int turno = 1;

    /**
     * @value
     * <ul>
     * <li>{@code 0} - Nadie gana</li>
     * <li>{@code 1} - Ganas tú</li>
     * <li>{@code 2} - Ganas el rival</li>
     * </ul>
     */
    public static int ganador = 0;

    public static void main(String[] args)
    {
        tablaDeTipos[0][0] = 1;
        tablaDeTipos[0][1] = 1;
        tablaDeTipos[0][2] = 1;
        tablaDeTipos[0][3] = 1;
        tablaDeTipos[0][4] = 1;

        tablaDeTipos[1][0] = 1;
        tablaDeTipos[1][1] = 0.5;
        tablaDeTipos[1][2] = 0.5;
        tablaDeTipos[1][3] = 2;
        tablaDeTipos[1][4] = 1;

        tablaDeTipos[2][0] = 1;
        tablaDeTipos[2][1] = 2;
        tablaDeTipos[2][2] = 0.5;
        tablaDeTipos[2][3] = 0.5;
        tablaDeTipos[2][4] = 0.5;

        tablaDeTipos[3][0] = 1;
        tablaDeTipos[3][1] = 0.5;
        tablaDeTipos[3][2] = 2;
        tablaDeTipos[3][3] = 0.5;
        tablaDeTipos[3][4] = 2;

        tablaDeTipos[4][0] = 1;
        tablaDeTipos[4][1] = 1;
        tablaDeTipos[4][2] = 1;
        tablaDeTipos[4][3] = 1;
        tablaDeTipos[4][4] = 0.5;

        Ataque placaje = new Ataque("Placaje", ClaseAtaque.FISICO, Tipo.NORMAL, 40, 100, 35);
        Ataque latigoCepa = new Ataque("Látigo Cepa",  ClaseAtaque.FISICO, Tipo.PLANTA, 45, 100, 25);
        Ataque grunido = new Ataque("Gruñido", Tipo.NORMAL, 100, 40, 1, ClaseAtaque.ESPECIAL);
        Ataque drenadoras = new Ataque("Drenadoras", Tipo.PLANTA, 90, 10, 2, ClaseAtaque.ESPECIAL);
        Ataque aranazo = new Ataque("Arañazo", ClaseAtaque.FISICO, Tipo.NORMAL, 40, 100, 35);
        Ataque ascuas = new Ataque("Ascuas", ClaseAtaque.FISICO, Tipo.FUEGO, 40, 100, 25);
        Ataque pantallaDeHumo = new Ataque("Pantalla de Humo", Tipo.NORMAL, 100, 20, 5, ClaseAtaque.ESPECIAL);
        Ataque latigo = new Ataque("Látigo", Tipo.NORMAL, 100, 35, 3, ClaseAtaque.ESPECIAL);
        Ataque pistolaAgua = new Ataque("Pistola Agua", ClaseAtaque.FISICO, Tipo.AGUA, 40, 100, 25);
        Ataque refugio = new Ataque("Refugio", Tipo.AGUA, 100, 40, 4, ClaseAtaque.ESPECIAL);
        Ataque ataqueRapido = new Ataque("Ataque Rápido", ClaseAtaque.FISICO, Tipo.NORMAL, 40, 100, 30);
        Ataque impactrueno = new Ataque("Impactrueno", ClaseAtaque.FISICO, Tipo.ELECTRICO, 40, 100, 30);

        Pokemon bulbasaur = new Pokemon("Bulbasaur", Tipo.PLANTA,1, 45, 49, 49, 65, 45, placaje, grunido, latigoCepa, drenadoras);
        Pokemon charmander = new Pokemon("Charmander", Tipo.FUEGO, 1, 39, 52, 43, 50, 65, aranazo, grunido, ascuas, pantallaDeHumo);
        Pokemon squirtle = new Pokemon("Squirtle", Tipo.AGUA, 1, 44, 48, 65, 50, 43, placaje, latigo, pistolaAgua, refugio);
        Pokemon pikachu = new Pokemon("Pikachu", Tipo.ELECTRICO, 1, 35, 55, 40, 90, 50, ataqueRapido, latigo, impactrueno, grunido);

        Pokemon rowlet = new Pokemon("Rowlet", Tipo.PLANTA, 1, 40, 40, 40, 40, 40, placaje, drenadoras, latigoCepa, aranazo);

        Pokemon pokemonAtacante = null;
        Pokemon pokemonDefensor = null;

        ArrayList<Pokemon> listaPokemon = new ArrayList<>();

        listaPokemon.add(bulbasaur);
        listaPokemon.add(charmander);
        listaPokemon.add(squirtle);
        listaPokemon.add(pikachu);
        listaPokemon.add(1, rowlet);

        /// BIENVENIDA
        System.out.println("¡Hola entrenador!, dime tu nombre: ");
        nombre = scanner.nextLine();

        System.out.println("¡Encantado de conocerte " + nombre + "! Vamos a elegir un Pokémon para tí. ¡Escribe una de las opciones!");
        System.out.println(listaPokemon);

        boolean opcionValida = false;

        while (!opcionValida)
        {
            String respuesta = scanner.nextLine().toLowerCase().trim();

            switch (respuesta)
            {
                case "bulbasaur" -> pokemonAtacante = bulbasaur;
                case "rowlet" -> pokemonAtacante = rowlet;
                case "charmander" -> pokemonAtacante = charmander;
                case "squirtle" -> pokemonAtacante = squirtle;
                case "pikachu" -> pokemonAtacante = pikachu;
                default -> System.out.println("¡ELIGE UNA OPCIÓN VÁLIDA!");
            }

            if (pokemonAtacante != null)
                opcionValida = true;
        }

        System.out.println("Genial, has elegido a " + pokemonAtacante.nombre);

        /// EMPIEZA EL COMBATE

        String nombreRival = "Dominguero Paco";
        int numero = GenerarNumeroAleatorio(1, 4);

        switch (numero)
        {
            case 1 -> pokemonDefensor = bulbasaur;
            case 2 -> pokemonDefensor = charmander;
            case 3 -> pokemonDefensor = squirtle;
            case 4 -> pokemonDefensor = pikachu;
        }

        System.out.println("¡" + nombreRival + " te reta a un combate!");
        System.out.println(nombreRival + " saca a " + pokemonDefensor.nombre);

        // Elige el ataque

        if (pokemonAtacante.velocidad >= pokemonDefensor.velocidad)
        {
            turno = 1;
        }
        else turno = 2;

        while (ganador == 0)
        {
            if (turno == 1)
            {
                System.out.println("¡Elige tu ataque!");

                for (int i = 0; i < 4; i++)
                {
                    System.out.printf("%d. %s (%d/%d)", i + 1, pokemonAtacante.ataques[i].nombre, pokemonAtacante.ataques[i].PP, pokemonAtacante.ataques[i].PPMaximo);
                    System.out.println();
                }

                boolean ataqueValido = false;

                while (!ataqueValido)
                {
                    int numeroAtaque = scanner.nextInt();
                    ataqueElegido = pokemonAtacante.ataques[numeroAtaque-1];

                    if (ataqueElegido.PP <= 0)
                    {
                        System.out.println("¡No tienes PP!");
                        ataqueValido = false;
                    } else ataqueValido = true;
                }

                // Ver si ha acertado o no
                boolean haAcertado = HaAcertadoElAtaque(ataqueElegido.precision);

                if (haAcertado)
                {
                    if (ataqueElegido.claseAtaque == ClaseAtaque.FISICO)
                    {
                        int damage = CalcularDamage(pokemonAtacante, pokemonDefensor, ataqueElegido);

                        System.out.printf("%s usa %s contra el %s enemigo.", pokemonAtacante.nombre, ataqueElegido.nombre, pokemonDefensor.nombre);
                        System.out.println();

                        if (efectividad == 2)
                        {
                            System.out.println("¡Es supereficaz!");
                        } else if (efectividad == 0.5)
                        {
                            System.out.println("No es muy eficaz...");
                        }

                        pokemonDefensor.vida -= Math.round(damage);
                        if (pokemonDefensor.vida < 0) pokemonDefensor.vida = 0;
                        System.out.printf("¡%s pierde %d HP! Ahora %s tiene %d HP", pokemonDefensor.nombre, Math.round(damage), pokemonDefensor.nombre, pokemonDefensor.vida);
                        System.out.println();
                    } else
                    {
                        System.out.printf("%s usa %s", pokemonAtacante.nombre, ataqueElegido.nombre);
                        System.out.println();

                        switch (ataqueElegido.idEspecial)
                        {
                            case 1 -> Grunido(pokemonDefensor);
                            case 2 -> Drenadoras(pokemonDefensor, pokemonAtacante);
                            case 3 -> Latigo(pokemonDefensor);
                            case 4 -> Refugio(pokemonAtacante);
                            case 5 -> PantallaDeHumo(pokemonAtacante);
                        }
                    }
                } else
                {
                    System.out.println("¡" + pokemonAtacante.nombre + " falló!");
                }

                ataqueElegido.PP--;
                ganador = VerificarVictoria(pokemonDefensor, turno);
                turno = 2;
            }
            else if (turno == 2)
            {
                int numeroRandom = GenerarNumeroAleatorio(1, 4);

                ataqueElegido = pokemonDefensor.ataques[numeroRandom-1];

                double damage = CalcularDamage(pokemonDefensor, pokemonAtacante, ataqueElegido);

                pokemonAtacante.vida -= damage;

                ganador = VerificarVictoria(pokemonAtacante, turno);
                turno = 1;
            }
        }

        if (ganador == 1) System.out.println("¡" + nombre + " gana!");
        else System.out.println("¡" + nombreRival + " gana!");
    }

    public static int GenerarNumeroAleatorio(int min, int max)
    {
        return random.nextInt(max-min) + min;
    }

    public static int CalcularDamage(Pokemon pokemonQueAtaca, Pokemon pokemonQueDefiende, Ataque ataqueAtacante)
    {
        double damage = 0;

        // Calcular la variación
        int variacion = GenerarNumeroAleatorio(85, 100);

        // Calcular la bonificiación
        double bonificacion = 1;
        if (ataqueElegido.tipo == pokemonQueAtaca.tipo)
        {
            bonificacion = 1.5;
        }

        // Calcular la efectividad

        // Sacar el índice

        int indexTipoDefensor = 0;

        for (int i = 0; i < listaTipos.length; i++)
        {
            if (listaTipos[i] == pokemonQueDefiende.tipo)
            {
                indexTipoDefensor = i;
                break;
            }
        }

        int indexTipoAtacante = 0;

        for (int i = 0; i < listaTipos.length; i++)
        {
            if (listaTipos[i] == ataqueElegido.tipo)
            {
                indexTipoAtacante = i;
                break;
            }
        }

        efectividad = tablaDeTipos[indexTipoDefensor][indexTipoAtacante];

        damage = 0.01 * bonificacion * efectividad * variacion * ((((0.2 * pokemonQueAtaca.nivel + 1) * pokemonQueAtaca.ataque * ataqueAtacante.potencia) / (25 * pokemonQueDefiende.defensa)) + 2);

        int damageInt = (int)damage;

        return damageInt;
    }

    public static boolean HaAcertadoElAtaque(int precision)
    {
        int numeroRandom = GenerarNumeroAleatorio(0, 100);

        if (numeroRandom > precision)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static int VerificarVictoria(Pokemon pokemonMuertoONo, int turnoAtacante)
    {
        if (pokemonMuertoONo.vida <= 0)
        {
            System.out.println("¡" + pokemonMuertoONo.nombre + " se ha debilitado!");
            if (turnoAtacante == 1) return 1;
            else if (turnoAtacante== 2) return 2;
        }
        return 0;
    }

    public static void Grunido(Pokemon pokemonAfectado)
    {
        pokemonAfectado.defensa -= 2;
        if (pokemonAfectado.defensa <= 0)
        {
            pokemonAfectado.defensa = 1;
        }
    }

    public static void Drenadoras(Pokemon pokemonAfectado, Pokemon pokemonQueAtaca)
    {
        pokemonAfectado.vida -= 3;
        pokemonQueAtaca.vida += 3;
        if (pokemonQueAtaca.vida > pokemonQueAtaca.vidaMaxima)
        {
            pokemonQueAtaca.vida = pokemonQueAtaca.vidaMaxima;
        }
    }

    public static void Latigo(Pokemon pokemonAfectado)
    {
        pokemonAfectado.defensa -= 2;
        if (pokemonAfectado.defensa <= 0)
        {
            pokemonAfectado.defensa = 1;
        }
    }

    public static void Refugio(Pokemon pokemonQueSeRefugia)
    {
        pokemonQueSeRefugia.defensa++;
    }

    public static void PantallaDeHumo(Pokemon pokemonAfectado)
    {
        int numeroRandom = GenerarNumeroAleatorio(1, 4);

        pokemonAfectado.ataques[numeroRandom - 1].precision -= 5;
    }

    /**
     * Espera la cantidad de milisegundos especificada.
     *
     * @param milisegundos La cantidad de milisegundos que va a esperar.
     * @see <a href="https://stackoverflow.com/questions/15528140/java-thread-sleep-and-interrupted-exception">Stack Overflow</a>
     */
    public static void Esperar(int milisegundos)
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
