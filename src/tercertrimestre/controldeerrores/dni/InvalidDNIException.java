package tercertrimestre.controldeerrores.dni;

public class InvalidDNIException extends RuntimeException
{
    public InvalidDNIException(String message)
    {
        super(message);
    }
}
