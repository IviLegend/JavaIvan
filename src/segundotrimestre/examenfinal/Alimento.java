package segundotrimestre.examenfinal;

public class Alimento extends Producto
{
    /// ATRIBUTOS
    private int nivelFrescura;
    private boolean necesitaRefrigeracion;

    /// CONSTRUCTORES
    public Alimento(String nombre, double precio, int stock, int nivelFrescura, boolean necesitaRefrigeracion)
    {
        super(nombre, precio, stock);

        this.nivelFrescura = nivelFrescura;
        this.necesitaRefrigeracion = necesitaRefrigeracion;
    }

    /// MÉTODOS
    // MÉTODOS PROPIOS
    @Override
    public double calcularPrecioFinal(double precioInicial, double porcentajeDescuento)
    {
        if (nivelFrescura <= 3) { porcentajeDescuento = 20.0; }
        return super.calcularPrecioFinal(precioInicial, porcentajeDescuento);
    }

    // TOSTRING
    @Override
    public String toString()
    {
        return super.toString() + String.format("\nNivel frescura: %d | Necesita refrigeración: %s", nivelFrescura, Utilidades.convertirBooleanAString(necesitaRefrigeracion));
    }

    // GETTERS Y SETTERS
    public int getNivelFrescura()
    {
        return nivelFrescura;
    }

    public void setNivelFrescura(int nivelFrescura)
    {
        this.nivelFrescura = nivelFrescura;
    }

    public boolean isNecesitaRefrigeracion()
    {
        return necesitaRefrigeracion;
    }

    public void setNecesitaRefrigeracion(boolean necesitaRefrigeracion)
    {
        this.necesitaRefrigeracion = necesitaRefrigeracion;
    }
}
