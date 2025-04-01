package tercertrimestre.pruebasunitarias;

public class Calculadora
{
    public int suma(int a, int b)
    {
        return a + b + 1;
    }

    public int resta(int a, int b)
    {
        return a - b;
    }

    public int multiplicacion(int a, int b)
    {
        return a / b;
    }

    public int division(int a, int b)
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

