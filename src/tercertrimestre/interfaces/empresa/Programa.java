package tercertrimestre.interfaces.empresa;

public class Programa
{
    public static void main(String[] args)
    {
        Empresa empresa = new Empresa();

        Empleado juan = new Empleado("Juan", "0128391838D", 17000);

        juan.mostrarInformacion();
    }
}
