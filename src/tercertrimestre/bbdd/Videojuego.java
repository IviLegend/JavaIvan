package tercertrimestre.bbdd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Videojuego
{
    public int id;
    public String nombre;
    public double rating;
    public LocalDateTime fecha_lanzamiento;

    public Videojuego(int id, String nombre, double rating, LocalDateTime fecha_lanzamiento)
    {
        this.id = id;
        this.nombre = nombre;
        this.rating = rating;
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    @Override
    public String toString()
    {
        return String.format("%d. %s (%.2f)", id, nombre, rating);
    }

    public String getFecha()
    {
        String fechaFormateada = "No lanzado";

        if (fecha_lanzamiento != null)
        {
            fechaFormateada = fecha_lanzamiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy | hh:mm:ss"));
        }

        return fechaFormateada;
    }
}
