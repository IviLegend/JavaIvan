package tercertrimestre.interfaces.biblioteca;

import segundotrimestre.examenfinal.Utilidades;

public class Libro extends Publicacion implements Prestable
{
    /// ATRIBUTOS
    private boolean prestado;

    /// CONSTRUCTORES
    public Libro(String codigo, String titulo, int anyoPublicacion)
    {
        super(codigo, titulo, anyoPublicacion);
        this.prestado = false;
    }

    /// MÉTODOS
    // Métodos propios
    @Override
    public void prestar()
    {
        prestado = true;
    }

    @Override
    public void devolver()
    {
        prestado = false;
    }

    // ToString
    @Override
    public String toString()
    {
        return String.format("%s | Prestado: %s", super.toString(), Utilidades.convertirBooleanAString(prestado));
    }

    // Getters y Setters
    public boolean isPrestado()
    {
        return prestado;
    }

    public void setPrestado(boolean prestado)
    {
        this.prestado = prestado;
    }
}
