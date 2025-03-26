package tercertrimestre.interfaces.empresa;

public class Empleado implements OperacionesHacienda
{
    /// ATRIBUTOS
    private String nombre;
    private String DNI;
    private double sueldoBrutoMensual;
    private int edad;
    private int telefono;
    private String direccion;

    /// CONSTRUCTORES
    public Empleado()
    {

    }

    public Empleado(String nombre, String DNI, double sueldoBrutoMensual)
    {
        this.nombre = nombre;
        this.DNI = DNI;
        this.sueldoBrutoMensual = sueldoBrutoMensual;

        edad = 0;
        telefono = 0;
        direccion = "-";
    }

    public Empleado(String nombre, String DNI, double sueldoBrutoMensual, int edad, int telefono, String direccion)
    {
        this.nombre = nombre;
        this.DNI = DNI;
        this.sueldoBrutoMensual = sueldoBrutoMensual;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /// MÉTODOS
    // Métodos propios
    public void mostrarInformacion()
    {
        System.out.printf("%s, edad: %d\nSueldo Bruto: %.2f | Sueldo Neto: %.2f\n- DNI: %s\n- Teléfono: %d\n- Dirección: %s", nombre, edad, sueldoBrutoMensual, calcularSueldoNeto(), DNI, telefono, direccion);
    }

    public double calcularSueldoNeto()
    {
        double IRPF;
        if (sueldoBrutoMensual < 12000) { IRPF = 20; }
        else if (sueldoBrutoMensual < 25000) { IRPF = 30; }
        else { IRPF = 40; }

        return sueldoBrutoMensual - (sueldoBrutoMensual * (IRPF / 100));
    }

    @Override
    public double declarar()
    {
        return (sueldoBrutoMensual * 0.1);
    }

    // Getters y Setters
    public String getNombre()
    {
        return nombre;
    }

    public String getDNI()
    {
        return DNI;
    }

    public double getSueldoBrutoMensual()
    {
        return sueldoBrutoMensual;
    }

    public void setSueldoBrutoMensual(double sueldoBrutoMensual)
    {
        this.sueldoBrutoMensual = sueldoBrutoMensual;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
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
}
