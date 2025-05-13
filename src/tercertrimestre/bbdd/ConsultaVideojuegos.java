package tercertrimestre.bbdd;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConsultaVideojuegos
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/Programacion";
        String user = "alumno";
        String password = "alumno";

        String consulta = "SELECT * FROM Videojuego";

        ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

        try
        {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            Statement sentencia = conexion.createStatement();
            ResultSet resultSet = sentencia.executeQuery(consulta);

            while(resultSet.next())
            {
                Videojuego videojuego = getVideojuego(resultSet);
                listaVideojuegos.add(videojuego);
                System.out.println(videojuego);
            }

            double totalNota = 0;
            double totalJuegosLanzados = 0;

            for (Videojuego videojuego : listaVideojuegos)
            {
                if (videojuego.rating != 0)
                {
                    totalJuegosLanzados++;
                    totalNota += videojuego.rating;
                }
            }

            System.out.printf("Media: %.2f", (totalNota / totalJuegosLanzados));
        }
        catch (SQLException e)
        {
            System.err.printf("Error al operar con la BBDD: %s\n", e);
        }
    }

    private static Videojuego getVideojuego(ResultSet resultSet) throws SQLException
    {
        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        double rating = resultSet.getDouble("rating");
        LocalDateTime fecha = resultSet.getObject("fecha_lanzamiento", LocalDateTime.class);
        return new Videojuego(id, nombre, rating, fecha);
    }
}
