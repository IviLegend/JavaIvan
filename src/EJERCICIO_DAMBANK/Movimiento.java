package EJERCICIO_DAMBANK;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Movimiento
{
    private double importe;
    private String concepto;
    private String fecha;

    public Movimiento()
    {

    }

    public Movimiento(double importe, String concepto)
    {
        this.importe = importe;
        this.concepto = concepto;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        fecha = LocalDateTime.now().format(dateTimeFormatter);
    }

    public void setImporte(double importe)
    {
        this.importe = importe;
    }

    public double getImporte()
    {
        return this.importe;
    }

    public void setConcepto(String concepto)
    {
        this.concepto = concepto;
    }

    public String toString()
    {
        return importe + " | " + concepto + " | " + fecha;
    }
}
