package EJERCICIO_DAMBANK;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DamBank
{
    /*
        MENU
        1. Datos de la cuenta. Mostrará el IBAN, el
        titular y el saldo.
        2. IBAN. Mostrará el IBAN.
        3. Titular. Mostrará el titular.
        4. Saldo. Mostrará el saldo disponible.
        5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible.
        6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible.
        7. Movimientos. Mostrará una lista con el historial de movimientos.
        8. Salir. Termina el programa.
    */
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
        CuentaBancaria cuentaBancariaIvan = new CuentaBancaria(persona);

        int opcion = -1;

        while (opcion != 8)
        {
            damBank.mostrarMenu(cuentaBancariaIvan);
            opcion = damBank.elegirOpcion(cuentaBancariaIvan);
        }
    }

    public void mostrarMenu(CuentaBancaria cuentaBancariaCreada)
    {
        System.out.printf("** BIENVENIDO A DAMBANK, %s **\n", cuentaBancariaCreada.getTitular().toString().toUpperCase());
        System.out.println("Escriba el número de la opción que quiera hacer: ");
        System.out.println("1. Mostrar datos de la cuenta.");
        System.out.println("2. Mostrar el IBAN.");
        System.out.println("3. Mostrar el titular.");
        System.out.println("4. Mostrar el saldo.");
        System.out.println("5. Ingresar dinero.");
        System.out.println("6. Retirar dinero.");
        System.out.println("7. Mostrar el historial de movimientos.");
        System.out.println("8. Salir");
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
                    Movimiento movimiento = new Movimiento(ingreso, motivo);
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
                    Movimiento movimiento = new Movimiento(ingreso, motivo);
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
                    cuentaBancariaOpcion.getTitular().crearCuentaNueva();
                    break;
                }

                case 9:
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
