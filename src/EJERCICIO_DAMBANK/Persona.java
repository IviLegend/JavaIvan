package EJERCICIO_DAMBANK;

public class Persona
{
    /// ATRIBUTOS
    private String nombre;
    private String apellido;
    private String dni;

    public CuentaBancaria[] cuentas = new CuentaBancaria[CuentaBancaria.maxCuentasBancarias];

    /// CONSTRUCTORES
    public Persona()
    {

    }

    public Persona(String nombre, String apellido, String dni)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    /// MÉTODOS
    public static boolean dniValido(String dni)
    {
        String dniRegex = "^[0-9]{8}[A-HJ-NP-TV-Z]$";
        return dni.matches(dniRegex);
    }

    public String getDni()
    {
        return dni;
    }

    public double getSaldoTotal()
    {
        double saldoTotal = 0;

        for (int i = 0; i < cuentas.length; i++)
        {
            if (cuentas[i] != null)
            {
                saldoTotal += cuentas[i].getSaldo();
            }
        }

        return saldoTotal;
    }

    public boolean comprobarSaldoNegativo()
    {
        boolean tieneSaldoNegativo = false;

        for (int i = 0; i < cuentas.length; i++)
        {
            if (cuentas[i] != null)
            {
                if (cuentas[i].getSaldo() < 0)
                {
                    tieneSaldoNegativo = true;
                }
            }
        }

        return tieneSaldoNegativo;
    }

    public void crearCuentaNueva()
    {
        CuentaBancaria cuentaConMasDinero = null;

        cuentas[1] = new CuentaBancaria(this);
    }

    public String toString()
    {
        return nombre + " " + apellido;
    }
}
