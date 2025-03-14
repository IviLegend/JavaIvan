package tercertrimestre.pokemonmejorado;

import tercertrimestre.pokemonmejorado.data.Nature;

public class Pokemon implements PokemonData
{
    /// FIELDS
    public PokemonData pokemonData;
    private String name;
    private int level;

    private Nature nature;

    // Individual Values (IVs)
    private int ivHealthPoints;
    private int ivAttack;
    private int ivDefense;
    private int ivSpecialAttack;
    private int ivSpecialDefense;
    private int ivSpeed;

    private int[] ivList = {ivHealthPoints, ivAttack, ivDefense, ivSpecialAttack, ivSpecialDefense, ivSpeed};

    // Effort Values (EVs)
    private int evHealthPoints;
    private int evAttack;
    private int evDefense;
    private int evSpecialAttack;
    private int evSpecialDefense;
    private int evSpeed;

    private int[] evList = {evHealthPoints, evAttack, evDefense, evSpecialAttack, evSpecialDefense, evSpeed};

    /// METHODS
    private int calculateHealthPoints()
    {
        return ((((2 * initialHealthPoints) + ivHealthPoints + (evHealthPoints/4)) * level)/100)+level+10;
    }

    private int calculateOtherStat(int statIndex)
    {
        return (int)((((((2 * initialHealthPoints) + ivHealthPoints + (evHealthPoints/4)) * level)/100)+5)*calculateNatureBonus(statIndex));
    }

    private double calculateNatureBonus(int statIndex)
    {
        switch(nature)
        {
            case LAX ->
        }
    }
}
