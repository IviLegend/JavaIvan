package tercertrimestre.interfaces.biblioteca;

import java.util.Objects;

public abstract class Publicacion
{
    /// ATRIBUTOS
    private String codigo;
    private String titulo;
    private int anyoPublicacion;

    /// CONSTRUCTORES
    public Publicacion(String codigo, String titulo, int anyoPublicacion)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anyoPublicacion = anyoPublicacion;
    }

    /// MÉTODOS
    // ToString
    @Override
    public String toString()
    {
        return String.format("(%d) %s - %d", codigo, titulo, anyoPublicacion);
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object object)
    {
        if (object == null) return false;
        Publicacion that = (Publicacion) object;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(codigo);
    }

    // Getters y Setters
    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public int getAnyoPublicacion()
    {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion)
    {
        this.anyoPublicacion = anyoPublicacion;
    }
}
