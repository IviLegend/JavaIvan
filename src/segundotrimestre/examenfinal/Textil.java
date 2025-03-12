package segundotrimestre.examenfinal;

public class Textil extends Producto
{
    /// ATRIBUTOS
    private String talla;
    private String material;

    /// CONSTRUCTORES
    public Textil(String nombre, double precio, int stock, String talla, String material)
    {
        super(nombre, precio, stock);

        this.talla = talla;
        this.material = material;
    }

    /// MÉTODOS
    // MÉTODOS PROPIOS
    @Override
    public double calcularPrecioFinal(double porcentajeDescuento)
    {
        if (Utilidades.quitarTildes(material).equalsIgnoreCase("algodon")) { porcentajeDescuento = 2.5; }
        return super.calcularPrecioFinal(porcentajeDescuento);
    }

    // TOSTRING
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nTalla: %s | Material: %s", talla, material);
    }

    // GETTERS Y SETTERS
    public String getTalla()
    {
        return talla;
    }

    public void setTalla(String talla)
    {
        this.talla = talla;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }
}
