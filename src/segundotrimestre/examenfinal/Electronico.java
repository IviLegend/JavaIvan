package segundotrimestre.examenfinal;

public class Electronico extends Producto
{
    /// ATRIBUTOS
    private String marca;
    private String modelo;
    private int mesesGarantia;

    /// CONSTRUCTORES
    public Electronico(String nombre, double precio, int stock, String marca, String modelo, int mesesGarantia)
    {
        super(nombre, precio, stock);

        this.marca = marca;
        this.modelo = modelo;
        this.mesesGarantia = mesesGarantia;
    }

    /// MÉTODOS
    // MÉTODOS PROPIOS
    @Override
    public double calcularPrecioFinal(double precioInicial, double porcentajeDescuento)
    {
        if (mesesGarantia < 6) { porcentajeDescuento = 10.0; }
        else { porcentajeDescuento = 5.0; }
        return super.calcularPrecioFinal(precioInicial, porcentajeDescuento);
    }

    // TOSTRING
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nMarca: %s | Modelo: %s | Garantía: %d meses", marca, modelo, mesesGarantia);
    }

    // GETTERS Y SETTERS
    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public int getMesesGarantia()
    {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia)
    {
        this.mesesGarantia = mesesGarantia;
    }
}
