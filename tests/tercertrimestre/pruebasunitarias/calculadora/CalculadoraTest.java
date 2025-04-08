package tercertrimestre.pruebasunitarias.calculadora;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tercertrimestre.pruebasunitarias.Calculadora;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest
{
    @Test
    public void testSuma()
    {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.suma(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    public void testResta()
    {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.resta(5, 3), "5 - 3 debería ser 2");

    }

    @Test
    public void testMultiplicacion()
    {
        Calculadora calc = new Calculadora();
        assertEquals(6, calc.multiplicacion(2, 3), "2 * 3 debería ser 6");
    }

    @Test
    public void testDivision()
    {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.division(6, 3), "6 / 3 debería ser 2");
    }

    @Test
    public void testDivisionPorCero()
    {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calc.division(5, 0), "Dividir por cero debería lanzar ArithmeticException");
    }

    @ParameterizedTest
    @CsvSource({"2,2,4", "100,105,205"})
    public void testSuma2()
    {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.suma(2, 3), "2 + 3 debería ser 5");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 0, -1, 100, 15})
    public void testParMultiplesNumeros(int numero)
    {
        Calculadora calc = new Calculadora();
        boolean resultadoEsPar = calc.esPar(numero);
        switch (numero)
        {
            // Pares
            case 2, 0, 100 -> assertTrue(resultadoEsPar);
            // Impares
            case 3, 5, -1, 15 -> assertFalse(resultadoEsPar);
        }
    }
}
