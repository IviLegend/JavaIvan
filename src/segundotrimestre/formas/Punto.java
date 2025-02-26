package segundotrimestre.formas;

public class Punto
{
    /// ATRIBUTOS
    public int coordX;
    public int coordY;

    /// CONSTRUCTORES
    public Punto()
    {
        coordX = 0;
        coordY = 0;
    }

    public Punto(int coordX, int coordY)
    {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /// MÉTODOS
    public void MostrarCoordenadas()
    {
        System.out.printf("(%d, %d)", coordX, coordY);
    }

    public void SetXY(int newCoordX, int newCoordY)
    {
        coordX = newCoordX;
        coordY = newCoordY;
    }

    public void Desplazar(int dx, int dy)
    {
        coordX += dx;
        coordY += dy;
    }

    public double CalcularDistancia(Punto otroPunto)
    {
        return Math.sqrt(Math.pow((Math.abs(this.coordX - otroPunto.coordX)), 2) + Math.pow(Math.abs(this.coordY - otroPunto.coordY), 2));
    }
}
