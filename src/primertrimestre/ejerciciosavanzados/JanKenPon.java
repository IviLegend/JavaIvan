package primertrimestre.ejerciciosavanzados;

import java.util.Random;
import java.util.Scanner;

public class JanKenPon
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroCPU = 0;
        /*
         * 1 -> Piedra
         * 2 -> Papel
         * 3 -> Tijera
         */

        String opcionUsuario = "";
        String resultado = "";

        int rondas = 0;
        int victoriasJugador = 0;
        int victoriasCPU = 0;
        int empates = 0;

        System.out.println("Vamos a jugar al piedra papel o tijeras!!");

        System.out.println("¿Cuántas rondas quieres que juguemos?");
        rondas = scanner.nextInt();

        System.out.println("Genial, entonces jugaremos " + rondas + " rondas!!! Elige tu opción (yo no miro):");

        System.out.println("R -> Piedra");
        System.out.println("P -> Papel");
        System.out.println("S -> Tijeras");
        System.out.println("ELIGE TU OPCIÓN!!!!!!! >:D");

        while(rondas != 0)
        {
            numeroCPU = random.nextInt(3) + 1;
            boolean opcionValida = false;

            int numeroUsuario = 0;
            String opcionCPU = "";

            while (!opcionValida)
            {
                opcionUsuario = scanner.next();
                if (opcionUsuario.equalsIgnoreCase("R"))
                {
                    numeroUsuario = 1;
                    opcionValida = true;
                } else if (opcionUsuario.equalsIgnoreCase("P"))
                {
                    numeroUsuario = 2;
                    opcionValida = true;
                } else if (opcionUsuario.equalsIgnoreCase("S"))
                {
                    numeroUsuario = 3;
                    opcionValida = true;
                }
                else
                {
                    System.out.println("No me has dicho ningún número bueno melón, Dime una opción buena:");
                }
            }

            switch (numeroCPU)
            {
                case 1 -> opcionCPU = "PIEDRA";
                case 2 -> opcionCPU = "PAPEL";
                case 3 -> opcionCPU = "TIJERA";
            }

            System.out.println("LA CPU HA ELEGIDO " + opcionCPU + "!!!!");

            if (numeroCPU == numeroUsuario)
            {
                resultado = "¡EMPATE!";
            } else if (numeroUsuario == 1) // Piedra
            {
                if (numeroCPU == 2)
                {
                    resultado = "GANA LA CPU >:)";
                }
                if (numeroCPU == 3)
                {
                    resultado = "GANAS TÚ :O";
                }
            } else if (numeroUsuario == 2) // Papel
            {
                if (numeroCPU == 1)
                {
                    resultado = "GANAS TÚ :O";
                }
                if (numeroCPU == 3)
                {
                    resultado = "GANA LA CPU >:)";
                }
            } else if (numeroUsuario == 3) // Tijeras
            {
                if (numeroCPU == 1)
                {
                    resultado = "GANA LA CPU >:)";
                }
                if (numeroCPU == 2)
                {
                    resultado = "GANAS TÚ :O";
                }
            }

            if (resultado.equalsIgnoreCase("GANAS TÚ :O")) { victoriasJugador++; }
            else if (resultado.equalsIgnoreCase("GANA LA CPU >:)")) { victoriasCPU++; }
            else if (resultado.equalsIgnoreCase("¡EMPATE!")) { empates++; }

            System.out.println(resultado);
            System.out.println("Quedan " + rondas + " rondas, los resultados son los siguientes:");
            System.out.println("Puntos tuyos: " + victoriasJugador);
            System.out.println("Puntos CPU: " + victoriasCPU);
            System.out.println("Empates: " + empates);
            System.out.println("");
            System.out.println("ELIGE TU OPCIÓN (R/P/S)");

            rondas--;
            opcionValida = false;
        }
    }
}
