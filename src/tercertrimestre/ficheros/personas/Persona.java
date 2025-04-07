package tercertrimestre.ficheros.personas;

public class Persona implements Comparable
{
    /// ATRIBUTOS
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;

    /// CONSTRUCTORES
    public Persona()
    {

    }

    public Persona(String nombre, String apellidos, int edad, String dni)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
    }

    /// MÉTODOS
    // Métodos propios
    public String toCsv()
    {
        return String.format("%s,%s,%d,%s", nombre, apellidos, edad, dni);
    }

    // toString


    @Override
    public String toString()
    {
        return String.format("%s %s, edad: %d, dni: %s", nombre, apellidos, edad, dni);
    }

    // Getters y Setters
    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

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

    // compareTo
    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
