package FormasObjetos;

public class ProgramaPuntos
{
    public static void main(String[] args)
    {
        Punto puntoP = new Punto(0, 0);
        Punto puntoQ = new Punto(2, 4);

        puntoQ.Desplazar(2, 0);
        puntoQ.MostrarCoordenadas();

        double distanciaPQ = puntoP.CalcularDistancia(puntoQ);
        System.out.printf("%.4f", distanciaPQ);
    }
}
