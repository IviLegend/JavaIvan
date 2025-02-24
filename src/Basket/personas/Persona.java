package Basket.personas;

public class Persona
{
    protected int id;
    protected String nombre;
    protected String apellidos;
    protected int edad;

    public Persona()
    {

    }

    public Persona(int id, String nombre, String apellidos, int edad)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public void mostrarDatos()
    {
        System.out.println("== DATOS ==");
        System.out.println("Nombre: " + this);
        System.out.println("Edad: " + this.edad);
        System.out.println("Función: " + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
    }

    public void concentrarse()
    {
        System.out.printf("%s %s está concentrado\n", this.nombre, this.apellidos);
    }

    public void viajar(String pais)
    {
        System.out.printf("%s %s ha viajado a %s\n", this.nombre, this.apellidos, pais);
    }

    public String toString()
    {
        return nombre + " " + apellidos;
    }
}
