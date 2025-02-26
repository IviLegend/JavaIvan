package segundotrimestre.articulos;

import java.util.Scanner;

public class ProgramaArticulos
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Articulo pijama = new Articulo("Pijama", 10, 5, IVA.GENERAL);
        Articulo peluca = new Articulo("Peluca", 5.99, 2, IVA.REDUCIDO);
        Articulo reloj = new Articulo("Reloj", 45.99, 7, IVA.GENERAL);
        Articulo camiseta = new Articulo("Camiseta", 25, 8, IVA.SUPER_REDUCIDO);
        Articulo abrigo = new Articulo("Abrigo", 48, 1, IVA.GENERAL);
        Articulo abrigoCaro = new Articulo("Abrigo Caro", 129.99, 1, IVA.GENERAL);

        Articulo[] stock = {pijama, peluca, reloj, camiseta, abrigo, abrigoCaro};

        // Articulo.mostrarListaArticulos(stock);

        System.out.println("Dime que artículos quieres buscar");
        String busqueda = scanner.nextLine();

        boolean hayArticulos = Articulo.buscarArticulo(busqueda, stock);

        if (!hayArticulos)
            System.out.println("No se encuentra");
    }
}
