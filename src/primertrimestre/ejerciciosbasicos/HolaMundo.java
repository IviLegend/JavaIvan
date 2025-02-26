package primertrimestre.ejerciciosbasicos;

public class HolaMundo
{
    public static void main(String[] args)
    {
        // Declaración del array
        String[] caracteres = new String[96]; // 26 minúsculas + 26 mayúsculas + 10 números + 31 símbolos
        int index = 0;

        // Añadimos las letras minúsculas
        for (char c = 'a'; c <= 'z'; c++) {
            caracteres[index++] = String.valueOf(c);
        }

        // Añadimos las letras mayúsculas
        for (char c = 'A'; c <= 'Z'; c++) {
            caracteres[index++] = String.valueOf(c);
        }

        // Añadimos los números
        for (char c = '0'; c <= '9'; c++) {
            caracteres[index++] = String.valueOf(c);
        }

        // Añadimos los símbolos de puntuación comunes en español
        char[] simbolos = {
                '.', ',', ';', ':', '¿', '?', '¡', '!', '"', '\'', '(', ')', '[', ']', '{', '}', '-', '_',
                '/', '\\', '|', '@', '#', '$', '%', '&', '*', '+', '=', '<', '>', '°', 'ñ', 'Ñ'
        };

        for (char simbolo : simbolos) {
            caracteres[index++] = String.valueOf(simbolo);
        }

        String texto = "Hola mundo, soy Ivan";

        String cadena = "";

        for (int i = 0; i < caracteres.length; i++)
        {
            Esperar(100);
            System.out.print(caracteres[i]);
        }
    }

    public static void Esperar(int milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
