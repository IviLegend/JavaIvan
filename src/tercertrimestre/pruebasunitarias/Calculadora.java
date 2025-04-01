package tercertrimestre.pruebasunitarias;

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
}

