package segundotrimestre.formas;

public class Rectangulo
{
    Punto punto1;
    Punto punto2;

    public Rectangulo()
    {

    }

    public Rectangulo(Punto punto1, Punto punto2)
    {
        this.punto1 = punto1;
        this.punto2 = punto2;

        if ((punto2.coordX < punto1.coordX) && (punto2.coordY < punto1.coordY))
        {
            System.err.println("ERROR al instanciar el rectángulo");
        }
    }

    public void MostrarCoordenadasRect()
    {
        punto1.MostrarCoordenadas();
        System.out.print(" ");
        punto2.MostrarCoordenadas();
    }

    public int CalcularPerimetroRect()
    {
        int perimetro;

        int lado1 = Math.abs(punto2.coordX - punto1.coordX);
        int lado2 = Math.abs(punto2.coordY - punto1.coordY);

        perimetro = (lado1 * 2) + (lado2 * 2);

        return perimetro;
    }

    public int CalcularAreaRect()
    {
        int area;

        int lado1 = Math.abs(punto2.coordX - punto1.coordX);
        int lado2 = Math.abs(punto2.coordY - punto1.coordY);

        area = (lado1 * lado2);

        return area;
    }
}
