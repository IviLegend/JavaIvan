package tercertrimestre.colecciones.ordenarcoches;

import java.util.*;

public class ProgramaCoches
{
    public static void main(String[] args)
    {
        Coche ferrari_1 = new Coche(4, "BCD 1234", "Ferrari", 24.4);
        Coche ferrari_2 = new Coche(4, "FGH 2345", "Ferrari", 42.3);
        Coche ferrari_3 = new Coche(4, "JKL 3456", "Ferrari", 36.7);
        Coche audi_1 = new Coche(4, "MNO 4567", "Audi", 38.2);
        Coche audi_2 = new Coche(4, "PQR 5678", "Audi", 29.8);
        Coche audi_3 = new Coche(4, "STU 6789", "Audi", 31.6);
        Coche toyota_1 = new Coche(4, "VWX 7890", "Toyota", 27.4);
        Coche toyota_2 = new Coche(4, "YZA 8901", "Toyota", 33.9);
        Coche toyota_3 = new Coche(4, "BCD 9012", "Toyota", 35.2);
        Coche bmw_1 = new Coche(4, "EFG 0123", "BMW", 30.5);
        Coche bmw_2 = new Coche(4, "HIJ 1234", "BMW", 28.7);
        Coche bmw_3 = new Coche(4, "KLM 2345", "BMW", 32.1);
        Coche tesla_1 = new Coche(4, "NOP 3456", "Tesla", 50.0);
        Coche tesla_2 = new Coche(4, "QRS 4567", "Tesla", 34.5);
        Coche tesla_3 = new Coche(4, "TUV 5678", "Tesla", 31.9);

        Coche yamaha_1 = new Coche(2, "XYZ 6789", "Yamaha", 15.2);
        Coche kawasaki_1 = new Coche(2, "ABC 7890", "Kawasaki", 17.5);
        Coche suzuki_1 = new Coche(2, "DEF 8901", "Suzuki", 14.8);

        List<Coche> listaCoches = Arrays.asList(ferrari_1, ferrari_2, ferrari_3, audi_1, audi_2, audi_3, toyota_1, toyota_2, toyota_3, bmw_1, bmw_2, bmw_3, tesla_1, tesla_2, tesla_3, yamaha_1, kawasaki_1, suzuki_1);

        mostrarOrdenNatural(listaCoches);

        //mostrarOrdenGasolina(listaCoches);

        //mostrarOrdenNumRuedas(listaCoches);

        //mostrarOrdenMarca(listaCoches);
    }

    private static void mostrarOrdenMarca(List<Coche> listaCoches)
    {
        System.out.println("== ORDEN POR MARCA ==");
        listaCoches.sort(Comparator.comparing(Coche::getMarca));
        listaCoches.forEach(System.out::println);
    }

    private static void mostrarOrdenNumRuedas(List<Coche> listaCoches)
    {
        System.out.println("== ORDEN POR NÚMERO DE RUEDAS ==");
        listaCoches.sort(Comparator.comparingInt(Coche::getNumRuedas));
        listaCoches.forEach(System.out::println);
    }

    private static void mostrarOrdenGasolina(List<Coche> listaCoches)
    {
        System.out.println("== ORDEN POR GASOLINA ==");
        Collections.sort(listaCoches, Comparator.comparingDouble(Coche::getGasolina).reversed());
        listaCoches.stream().forEach(System.out::println);
    }

    private static void mostrarOrdenNatural(List<Coche> listaCoches)
    {
        System.out.println("== ORDEN NATURAL ==");
        Collections.sort(listaCoches);
        listaCoches.stream().forEach(System.out::println);
    }
}
