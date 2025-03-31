package tercertrimestre.colecciones.votacionesdelegado;

import java.util.Objects;

public class Persona implements Comparable
{
    /// ATRIBUTOS
    private String nombre;
    private String apellidos;
    private int edad;
    private String DNI;

    /// CONSTRUCTOR
    public Persona(String nombre, String apellidos, int edad, String DNI)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
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
        return String.format("%s %s", nombre, apellidos);
    }

    // CompareTo
    @Override
    public int compareTo(Object otro)
    {
        Persona otraPersona = (Persona)otro;

        return otraPersona.compareTo(((Persona) otro).getApellidos());
    }

    // Getters y Setters
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getDNI()
    {
        return DNI;
    }

    public void setDNI(String DNI)
    {
        this.DNI = DNI;
    }
}
