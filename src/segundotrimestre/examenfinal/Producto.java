package segundotrimestre.examenfinal;

import java.util.Objects;

public abstract class Producto
{
    /// ATRIBUTOS
    private String nombre;
    private double precio;
    private int stock;

    /// CONSTRUCTORES
    public Producto(String nombre, double precio, int stock)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /// MÉTODOS
    // MÉTODOS PROPIOS
    public double calcularPrecioFinal(double porcentajeDescuento)
    {
        return (precio - (precio * (porcentajeDescuento / 100)));
    }

    // GETTERS Y SETTERS
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    // TOSTRING
    @Override
    public String toString()
    {
        return String.format("%s | [Stock: %d]", nombre, stock);
    }

    // EQUALS Y HASHCODE
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(nombre);
    }
}
