package segundotrimestre.articulos;

public class Articulo
{
    String nombre;
    double precio;
    IVA tipoIVA;
    int iva;
    int cuantosQuedan;

    boolean articuloValido = true;

    public Articulo()
    {

    }

    public Articulo(String nombre, double precio, int cuantosQuedan, IVA tipoIVA)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoIVA = tipoIVA;
        this.cuantosQuedan = cuantosQuedan;

        asignarIVA();

        if (precio <= 0)
        {
            System.err.printf("ERROR: El precio de %s no es válido", nombre);
            System.out.println();
            articuloValido = false;
        }

        if (iva < 0)
        {
            System.err.printf("ERROR: El IVA de %s no es válido", nombre);
            System.out.println();
            articuloValido = false;
        }

        if (cuantosQuedan < 0)
        {
            System.err.printf("ERROR: El stock de %s no es válido", nombre);
            System.out.println();
            articuloValido = false;
        }
    }

    public static void mostrarListaArticulos(Articulo[] lista)
    {
        for (Articulo articulo : lista)
        {
            if (articulo.articuloValido)
            {
                articulo.mostrarInfoArticulo();
                System.out.println();
            }
        }
    }

    private void asignarIVA()
    {
        switch(tipoIVA)
        {
            case GENERAL -> iva = 21;
            case REDUCIDO -> iva = 10;
            case SUPER_REDUCIDO -> iva = 4;
        }
    }

    private double calcularPVP()
    {
        return (precio + (precio * ((double) iva / 100)));
    }

    public static boolean buscarArticulo(String palabra, Articulo[] lista)
    {
        boolean hayOcurrencias = false;

        for (int pos = 0; pos < lista.length; pos++)
        {
            if (lista[pos] != null)
            {
                if (lista[pos].nombre.toLowerCase().contains(palabra.toLowerCase()))
                {
                    lista[pos].mostrarInfoArticulo();
                    System.out.println();
                    hayOcurrencias = true;
                }
            }
        }

        return hayOcurrencias;
    }

    public void mostrarInfoArticulo()
    {
        String porcentaje = "%";
        System.out.printf("%s (%d) - Precio: %.2f€ - IVA: %d%s - PVP: %.2f€", nombre, cuantosQuedan, precio, iva, porcentaje, calcularPVP());
    }
}
