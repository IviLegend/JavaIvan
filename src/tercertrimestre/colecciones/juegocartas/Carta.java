package tercertrimestre.colecciones.juegocartas;

public class Carta implements Comparable
{
    /// ATRIBUTOS
    public static String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private Palo palo;
    private String valor;

    /// CONSTRUCTORES
    public Carta(Palo palo, String valor)
    {
        this.palo = palo;
        this.valor = valor;
    }

    /// MÉTODOS
    public static String parsePalo(Palo palo)
    {
        String parsedPalo = "";
        switch(palo)
        {
            case CORAZONES -> parsedPalo = "Corazones";
            case DIAMANTES -> parsedPalo = "Diamantes";
            case TREBOLES -> parsedPalo = "Tréboles";
            case PICAS -> parsedPalo = "Picas";
        }
        return parsedPalo;
    }

    public static int parseValor(String valor)
    {
        switch (valor)
        {

        }
        return 1;
    }

    // ToString
    @Override
    public String toString()
    {
        return String.format("%s de %s", valor, parsePalo(palo));
    }

    // Comparable interface
    @Override
    public int compareTo(Object o)
    {
        return 0;
    }
}
