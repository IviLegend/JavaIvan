package tercertrimestre.controldeerrores;

public class InvalidDNIException extends RuntimeException
{
    public InvalidDNIException(String message)
    {
        super(message);
    }
}
