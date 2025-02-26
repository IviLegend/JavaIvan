package segundotrimestre.basket;

import segundotrimestre.basket.personas.Entrenador;
import segundotrimestre.basket.personas.Jugador;
import segundotrimestre.basket.personas.Masajista;
import segundotrimestre.basket.personas.Persona;
import java.util.ArrayList;

public class Basket
{
    public static void main(String[] args)
    {
        ArrayList<Persona> equipo = new ArrayList<>();

        Entrenador entrenador = new Entrenador(1, "Paco", "Pérez", 40, 1);
        Masajista masajista = new Masajista(2, "Giliberto", "Muñoz", 68, "URJC", 15);
        Jugador lebron = new Jugador(3, "Lebron", "James", 40, 30, "Pívot");
        Jugador stephen = new Jugador(4, "Stephen", "Carry", 30, 25, "Alero");

        equipo.add(entrenador);
        equipo.add(masajista);
        equipo.add(lebron);
        equipo.add(stephen);

        mostrarEquipo(equipo);
    }

    /**
     * Muestra los datos de un equipo
     * @param equipo El equipo del que se mostrarán los datos
     */
    public static void mostrarEquipo(ArrayList<Persona> equipo)
    {
        for (Persona persona : equipo)
        {
            persona.mostrarDatos();
            System.out.println();
        }
    }
}
