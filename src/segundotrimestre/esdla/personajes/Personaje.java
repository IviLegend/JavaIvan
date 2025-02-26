package segundotrimestre.esdla.personajes;

public abstract class Personaje
{
    protected String nombre;
    protected int vida;
    protected int posX;
    protected int posY;

    protected boolean mover(int incrementoX, int incrementoY)
    {
        posX += incrementoX;
        posY += incrementoY;
        return true;
    }
}
