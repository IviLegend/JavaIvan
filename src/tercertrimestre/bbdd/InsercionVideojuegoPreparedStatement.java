package tercertrimestre.bbdd;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InsercionVideojuegoPreparedStatement
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

            Scanner scanner = new Scanner(System.in);
            System.out.print("Dime el nombre del videojuego: ");
            String nombre = scanner.nextLine();
            System.out.println("¿Se ha lanzado ya?: ");
            System.out.println("1. Sí ");
            System.out.println("2. No ");
            int respuesta = scanner.nextInt();
            boolean lanzado = respuesta == 1;
            double rating = 0.0d;
            if (lanzado)
            {
                System.out.print("Dime la nota del videojuego: ");
                rating = scanner.nextDouble();
            }

            PreparedStatement preparedStatement = conexion.prepareStatement("INSERT INTO Videojuego(nombre, rating, lanzado, fecha_lanzamiento) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, nombre);
            preparedStatement.setDouble(2, rating);
            preparedStatement.setBoolean(3, lanzado);
            if (lanzado) { preparedStatement.setObject(4, LocalDateTime.now()); }
            else { preparedStatement.setObject(4, null); }

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.printf("Error al operar con la BBDD: %s\n", e);
        }
    }
}
