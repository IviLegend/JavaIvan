package segundotrimestre.estudiantes;

import java.util.Objects;

public abstract class Persona
{
    /// ATRIBUTOS
    String nombre;
    String apellido;
    String dni;
    int edad;

    /// CONSTRUCTORES
    public Persona()
    {

    }

    public Persona(String nombre, String apellido, String dni, int edad)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    /// MÉTODOS
    @Override
    public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(dni);
    }
}
