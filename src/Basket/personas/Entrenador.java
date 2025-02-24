package Basket.personas;

public class Entrenador extends Persona
{
    public int idFederacion;

    public Entrenador(int id, String nombre, String apellidos, int edad, int idFederacion)
    {
        super(id, nombre, apellidos, edad);

        this.idFederacion = idFederacion;
    }

    @Override
    public void mostrarDatos()
    {
        super.mostrarDatos();
        System.out.println("ID Federación: " + idFederacion);
    }

    public void dirigirEntrenamiento()
    {
        System.out.printf("El entrenador %s %s está dirigiendo el entrenamiento", this.nombre, this.apellidos);
    }

    public void dirigirPartido()
    {
        System.out.printf("El entrenador %s %s está dirigiendo el partido", this.nombre, this.apellidos);
    }
}
