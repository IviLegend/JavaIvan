package segundotrimestre.spotify;

import java.util.Objects;

public class Cancion
{
    /// ATRIBUTOS
    private String nombre;
    private int numSegundos;
    private String genero;
    private int anyoCreacion;
    private boolean tieneLetra;

    /// CONSTRUCTORES
    public Cancion()
    {

    }

    public Cancion(String nombre, int numSegundos)
    {
        this.nombre = nombre;
        this.numSegundos = numSegundos;
    }

    public Cancion(String nombre, int numSegundos, String genero, int anyoCreacion, boolean tieneLetra)
    {
        this.nombre = nombre;
        this.numSegundos = numSegundos;
        this.genero = genero;
        this.anyoCreacion = anyoCreacion;
        this.tieneLetra = tieneLetra;
    }

    /// MÉTODOS
    public int obtenerMinutos()
    {
        return (int)Math.floor((double)numSegundos / 60);
    }

    public int obtenerSegundos()
    {
        return (numSegundos - (obtenerMinutos()*60));
    }

    /// GETTER Y SETTER
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getNumSegundos()
    {
        return numSegundos;
    }

    public void setNumSegundos(int numSegundos)
    {
        this.numSegundos = numSegundos;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public int getAnyoCreacion()
    {
        return anyoCreacion;
    }

    public void setAnyoCreacion(int anyoCreacion)
    {
        this.anyoCreacion = anyoCreacion;
    }

    public boolean isTieneLetra()
    {
        return tieneLetra;
    }

    public void setTieneLetra(boolean tieneLetra)
    {
        this.tieneLetra = tieneLetra;
    }

    public String toString()
    {
        return String.format("%s (%d:%d)", nombre, obtenerMinutos(), obtenerSegundos());
    }

    @Override
    public boolean equals(Object obj)
    {
        if ((obj == null) || (getClass() != obj.getClass()))
        {
            return false;
        }

        Cancion cancion = (Cancion) obj;
        return Objects.equals(nombre, cancion.nombre);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(nombre);
    }
}
