package segundotrimestre.personas;

public class ProgramaPersonas
{
    public static void main(String[] args)
    {
        Persona ivan = new Persona("Iván", "Gómez", "123456789A", 18);
        ivan.mostrarMayoriaDeEdad();

        Persona viejo = new Persona("Isabel", "II", "123864756F", 180);

        Persona[] listaPersonas = {ivan, viejo};

        System.out.println(listaPersonas[1].esJubilado());

        System.out.println(ivan.getDni());

        System.out.println(ivan.diferenciaEdad(viejo));

    }
}
