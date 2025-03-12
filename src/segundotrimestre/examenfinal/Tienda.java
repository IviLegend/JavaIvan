package segundotrimestre.examenfinal;

import java.util.ArrayList;

public class Tienda
{
    /// ATRIBUTOS
    public static final double PORCENTAJE_DESCUENTO_BASE = 2.0;
    private ArrayList<Producto> catalogo;

    /// CONSTRUCTORES
    public Tienda()
    {
        catalogo = new ArrayList<>();
    }

    /// MÉTODOS
    // MÉTODOS PROPIOS
    public void cargarDatosDePrueba()
    {
        // Electrónicos
        Electronico smartphone = new Electronico("Smartphone", 500.0, 10, "Samsung", "S21", 4);
        Electronico laptop = new Electronico("Laptop", 1200.0, 5, "Dell", "XPS15", 12);

        // Textil
        Textil camiseta = new Textil("Camiseta", 20.0, 50, "M", "Algodón");
        Textil jeans = new Textil("Jeans", 40.0, 30, "L", "Denim");

        // Alimentos
        Alimento leche = new Alimento("Leche", 2.5, 20, 2, true);
        Alimento pan = new Alimento("Pan", 1.5, 40, 7, false);

        // Lista
        Producto[] listaProductos = {smartphone, laptop, camiseta, jeans, leche, pan};
        registrarListaProductos(listaProductos);

        System.out.printf("*** DATOS DE PRUEBA CARGADOS. Número de productos: %d ***\n", catalogo.size());
    }

    public void registrarListaProductos(Producto[] listaProductos)
    {
        for (Producto listaProducto : listaProductos)
        {
            registrarProducto(listaProducto);
        }
    }

    /***
     * Registra un objeto de la clase {@code Producto} en el catálogo.
     * @param producto El producto a registrar.
     * @return <ul>
     *     <li>{@code true} - Si se ha registrado correctamente.</li>
     *     <li>{@code false} - Si ha habido problemas al registrar.</li>
     * </ul>
     */
    public boolean registrarProducto(Producto producto)
    {
        if (!(catalogo.contains(producto)))
        {
            catalogo.add(producto);
            return true;
        }
        else { return false; }
    }

    public void listarProductos()
    {
        for (int posicion = 0; posicion < catalogo.size(); posicion++)
        {
            Producto actual = catalogo.get(posicion);

            // Primero mostramos la infomración general
            double precioFinal = actual.calcularPrecioFinal(PORCENTAJE_DESCUENTO_BASE);
            String simboloEuro = "€";
            System.out.printf("\n%d. (%.2f%s) ", posicion + 1, precioFinal, simboloEuro);

            // Luego muestra información específica
            if (actual instanceof Electronico)
            {
                Electronico electronicoActual = (Electronico) actual;
                System.out.printf("%s\n", electronicoActual);
            }
            else if (actual instanceof Textil)
            {
                Textil textilActual = (Textil) actual;
                System.out.printf("%s\n", textilActual);
            }
            else if (actual instanceof Alimento)
            {
                Alimento alimentoActual = (Alimento) actual;
                System.out.printf("%s\n", alimentoActual);
            }
        }
    }

    public void mostrarCantidadPorTipo()
    {
        int cantidadElectronicos = 0;
        int cantidadTextil = 0;
        int cantidadAlimentos = 0;

        for (Producto producto : catalogo)
        {
            if (producto instanceof Electronico) { cantidadElectronicos++; }
            else if (producto instanceof Textil) { cantidadTextil++; }
            else if (producto instanceof Alimento) { cantidadAlimentos++; }
        }

        System.out.printf("Electrónicos: %d\n", cantidadElectronicos);
        System.out.printf("Textiles: %d\n", cantidadTextil);
        System.out.printf("Alimentos: %d\n", cantidadAlimentos);
    }

    public double sumarPrecioFinal()
    {
        double precioTotal = 0.0;
        for (Producto producto : catalogo)
        {
            precioTotal += producto.calcularPrecioFinal(PORCENTAJE_DESCUENTO_BASE);
        }
        return precioTotal;
    }
}
