package tercertrimestre.interfaces.empresa;

import java.util.ArrayList;

public class Empresa
{
    /// ATRIBUTOS
    private String nombre;
    private int CIF;

    private int telefono;
    private String direccion;

    private ArrayList<Empleado> empleados;

    /// CONSTRUCTORES
    public Empresa()
    {
        empleados = new ArrayList<>();
    }
}
