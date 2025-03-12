package segundotrimestre.examenfinal;

import java.util.Scanner;

public class ProgramaTienda
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = new Tienda();

        tienda.cargarDatosDePrueba();

        int opcion;
        do
        {
            System.out.println("\nMenú de Tienda Online");
            System.out.println("1. Registrar nuevo producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Mostrar número total de productos por tipo");
            System.out.println("4. Sumar el precio final de todos los productos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion)
            {
                case 1:
                    registrarProducto(scanner, tienda);
                    break;

                case 2:
                    tienda.listarProductos();
                    break;

                case 3:
                    tienda.mostrarCantidadPorTipo();
                    break;

                case 4:
                    System.out.println("Suma total del precio final: " + tienda.sumarPrecioFinal());
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void registrarProducto(Scanner scanner, Tienda tienda)
    {
        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1. Electrónico");
        System.out.println("2. Textil");
        System.out.println("3. Alimento");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto nuevoProducto = null;
        switch (tipo)
        {
            case 1: // Electrónico
                System.out.print("Ingrese la marca del producto: ");
                String marca = scanner.nextLine();
                System.out.print("Ingrese el modelo del producto: ");
                String modelo = scanner.nextLine();
                System.out.print("Ingrese la garantía en meses: ");
                int garantia = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                nuevoProducto = new Electronico(nombre, precio, stock, marca, modelo, garantia);
                break;

            case 2: // Textil
                System.out.print("Ingrese la talla (S, M, L, XL): ");
                String talla = scanner.nextLine();
                System.out.print("Ingrese el material (algodón, poliéster, etc.): ");
                String material = scanner.nextLine();
                nuevoProducto = new Textil(nombre, precio, stock, talla, material);
                break;

            case 3: // Alimento
                System.out.print("Ingrese el nivel de frescura (1-10): ");
                int frescura = scanner.nextInt();
                System.out.print("¿Requiere refrigeración? (true/false): ");
                boolean requiereRefrigeracion = scanner.nextBoolean();
                scanner.nextLine(); // Limpiar buffer
                nuevoProducto = new Alimento(nombre, precio, stock, frescura, requiereRefrigeracion);
                break;

            default:
                System.out.println("Tipo de producto no válido.");
                return;
        }

        if (nuevoProducto != null)
        {
            boolean registradoCorrectamente = tienda.registrarProducto(nuevoProducto);
            if (registradoCorrectamente) { System.out.println("Producto registrado correctamente."); }
            else { System.err.println("ERROR: Producto repetido."); }
        }
    }
}
