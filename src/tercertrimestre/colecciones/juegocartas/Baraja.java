package tercertrimestre.colecciones.juegocartas;

import java.util.*;

public class Baraja
{
    /// ATRIBUTOS
    public List<Carta> barajaCartas;

    /// CONSTRUCTORES
    public Baraja()
    {
        barajaCartas = new ArrayList<>();
        rellenarBaraja(barajaCartas);
        Collections.shuffle(barajaCartas);
    }

    /// MÉTODOS
    public void rellenarBaraja(List<Carta> baraja)
    {
        for (int palo = 0; palo < Palo.values().length; palo++)
        {
            for (int carta = 0; carta < Carta.valores.length; carta++)
            {
                baraja.add(new Carta(Palo.values()[palo], Carta.valores[carta]));
            }
        }
    }

    public void mostrarBaraja()
    {
        for (Carta barajaCarta : barajaCartas)
        {
            System.out.println(barajaCarta);
        }
    }
}
