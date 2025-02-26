package segundotrimestre.personas;

public class Persona
{
    /// ATRIBUTOS
    private String dni;

    String nombre;
    String apellidos;
    int edad;

    final int mayoriaDeEdad = 18;
    final int edadJubilacion = 65;

    /// CONSTRUCTORES
    public Persona()
    {
        dni = " ";
        nombre = " ";
        apellidos = " ";
        edad = 0;
    }

    public Persona(String nombre, String apellidos, String dni, int edad)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }

    /// MÉTODOS
    public boolean esMayorDeEdad()
    {
        return edad >= mayoriaDeEdad;
    }

    public boolean esJubilado()
    {
        return edad >= edadJubilacion;
    }

    public void mostrarMayoriaDeEdad()
    {
        System.out.printf("%s %s con DNI %s ", nombre, apellidos, dni);
        if (esMayorDeEdad()) System.out.println("es mayor de edad.");
        else System.out.println("no es mayor de edad.");
    }

    public void mostrarInformacion()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
    }

    public int diferenciaEdad(Persona otraPersona)
    {
        return Math.abs(otraPersona.edad - this.edad);
    }

    public String getDni()
    {
        return dni;
    }
}
