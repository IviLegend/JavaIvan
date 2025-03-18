package tercertrimestre.interfaces.biblioteca;

public class Revista extends Publicacion
{
    /// ATRIBUTOS
    private int numero;

    /// CONSTRUCTORES
    public Revista(String codigo, String titulo, int anyoPublicacion, int numero)
    {
        super(codigo, titulo, anyoPublicacion);
        this.numero = numero;
    }

    /// MÉTODOS
    // ToString
    @Override
    public String toString()
    {
        return String.format("%s | Número: %d", super.toString(), numero);
    }

    // Getters y Setters
    public int getNumero()
    {
        return numero;
    }

    public void setNumero(int numero)
    {
        this.numero = numero;
    }
}
