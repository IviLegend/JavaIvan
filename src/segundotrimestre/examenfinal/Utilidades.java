package segundotrimestre.examenfinal;

public class Utilidades
{
    /// MÉTODOS ESTÁTICOS
    public static String convertirBooleanAString(boolean valor)
    {
        return valor ? "Sí" : "No";
    }

    public static String quitarTildesAntiguo(String cadena)
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

    public static String quitarTildes(String cadena)
    {
        return cadena.replace("á", "a").replace("é", "e").replace("í", "i")
                .replace("ó", "o").replace("ú", "u")
                .replace("Á", "A").replace("É", "E").replace("Í", "I")
                .replace("Ó", "O").replace("Ú", "U");
    }
}
