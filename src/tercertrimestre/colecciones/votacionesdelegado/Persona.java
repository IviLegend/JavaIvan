package tercertrimestre.colecciones.votacionesdelegado;

import java.util.Objects;

public class Persona implements Comparable
{
    /// ATRIBUTOS
    private String nombre;
    private String DNI;

    /// CONSTRUCTOR
    public Persona(String nombre, String DNI)
    {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    /// MÉTODOS
    // Equals y HashCode
    @Override
    public boolean equals(Object object)
    {
        if (object == null || getClass() != object.getClass()) return false;
        Persona persona = (Persona) object;
        return Objects.equals(DNI, persona.DNI);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(DNI);
    }

    // ToString
    @Override
    public String toString()
    {
        return String.format("%s", nombre);
    }

    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
