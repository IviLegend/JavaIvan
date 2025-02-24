package Basket.personas;

public class Masajista extends Persona
{
    public String titulacion;
    public int anyosExp;

    public Masajista(int id, String nombre, String apellidos, int edad, String titulacion, int anyosExp)
    {
        super(id, nombre, apellidos, edad);

        this.titulacion = titulacion;
        this.anyosExp = anyosExp;
    }

    @Override
    public void mostrarDatos()
    {
        super.mostrarDatos();
        System.out.println("Titulación: " + titulacion);
        System.out.println("Años de experiencia: " + anyosExp);
    }

    public void darMasaje(Jugador jugadorMasajeado)
    {
        System.out.printf("%s %s está dando un masaje a %s %s", this.nombre, this.apellidos, jugadorMasajeado.nombre, jugadorMasajeado.apellidos);
    }
}
