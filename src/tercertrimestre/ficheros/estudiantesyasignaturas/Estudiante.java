package tercertrimestre.ficheros.estudiantesyasignaturas;

import java.util.ArrayList;
import java.util.Set;

public class Estudiante
{
    public String nombre;
    public Set<String> listaAsignaturas;

    public Estudiante(String nombre, Set<String> listaAsignaturas)
    {
        this.nombre = nombre;
        this.listaAsignaturas = listaAsignaturas;
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s", nombre, listaAsignaturas);
    }
}
