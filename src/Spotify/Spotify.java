package Spotify;

public class Spotify
{
    public static void main(String[] args)
    {
        Cancion myTime = new Cancion("My Time", 213, "JPop", 2018, true);
        Cancion myWay = new Cancion("My Way", 253, "Jazz", 1996, true);
        Cancion megalovania = new Cancion("Megalovania", 330, "Synth", 2015, false);

        Playlist miPlaylist = new Playlist("Playlist increíble");
        miPlaylist.agregarCancion(myTime);
        miPlaylist.agregarCancion(myWay);
        miPlaylist.agregarCancion(megalovania);
        miPlaylist.mostrarCancionesPlaylist();
    }
}
