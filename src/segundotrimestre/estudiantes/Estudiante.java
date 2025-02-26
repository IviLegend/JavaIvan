package segundotrimestre.estudiantes;

public class Estudiante extends Persona
{
    /// ATRIBUTOS
    int numMatricula;

    /// CONSTRUCTORES
    public Estudiante(String nombre, String apellido, String dni, int edad, int numMatricula)
    {
        super(nombre, apellido, dni, edad);
        this.numMatricula = numMatricula;
    }

    /// MÉTODOS
    @Override
    public String toString()
    {
        return String.format("%s %s", nombre, apellido);
    }
}
