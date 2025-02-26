package primertrimestre.ejerciciosbasicos;

public class TablasDeMultiplicarArrays
{
    public static void main(String[] args)
    {
        int[][] tablas = new int [11][11];

        for (int fila = 0; fila < tablas.length; fila++)
        {
            for (int columna = 0; columna < tablas[fila].length; columna++)
            {
                if ((fila * columna) != 0)
                {
                    tablas[fila-1][columna-1] = fila * columna;
                    System.out.print(tablas[fila-1][columna-1] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("sacabo");
    }
}
