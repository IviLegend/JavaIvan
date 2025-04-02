package tercertrimestre.controldeerrores.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Principal principal = new Principal();

        try
        {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(principal.division(a, b));
        }
        catch (InputMismatchException inputMismatchException)
        {
            System.err.println("ERROR: Valor no admitido | " + inputMismatchException.getClass());
        }
        catch (ArithmeticException arithmeticException)
        {
            System.err.println("ERROR: Operación incorrecta | " + arithmeticException.getClass());
        }
        catch (Exception exception)
        {
            System.err.println("ERROR: Error desconocido | " + exception.getClass());
        }
    }

    private double division(int a, int b)
    {
        return a / b;
    }
}
