package EJERCICIO_DAMBANK;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento
{
    private double importe;
    private String concepto;
    private String fecha;

    public Movimiento()
    {
        importe = 0.0;
        concepto = "Vacío";
        fecha = "--/--/---- --:--";
    }

    public Movimiento(double importe, String concepto)
    {
        this.importe = importe;
        this.concepto = concepto;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
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
