package segundotrimestre.dambank;

import java.util.Random;

public class CuentaBancaria
{
    /// ATRIBUTOS
    private String iban;
    private Persona titular;
    private double saldo;
    public Movimiento[] historialMovimientos;

    static final int maxCuentasBancarias = 3;
    static final double saldoMinimo = -50;
    static final int registrosHistorial = 10;
    static final double movimientoSospechoso = 3000;

    /// CONSTRUCTORES
    public CuentaBancaria()
    {

    }

    public CuentaBancaria(Persona titular)
    {
        this.titular = titular;

        iban = generarIban();
        saldo = 0;
        historialMovimientos = new Movimiento[registrosHistorial];
        inicializarMovimientos();
    }

    /// MÉTODOS
    private void inicializarMovimientos()
    {
        for (int pos = 0; pos < registrosHistorial; pos++)
        {
            historialMovimientos[pos] = new Movimiento();
        }
    }

    public static String generarIban()
    {
        Random random = new Random();
        String ibanGenerado = "";

        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < 2; i++)
        {
            int numeroRandom = random.nextInt(abecedario.length);
            ibanGenerado += abecedario[numeroRandom];
        }

        for (int i = 0; i < 22; i++)
        {
            int numeroRandom = random.nextInt(10);
            ibanGenerado += String.valueOf(numeroRandom);
        }

        return ibanGenerado;
    }

    /**
     * @return
     * <ul>
     *     <li>{@code true} - Si el IBAN es válido</li>
     *     <li>{@code false} - Si el IBAN no es válido</li>
     * </ul>
     */
    public static boolean ibanValido(String ibanParaComprobar)
    {
        String regex = "^[A-Z]{2}\\d{22}$";

        if ((ibanParaComprobar.length() != 24) || !(ibanParaComprobar.matches(regex)))
            return false;
        else
            return true;
    }

    public String getIban()
    {
        return this.iban;
    }

    public Persona getTitular()
    {
        return this.titular;
    }

    public double getSaldo()
    {
        return this.saldo;
    }

    public void actualizarSaldo(double saldo)
    {
        this.saldo += saldo;
    }

    public void ingresarDinero(Movimiento movimiento)
    {
        double ingreso = Math.abs(movimiento.getImporte());
        comprobarTransaccion(ingreso);
        actualizarSaldo(ingreso);
        actualizarHistorial(movimiento);
    }

    public void retirarDinero(Movimiento movimiento)
    {
        comprobarTransaccion(movimiento.getImporte());

        double ingreso = (Math.abs(movimiento.getImporte()) * -1);

        if ((getSaldo() + ingreso) < saldoMinimo)
        {
            System.err.println("AVISO: Saldo negativo");
        }

        actualizarSaldo(ingreso);
        actualizarHistorial(movimiento);
    }

    public void comprobarTransaccion(double saldo)
    {
        if (saldo >= movimientoSospechoso)
        {
            System.err.println("AVISO: Notificando a Hacienda.");
        }
    }

    public static boolean trasferencia(Movimiento movimiento, CuentaBancaria origen, CuentaBancaria destino)
    {
        boolean transaccionPosible = false;

        if (origen.getSaldo() >= movimiento.getImporte())
        {
            origen.retirarDinero(movimiento);
            destino.ingresarDinero(movimiento);
            transaccionPosible = true;
        }
        else
        {
            System.err.println("Transacción fallida. No hay suficiente saldo");
        }

        return transaccionPosible;
    }

    public void actualizarHistorial(Movimiento movimiento)
    {
        int primeraPosicionVacia = getPrimeraPosicionVacia();

        // Si no encuentra ninguna porque ya está lleno, elimina la más antigua y mueve todas uno para abajo
        if (primeraPosicionVacia == -1)
        {
            for (int i = 0; i < registrosHistorial; i++)
            {
                if (i != (registrosHistorial - 1)) { historialMovimientos[i] = historialMovimientos[i + 1]; }
                else
                {
                    historialMovimientos[i].setImporte(0);
                    historialMovimientos[i].setConcepto("");
                }
            }

            primeraPosicionVacia = getPrimeraPosicionVacia();
        }

        historialMovimientos[primeraPosicionVacia] = movimiento;
    }

    private int getPrimeraPosicionVacia()
    {
        int primeraPosicionVacia = -1;

        // Busca la primera posición libre
        for (int i = 0; i < registrosHistorial; i++)
        {
            if (historialMovimientos[i].getImporte() == 0)
            {
                primeraPosicionVacia = i;
                break;
            }
        }
        return primeraPosicionVacia;
    }

    public void buscarMovimiento(String busqueda)
    {
        for (int i = 0; i < registrosHistorial; i++)
        {
            if (historialMovimientos[i].getConcepto().contains(busqueda))
            {
                System.out.println(historialMovimientos[i]);
            }
        }
    }

    private String censurarString(String cadenaACensurar)
    {
        String caracterCensura = "*";

        String ibanCensurado = "";

        for (int i = 0; i < cadenaACensurar.length(); i++)
        {
            if ((i < 4) || (i > cadenaACensurar.length() - 3))
            {
                ibanCensurado += cadenaACensurar.charAt(i);
            }
            else
            {
                ibanCensurado += caracterCensura;
            }
        }

        return ibanCensurado;
    }

    public String toString()
    {
        return "IBAN: " + iban + " | Titular: " + titular + " | Saldo: " + saldo;
    }
}
