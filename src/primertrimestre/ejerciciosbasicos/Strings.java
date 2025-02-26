package primertrimestre.ejerciciosbasicos;

public class Strings
{
    public static void main(String[] args)
    {
        String email = "diego.di1@educa.madrid.org";

        System.out.println(email);

//        int primerIndice = email.indexOf(".");
//        int ultimoIndice = email.lastIndexOf("@");
//
//        String fragmento = email.substring(primerIndice, ultimoIndice + 1);

//        System.out.println(fragmento);

        email = email.replaceAll("[A-z]", "a");
        System.out.println(email);


    }
}
