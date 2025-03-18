package tercertrimestre.interfaces.biblioteca;

public interface Prestable
{
    void prestar();

    void devolver();

    default boolean prestado() { return true; }
}
