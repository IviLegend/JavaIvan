package tercertrimestre.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsercionVideojuego
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

            while (true)
            {
                agregarVideojuego(conexion);
            }
        }
        catch (SQLException e)
        {
            System.err.printf("Error al operar con la BBDD: %s\n", e);
        }
    }

    public static void agregarVideojuego(Connection conexion)
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            Statement sentencia = conexion.createStatement();

            System.out.print("Dime el nombre del videojuego: ");
            String nombre = scanner.nextLine();

            System.out.print("Dime la nota del videojuego: ");
            double rating = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("¿Se ha lanzado ya? (1/2)");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int lanzadoInt = scanner.nextInt();
            boolean lanzado = false;

            String fecha = "";
            if (lanzadoInt == 1) { lanzado = true; fecha = "now()"; }
            else if (lanzadoInt == 2) { lanzado = false; fecha = "null"; }

            String ratingString = String.valueOf(rating);
            ratingString = ratingString.replace(",", ".");
            sentencia.executeUpdate(String.format("INSERT INTO Videojuego(nombre, rating, lanzado, fecha_lanzamiento) VALUES ('%s', %s, %b, %s)", nombre, ratingString, lanzado, fecha));
        }
        catch (SQLException e)
        {
            System.err.printf("Error al operar con la BBDD: %s\n", e);
        }
    }
}
