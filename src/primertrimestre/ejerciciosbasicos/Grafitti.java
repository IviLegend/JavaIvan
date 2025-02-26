package primertrimestre.ejerciciosbasicos;

public class Grafitti
{
    public static void main(String[] args)
    {
        int money = 100;
        int exchange = grafitti(money);
        System.out.println("Cambio: " + exchange);
    }

    public static int grafitti(int money)
    {
        if (money >= 100)
        {
            System.out.println("██╗░░██╗░█████╗░██╗░░░░░░█████╗░\n" +
                               "██║░░██║██╔══██╗██║░░░░░██╔══██╗\n" +
                               "███████║██║░░██║██║░░░░░███████║\n" +
                               "██╔══██║██║░░██║██║░░░░░██╔══██║\n" +
                               "██║░░██║╚█████╔╝███████╗██║░░██║\n" +
                               "╚═╝░░╚═╝░╚════╝░╚══════╝╚═╝░░╚═╝");
        }
        else
        {
            System.out.println("No hay grafitti para tí >:(");
        }

        return money;
    }
}
