package tercertrimestre.pruebasunitarias;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Calculadora
{
    public int suma(int a, int b)
    {
        return a + b;
    }

    public int resta(int a, int b)
    {
        return a - b;
    }

    public int multiplicacion(int a, int b)
    {
        return a * b;
    }

    public double division(double a, double b)
    {
        if (b == 0)
        {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    public boolean esPar(int a)
    {
        return a % 2 == 0;
    }

    public static String obtenerDiaSemanaNacimiento(String fechaNacimientoString)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try
        {
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
            DayOfWeek diaSemana = fechaNacimiento.getDayOfWeek();
            return diaSemana.toString(); // Devuelve el nombre del día en inglés (ej: MONDAY)
            // Si prefieres el nombre en español, puedes usar un Locale:
            // return diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        }
        catch (DateTimeParseException e)
        {
            System.err.println("Error: La fecha proporcionada no tiene el formato correcto (dd/mm/yyyy).");
            return null;
        }
    }

    public static void main(String[] args)
    {
        String fecha = "23/06/2006";
        String diaDeLaSemana = obtenerDiaSemanaNacimiento(fecha);

        if (diaDeLaSemana != null)
        {
            System.out.println("Naciste un: " + diaDeLaSemana);
        }

        String fechaInvalida = "32/01/2023";
        obtenerDiaSemanaNacimiento(fechaInvalida); // Esto imprimirá el mensaje de error.

        String formatoIncorrecto = "15-08-1990";
        obtenerDiaSemanaNacimiento(formatoIncorrecto); // Esto también imprimirá el mensaje de error.
    }
}

