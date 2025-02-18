package Herencias;

public class PrincipalHerencias
{
    public static void main(String[] args)
    {
        Hombre hombre = new Hombre();
        hombre.imprimirDatos();
        Mujer mujer = new Mujer();

        mujer.imprimirDatos();
        hombre.imprimirDatos();
    }
}
