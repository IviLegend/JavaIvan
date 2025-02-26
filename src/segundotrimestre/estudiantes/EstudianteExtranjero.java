package segundotrimestre.estudiantes;

public class EstudianteExtranjero extends Estudiante
{
    /// ATRIBUTOS
    String nacionalidad;

    /// CONSTRUCTORES
    public EstudianteExtranjero(String nombre, String apellido, String dni, int edad, int numMatricula, String nacionalidad)
    {
        super(nombre, apellido, dni, edad, numMatricula);
        this.nacionalidad = nacionalidad;
    }
}
