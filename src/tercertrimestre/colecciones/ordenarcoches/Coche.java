package tercertrimestre.colecciones.ordenarcoches;

import java.util.Objects;

public class Coche implements Comparable
{
    /// ATRIBUTOS
    private int numRuedas;
    private String matricula;
    private String marca;
    private double gasolina;

    /// CONSTRUCTORES
    public Coche(int numRuedas, String matricula, String marca, double gasolina)
    {
        this.numRuedas = numRuedas;
        this.matricula = matricula;
        this.marca = marca;
        this.gasolina = gasolina;
    }

    /// MÉTODOS
    // ToString
    @Override
    public String toString()
    {
        return String.format("----\nMatrícula: %s\nNúmero de ruedas: %d\nGasolina restante: %.2f\nMarca: %s", matricula, numRuedas, gasolina, marca);
    }

    // CompareTo
    @Override
    public int compareTo(Object other)
    {
        Coche otroCoche = (Coche)other;

        return this.matricula.compareTo(otroCoche.getMatricula());
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object object)
    {
        if (object == null || getClass() != object.getClass()) return false;
        Coche coche = (Coche) object;
        return Objects.equals(matricula, coche.matricula);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(matricula);
    }

    // Getters y Setters
    public int getNumRuedas()
    {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas)
    {
        this.numRuedas = numRuedas;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public double getGasolina()
    {
        return gasolina;
    }

    public void setGasolina(double gasolina)
    {
        this.gasolina = gasolina;
    }
}
