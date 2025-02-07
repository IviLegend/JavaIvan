package FormasObjetos;


public class ProgramaFormas
{
    public static void main(String[] args)
    {
        Punto punto1Rect1 = new Punto(0, 0);
        Punto punto2Rect1 = new Punto(5, 5);

        Punto punto1Rect2 = new Punto(7, 9);
        Punto punto2Rect2 = new Punto(2, 3);

        Rectangulo rect1 = new Rectangulo(punto1Rect1, punto2Rect1);
        Rectangulo rect2 = new Rectangulo(punto1Rect2, punto2Rect2);

        rect1.MostrarCoordenadasRect();
        System.out.println();
        rect2.MostrarCoordenadasRect();

        System.out.println();
        System.out.println(rect1.CalcularPerimetroRect());

        System.out.println(rect2.CalcularPerimetroRect());

        System.out.println(rect2.CalcularAreaRect());
    }
}
