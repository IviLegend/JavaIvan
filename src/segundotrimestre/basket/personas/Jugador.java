package segundotrimestre.basket.personas;

public class Jugador extends Persona
{
    public int dorsal;
    public String demarcacion;

    public Jugador(int id, String nombre, String apellidos, int edad, int dorsal, String demarcacion)
    {
        super(id, nombre, apellidos, edad);

        this.dorsal = dorsal;
        this.demarcacion = demarcacion;
    }

    @Override
    public void mostrarDatos()
    {
        super.mostrarDatos();
        System.out.println("Dorsal: " + dorsal);
        System.out.println("Demarcación: " + demarcacion);
    }

    public void jugarPartido()
    {
        System.out.printf("%s %s está jugando un partido", this.nombre, this.apellidos);
    }

    public void entrenar()
    {
        System.out.printf("%s %s está entrenando...", this.nombre, this.apellidos);
    }
}
