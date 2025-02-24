package Spotify;

import java.util.ArrayList;

public class Playlist
{
    String nombre;
    ArrayList<Cancion> listaCanciones;

    public Playlist()
    {

    }

    public Playlist(String nombre)
    {
        this.nombre = nombre;
        this.listaCanciones = new ArrayList<>();
    }

    public void mostrarCancionesPlaylist()
    {
        System.out.printf("%s | (%.2f)\n", nombre, obtenerDuracionPlayList());
        for (int i = 0; i < listaCanciones.size(); i++)
        {
            System.out.printf("%d. %s\n", i+1, listaCanciones.get(i));
        }
    }

    public boolean agregarCancion(Cancion nueva)
    {
        listaCanciones.add(nueva);
        return true;
    }

    public boolean eliminarCancion(String tituloCancion)
    {
        for (int i = 0; i < listaCanciones.size(); i++)
        {
            if (listaCanciones.get(i).getNombre().equalsIgnoreCase(tituloCancion))
            {
                listaCanciones.remove(listaCanciones.get(i));
                return true;
            }
        }
        return false;
    }

    public double obtenerDuracionPlayList()
    {
        double duracionTotal = 0.0;

        for (Cancion listaCanciones : listaCanciones)
        {
            duracionTotal += listaCanciones.obtenerMinutos();
        }

        return duracionTotal;
    }
}
