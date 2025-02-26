package primertrimestre.ejerciciosbasicos;

public class FizzBuzz
{
    public static void main(String[] args)
    {
        boolean esMultiploDe3 = false;
        boolean esMultiploDe5 = false;

        for (int numeroActual = 1; numeroActual < 100; numeroActual++)
        {
            System.out.print(numeroActual + ". ");

            if ((numeroActual % 3) == 0) { esMultiploDe3 = true; }
            if ((numeroActual % 5) == 0) { esMultiploDe5 = true; }

            if ((esMultiploDe3) && (!esMultiploDe5))
            {
                System.out.print("fizz");
            }
            else if ((esMultiploDe5) && (!esMultiploDe3))
            {
                System.out.print("buzz");
            }
            else if ((esMultiploDe3) && (esMultiploDe5))
            {
                System.out.print("fizzbuzz");
            }
            else
            {
                System.out.print(numeroActual);
            }

            esMultiploDe3 = false;
            esMultiploDe5 = false;

            System.out.println();
        }
    }
}
