package segundotrimestre.spotify;

public class Spotify
{
    public static void main(String[] args)
    {
        Cancion myTime = new Cancion("My Time", 213, "JPop", 2018, true);
        Cancion myWay = new Cancion("My Way", 253, "Jazz", 1996, true);
        Cancion megalovania = new Cancion("Megalovania", 330, "Synth", 2015, false);
        Cancion megalovaniaSmash = new Cancion("Megalovania Remix", 330, "Synth", 2020, false);

        Playlist miPlaylist = new Playlist("Playlist increíble");
        Spotify.mostrarMenu();

        miPlaylist.mostrarCancionesPlaylist();

    }

    public static void mostrarMenu()
    {
        System.out.println("== BIENVENIDO A SPOTIFY ==");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Mostrar playlist");
        System.out.println("2. Añadir canción");
        System.out.println("3. Eliminar canción");
    }
}
