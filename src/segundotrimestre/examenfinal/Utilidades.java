package segundotrimestre.examenfinal;

public class Utilidades
{
    /// MÉTODOS ESTÁTICOS
    public static String convertirBooleanAString(boolean valor)
    {
        return valor ? "Sí" : "No";
    }

    public static String quitarTildes(String cadena)
    {
        String cadenaSinTildes = "";
        for (int i = 0; i < cadena.length(); i++)
        {
            char letraActual = cadena.charAt(i);

            switch(letraActual)
            {
                case 'á' -> cadenaSinTildes += "a";
                case 'é' -> cadenaSinTildes += "e";
                case 'í' -> cadenaSinTildes += "i";
                case 'ó' -> cadenaSinTildes += "o";
                case 'ú' -> cadenaSinTildes += "u";
                case 'Á' -> cadenaSinTildes += "A";
                case 'É' -> cadenaSinTildes += "E";
                case 'Í' -> cadenaSinTildes += "I";
                case 'Ó' -> cadenaSinTildes += "O";
                case 'Ú' -> cadenaSinTildes += "U";
                default -> cadenaSinTildes += letraActual;
            }
        }
        return cadenaSinTildes;
    }
}
