package tercertrimestre.bbdd;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * CRead en esta clase, un programa utilizando PreparedStatement, en el que:
 * - 1º: mostremos todas los videojuegos al usuario, con todos sus datos
 * - 2º: le pedimos al usuario qué ID de videojuego quiere actualizar.
 * - 3º: le pedimos al usuario qué nueva puntuación le vamos a dar, y qué valor de lanzado
 * - 4º: Lanzamos la actualización utilizando PreparedStatement. Tenemos que mostrar cuántas filas se han actualizado
 * - 5º: Mostramos al usuario el listado de videojuegos actualizado
 * - EXTRA: repetir esto en un bucle
 */
public class ProgramaCompletoVideojuegos
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/Programacion";
        String user = "alumno";
        String password = "alumno";

        try
        {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Videojuego");

            ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double rating = resultSet.getDouble("rating");
                boolean lanzado = resultSet.getBoolean("lanzado");
                LocalDateTime fecha_lanzamiento = (LocalDateTime) resultSet.getObject("fecha_lanzamiento");

                Videojuego videojuego = new Videojuego(id, nombre, rating, lanzado, fecha_lanzamiento);
                listaVideojuegos.add(videojuego);
            }

            listaVideojuegos.forEach(System.out::println);
        }
        catch (SQLException e)
        {
            System.err.printf("ERROR: Error al operar con la base de datos: %s", e);
        }
    }
}
