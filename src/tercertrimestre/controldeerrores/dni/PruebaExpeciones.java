package tercertrimestre.controldeerrores.dni;

public class PruebaExpeciones
{
    public static void main(String[] args)
    {
        try
        {
            Persona persona = new Persona("A");
            System.out.println(persona);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
