package segundotrimestre.dambank;

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

        if (dni.matches(dniRegex))
        {
            String[] letrasDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
            String letraDni = Character.toString(dni.charAt(8));
            int numeroDni = Integer.parseInt(dni.substring(0, 8));
            int moduloDni = numeroDni % 23;

            if (letrasDNI[moduloDni].equalsIgnoreCase(letraDni))
            {
                return true;
            }
            else
            {
                System.err.println("¡La letra no es válida!");
                return false;
            }
        }
        else
        {
            System.err.println("¡Tu DNI no es válido!");
            return false;
        }
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

    public CuentaBancaria crearCuentaNueva(Persona persona)
    {
        CuentaBancaria cuentaConMasDinero = persona.cuentas[0];

        int primerEspacioVacio = 0;

        for (int i = 0; i < cuentas.length; i++)
        {
            if (cuentas[i] == null)
            {
                primerEspacioVacio = i;
                break;
            }
        }

        for (int i = 0; i < cuentas.length; i++)
        {
            if (cuentas[i] != null)
            {
                if (cuentas[i].getSaldo() > cuentaConMasDinero.getSaldo())
                {
                    cuentaConMasDinero = cuentas[i];
                }
            }
        }

        /*if ((cuentaConMasDinero.getSaldo() > 0) || (cuentas[primerEspacioVacio] == null))
        {*/
            cuentas[primerEspacioVacio] = new CuentaBancaria(persona);
            if (cuentas[0] != null)
            {
                CuentaBancaria.trasferencia(new Movimiento(cuentas[0].getSaldo() * 0.1, "Creación de cuenta"), cuentas[0], cuentas[1]);
            }
        /*}
        else
        {
            return null;
        }*/

        return cuentas[primerEspacioVacio];
    }

    public void mostrarCuentas()
    {
        int index = 1;

        for (int pos = 0; pos < cuentas.length; pos++)
        {
            if (cuentas[pos] != null)
            {
                System.out.printf("%d. %s\n", index, cuentas[pos]);
                index++;
            }
        }
    }

    public String getNombreApellido()
    {
        return nombre + " " + apellido;
    }

    public String toString()
    {
        return nombre + " " + apellido + " | DNI: " + dni;
    }
}
