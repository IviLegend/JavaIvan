package EJERCICIO_DAMBANK;

import java.util.Scanner;

public class DamBank
{
    public static void main(String[] args)
    {
        DamBank damBank = new DamBank();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bienvenido, dime tu nombre y te crearé una cuenta en DamBank: ");
        String nombre = scanner.nextLine();
        System.out.print("Dime ahora tu apellido: ");
        String apellido = scanner.nextLine();

        boolean dniValido = false;
        System.out.print("Dime por último tu DNI: ");
        String dni = "";
        while (!dniValido)
        {
            dni = scanner.nextLine();
            dniValido = Persona.dniValido(dni);

            if (!dniValido)
                System.out.print("Dime un DNI válido por favor: ");
        }

        Persona persona = new Persona(nombre, apellido, dni);

        System.out.println();
        persona.cuentas[0] = persona.crearCuentaNueva(persona);

        int opcion = -1;
        int cuentaElegida = 0;

        while (opcion != 10)
        {
            damBank.mostrarMenu(persona.cuentas[cuentaElegida]);
            opcion = damBank.elegirOpcion(persona.cuentas[cuentaElegida]);
        }
    }

    /**
     * Muestra el menú con las posibles acciones
     * @param cuentaBancariaCreada La cuenta bancaria que está accediendo al menú
     * @author IviLegend
     */
    public void mostrarMenu(CuentaBancaria cuentaBancariaCreada)
    {
        System.out.printf("** BIENVENIDO A DAMBANK, %s **\n", cuentaBancariaCreada.getTitular().getNombreApellido().toUpperCase().trim());
        System.out.println("Escriba el número de la opción que quiera hacer: ");
        System.out.println("1. Mostrar datos de la cuenta.");
        System.out.println("2. Mostrar el IBAN.");
        System.out.println("3. Mostrar el titular.");
        System.out.println("4. Mostrar el saldo.");
        System.out.println("5. Ingresar dinero.");
        System.out.println("6. Retirar dinero.");
        System.out.println("7. Mostrar el historial de movimientos.");
        System.out.println("8. Crear cuenta nueva");
        System.out.println("9. Cambiar de cuenta");
        System.out.println("10. Salir");
    }

    public int elegirOpcion(CuentaBancaria cuentaBancariaOpcion)
    {
        Scanner scanner = new Scanner(System.in);
        int opcionElegida = 0;
        boolean opcionValida = false;

        while (!opcionValida)
        {
            opcionElegida = scanner.nextInt();

            switch(opcionElegida)
            {
                case 1:
                {
                    System.out.println(cuentaBancariaOpcion);
                    break;
                }

                case 2:
                {
                    System.out.printf("IBAN: %s\n", cuentaBancariaOpcion.getIban());
                    break;
                }

                case 3:
                {
                    System.out.printf("Titular: %s\n", cuentaBancariaOpcion.getTitular());
                    break;
                }

                case 4:
                {
                    System.out.printf("Saldo: %.2f\n", cuentaBancariaOpcion.getSaldo());
                    break;
                }

                case 5:
                {
                    System.out.print("¿Cuánto dinero quieres ingresar? Introduce el valor: ");
                    double ingreso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Introduce ahora el motivo: ");
                    String motivo = scanner.nextLine();
                    Movimiento movimiento = new Movimiento(Math.abs(ingreso), motivo);
                    cuentaBancariaOpcion.ingresarDinero(movimiento);
                    break;
                }

                case 6:
                {
                    System.out.print("¿Cuánto dinero quieres retirar? Introduce el valor: ");
                    double ingreso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Introduce ahora el motivo: ");
                    String motivo = scanner.nextLine();
                    Movimiento movimiento = new Movimiento(Math.abs(ingreso) * -1, motivo);
                    cuentaBancariaOpcion.retirarDinero(movimiento);
                    break;
                }

                case 7:
                {
                    System.out.println("** Historial de movimientos **");

                    for (int i = 0; i < CuentaBancaria.registrosHistorial; i++)
                    {
                        System.out.printf("%d. %s\n", (i + 1), cuentaBancariaOpcion.historialMovimientos[i]);
                    }

                    break;
                }

                case 8:
                {
                    CuentaBancaria cuentaACrear = cuentaBancariaOpcion.getTitular().crearCuentaNueva(cuentaBancariaOpcion.getTitular());
                    if (cuentaACrear != null)
                    {
                        cuentaBancariaOpcion.getTitular().cuentas[1] = cuentaACrear;
                    }
                    break;
                }

                case 9:
                {
                    System.out.println("¿A qué cuenta quieres cambiar?");
                    cuentaBancariaOpcion.getTitular().mostrarCuentas();
                    break;
                }

                case 10:
                {
                    System.out.println("¡Adiós!");
                    System.exit(0);
                    break;
                }

                default:
                {
                    System.err.print("Elige una opción válida por favor: ");
                }
            }
        }

        return opcionElegida;
    }
}
