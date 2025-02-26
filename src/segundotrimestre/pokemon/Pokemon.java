package segundotrimestre.pokemon;

public class Pokemon
{
    public String nombre;

    public Tipo tipo;

    public int nivel = 1;

    public int vidaMaxima;
    public int vida;
    public int ataque;
    public int defensa;
    public int especial;
    public int velocidad;

    public Ataque[] ataques = new Ataque[4];

    public Pokemon(String nombreInicial, Tipo tipoInicial, int nivelInicial, int vidaInicial, int ataqueInicial, int defensaInicial, int especialInicial, int velocidadInicial, Ataque ataque1Inicial, Ataque ataque2Inicial, Ataque ataque3Inicial, Ataque ataque4Inicial)
    {
        nombre = nombreInicial;
        tipo = tipoInicial;
        nivel = nivelInicial;
        vidaMaxima = vidaInicial;
        vida = vidaMaxima;
        ataque = ataqueInicial;
        defensa = defensaInicial;
        especial = especialInicial;
        velocidad = velocidadInicial;

        ataques[0] = ataque1Inicial;
        ataques[1] = ataque2Inicial;
        ataques[2] = ataque3Inicial;
        ataques[3] = ataque4Inicial;
    }

    public String toString()
    {
        return this.nombre;
    }
}

