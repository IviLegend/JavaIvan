package tercertrimestre.colecciones.juegocartas;

import java.util.*;

public class Principal
{
    public static void main(String[] args)
    {
        Baraja baraja = new Baraja();
        Set<Carta> manoJugador = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            int respuesta = scanner.nextInt();

            switch (respuesta)
            {
                case 1:
                {
                    if (!baraja.barajaCartas.isEmpty())
                    {
                        manoJugador.add(baraja.barajaCartas.getFirst());
                        System.out.printf("Has robado %s.\n", baraja.barajaCartas.getFirst());
                        System.out.printf("Quedan %d cartas en la baraja.\n", baraja.barajaCartas.size() - 1);
                        baraja.barajaCartas.removeFirst();
                    }
                    else
                    {
                        System.out.println("No quedan cartas");
                    }
                    break;
                }

                case 2:
                {
                    Iterator iterator = manoJugador.iterator();

                    while (iterator.hasNext())
                    {
                        System.out.println(iterator.next());
                    }

                    break;
                }

                case 3:
                {
                    System.out.println(baraja.barajaCartas.size());
                    break;
                }

                case 4:
                {
                    System.out.println("Dime la carta que quieres descartar: ");
                    break;
                }
            }
        }
    }
}
