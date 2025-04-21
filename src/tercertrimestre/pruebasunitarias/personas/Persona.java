package tercertrimestre.pruebasunitarias.personas;

public class Persona
{
    private int edad;

    public Persona(int edad)
    {
        if (edad < 0)
        {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }

    public boolean esMayorDeEdad()
    {
        return edad >= 18;
    }

    public boolean puedeJubilarse()
    {
        return edad >= 65;
    }
}