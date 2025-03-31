package tercertrimestre.colecciones.votacionesdelegado;

import java.util.*;

public class VotacionesDelegado
{
    public static void main(String[] args)
    {
        VotacionesDelegado votacionesDelegado = new VotacionesDelegado();

        Map<Persona, Persona> votos;
        Map<Persona, Integer> resultados = new HashMap<>();

        Persona juan = new Persona("Juan", "Perez", 30, "123A");
        Persona manu = new Persona("Manu", "Gomez", 25, "456B");
        Persona enma = new Persona("Enma", "Lopez", 28, "789C");

        Persona luis = new Persona("Luis", "Martinez", 35, "234D");
        Persona ana = new Persona("Ana", "Fernandez", 27, "567E");
        Persona carla = new Persona("Carla", "Rodriguez", 32, "890F");
        Persona pedro = new Persona("Pedro", "Sanchez", 29, "345G");
        Persona sofia = new Persona("Sofia", "Diaz", 26, "678H");
        Persona diego = new Persona("Diego", "Morales", 31, "901I");
        Persona maria = new Persona("Maria", "Alvarez", 33, "112J");
        Persona pablo = new Persona("Pablo", "Torres", 30, "223K");
        Persona lucia = new Persona("Lucia", "Ramirez", 24, "334L");
        Persona esteban = new Persona("Esteban", "Ortega", 36, "445M");
        Persona valeria = new Persona("Valeria", "Jimenez", 28, "556N");
        Persona ricardo = new Persona("Ricardo", "Vega", 29, "667O");
        Persona fernanda = new Persona("Fernanda", "Mendoza", 27, "778P");
        Persona javier = new Persona("Javier", "Reyes", 34, "889Q");
        Persona monica = new Persona("Monica", "Castro", 32, "990R");
        Persona sebastian = new Persona("Sebastian", "Herrera", 26, "101S");
        Persona alejandra = new Persona("Alejandra", "Rios", 31, "212T");

        // Definimos a los candidatos
        List<Persona> candidatos;
        Persona[] arrayCandidatos = {juan, manu, enma};
        candidatos = votacionesDelegado.parseArraySet(arrayCandidatos);

        // Definimos a los votantes
        List<Persona> votantes;
        Persona[] arrayVotantes = {juan, manu, enma, luis, ana, carla, pedro, sofia, diego, maria, pablo, lucia, esteban, valeria, ricardo, fernanda, javier, monica, sebastian, alejandra};
        votantes = votacionesDelegado.parseArraySet(arrayVotantes);

        // Mostramos los candidatos
        System.out.println("== CANDIDATOS ==");
        votacionesDelegado.mostrarCandidatos(candidatos, false, resultados);
        System.out.println();

        // Creamos las entradas de cada candidato en el mapa
        votacionesDelegado.inicializarMapaResultados(arrayCandidatos, resultados);

        // Generamos los votos
        votos = votacionesDelegado.generarVotos(votantes, candidatos, resultados);

        // Mostrar los votos de cada persona.
        System.out.println("== VOTOS ==");
        votacionesDelegado.mostrarVotos(votantes, votos);
        System.out.println();

        // Mostramos los candidatos con resultados
        System.out.println("== RESULTADOS ==");
        votacionesDelegado.mostrarCandidatos(candidatos, true, resultados);
        System.out.println("Votos totales: " + arrayVotantes.length);
        System.out.println();
    }

    public void inicializarMapaResultados(Persona[] candidatos, Map<Persona, Integer> mapaResultados)
    {
        for (Persona candidato : candidatos)
        {
            mapaResultados.put(candidato, 0);
        }
    }

    public void mostrarVotos(List<Persona> votantes, Map<Persona, Persona> mapaVotos)
    {
        System.out.println(mapaVotos);
    }

    public List<Persona> parseArraySet(Persona[] array)
    {
        List<Persona> set = new ArrayList<>();
        Collections.addAll(set, array);
        return set;
    }

    public Map<Persona, Persona> generarVotos(List<Persona> votantes, List<Persona> candidatos, Map<Persona, Integer> mapaResultados)
    {
        Map<Persona, Persona> votosGenerados = new HashMap<>();

        for (Persona votante : votantes)
        {
            Persona candidatoElegido = elegirCandidatoRandom(candidatos);
            votosGenerados.put(votante, candidatoElegido);
            mapaResultados.put(candidatoElegido, mapaResultados.get(candidatoElegido) + 1);
        }

        return votosGenerados;
    }

    public Persona elegirCandidatoRandom(List<Persona> candidatos)
    {
        Persona[] a = new Persona[candidatos.size()];

        Iterator<Persona> iterator = candidatos.iterator();

        int i = 0;
        while (iterator.hasNext())
        {
            a[i] = iterator.next();
            i++;
        }

        int num = VotacionesDelegado.generarNumeroAleatorio(0, candidatos.size() - 1);
        return a[num];
    }

    public void mostrarCandidatos(List<Persona> candidatos, boolean incluirResultados, Map<Persona, Integer> mapaResultados)
    {
        for (Persona candidato : candidatos)
        {
            if (incluirResultados)
            {
                System.out.printf("%s | Votos: %d\n", candidato, mapaResultados.get(candidato));
            }
            else
            {
                System.out.println(candidato);
            }
        }
    }

    public static int generarNumeroAleatorio(int min, int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("El valor mínimo no puede ser mayor que el máximo.");
        }

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
