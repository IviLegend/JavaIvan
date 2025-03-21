package tercertrimestre.interfaces.empresa;

import java.util.ArrayList;

public class Empresa implements OperacionesHacienda
{
    /// ATRIBUTOS
    private String nombre;
    private int CIF;

    private int telefono;
    private String direccion;

    private ArrayList<Empleado> empleados;

    private double facturacion;

    /// CONSTRUCTORES
    public Empresa()
    {
        empleados = new ArrayList<>();
    }

    /// MÉTODOS
    @Override
    public double declarar()
    {
        return declaracionEmpleados() + (facturacion * 0.25);
    }

    public double declaracionEmpleados()
    {
        double totalEmpleados = 0;

        for (Empleado empleado : empleados)
        {
            totalEmpleados += empleado.getSueldoBrutoMensual();
        }

        return totalEmpleados;
    }

    public void mostrarInfoEmpleados()
    {
        for (Empleado empleado : empleados)
        {
            System.out.println(empleado);
        }
    }

    public void anyadirEmpleado(Empleado empleado)
    {
        empleados.add(empleado);
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCIF()
    {
        return CIF;
    }

    public void setCIF(int CIF)
    {
        this.CIF = CIF;
    }

    public int getTelefono()
    {
        return telefono;
    }

    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public ArrayList<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados)
    {
        this.empleados = empleados;
    }

    public double getFacturacion()
    {
        return facturacion;
    }

    public void setFacturacion(double facturacion)
    {
        this.facturacion = facturacion;
    }
}
