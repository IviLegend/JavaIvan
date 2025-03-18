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
        for (int i = 0; i < inventario.size(); i++)
        {
            if (inventario.get(i) instanceof Prestable)
            {
                if (inventario.get(i).getCodigo().equals(codigo))
                {
                    ((Prestable) inventario.get(i)).prestar();
                }
            }
        }
    }

    public void mostrarInventario()
    {
        for (int i = 0; i < inventario.size(); i++)
        {
            System.out.printf("%d. %s", i+1, inventario.get(i));
        }
    }
}
