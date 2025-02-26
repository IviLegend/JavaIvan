package primertrimestre.ejerciciosbasicos;

public class Aleatorio
{
    public static void main(String[] args)
    {
        int cont15 = 0;

        for (int i = 0; i < 100; i++)
        {
            double number = (Math.random() * 15) + 1;
            int numberInt = (int)number;

            if (numberInt == 15) { cont15++; }
            //System.out.println(numberInt);
        }

        System.out.println("15: " + cont15);
    }
}
