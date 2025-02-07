package EJERCICIO_DAMBANK;

public class Persona
{
    private String nombre;
    private String apellido;
    private String dni;

    public Persona()
    {

    }

    public Persona(String nombre, String apellido, String dni)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public static boolean dniValido(String dni)
    {
        String dniRegex = "^[0-9]{8}[A-HJ-NP-TV-Z]$";
        return dni.matches(dniRegex);
    }

    public String getDni()
    {
        return dni;
    }

    public String toString()
    {
        return nombre + " " + apellido;
    }
}
