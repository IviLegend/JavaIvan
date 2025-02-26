package segundotrimestre.pokemon;

public class Ataque
{
    String nombre;
    Tipo tipo;
    int potencia;
    int precision;
    int PPMaximo;
    int PP;
    ClaseAtaque claseAtaque;
    int idEspecial;

    // Ataque Físico
    public Ataque(String nombreInicial, ClaseAtaque claseAtaqueInicial, Tipo tipoAtaque, int potenciaInicial, int precisionInicial, int PPInicial)
    {
        nombre = nombreInicial;
        claseAtaque = claseAtaqueInicial;
        tipo = tipoAtaque;
        potencia = potenciaInicial;
        precision = precisionInicial;
        PP = PPInicial;
        PPMaximo = PP;

        idEspecial = 0;
    }

    // Ataque especial
    public Ataque(String nombreInicial, Tipo tipoAtaque, int precisionInicial, int PPInicial, int idEspecialInicial, ClaseAtaque claseAtaqueInicial)
    {
        nombre = nombreInicial;
        claseAtaque = claseAtaqueInicial;
        tipo = tipoAtaque;
        potencia = 0;
        precision = precisionInicial;
        PP = PPInicial;
        PPMaximo = PP;

        idEspecial = idEspecialInicial;
    }
}
