package tercertrimestre.controldeerrores;

public class Persona
{
    private String dni;

    public Persona(String dni) throws Exception
    {
        if (dni == null)
        {
            throw new Exception();
        }
        this.dni = dni;
    }
}
