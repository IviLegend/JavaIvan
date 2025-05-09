package tercertrimestre.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaAccesoBD
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
        }
        catch (SQLException e)
        {
            System.err.printf("Error al operar con la BBDD: %s\n", e);
        }
    }
}
