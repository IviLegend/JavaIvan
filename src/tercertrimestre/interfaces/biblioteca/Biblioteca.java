package tercertrimestre.interfaces.biblioteca;

import java.util.ArrayList;

public class Biblioteca
{
    /// ATRIBUTOS
    ArrayList<Publicacion> inventario;

    /// CONSTRUCTORES
    public Biblioteca()
    {
        inventario = new ArrayList<>();
    }

    /// MÉTODOS
    public void anyadirPublicacion(Publicacion publicacion)
    {
        inventario.add(publicacion);
    }

    public void prestarPublicacion(String codigo)
    {
        for (Publicacion publicacion : inventario)
        {
            if (publicacion instanceof Prestable)
            {
                if (publicacion.getCodigo().equals(codigo))
                {
                    ((Prestable) publicacion).prestar();
                }
            }
        }
    }

    public void mostrarInventario()
    {
        for (int i = 0; i < inventario.size(); i++)
        {
            System.out.printf("%d. %s", i + 1, inventario.get(i));
        }
    }
}
