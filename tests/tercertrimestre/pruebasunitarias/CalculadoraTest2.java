package tercertrimestre.pruebasunitarias;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest2
{
    static Calculadora calc;

    @BeforeAll
    static void antesDeTodos()
    {
        calc = new Calculadora();
        System.out.println("**** Empezamos con los tests *************************");
    }

    @BeforeEach
    void antesDeCadaTest()
    {
        System.out.println("**** Inicio del test *************************");
    }

    @AfterEach
    void despuesDeCadaTest()
    {
        System.out.println("**** Fin del test *************************");
    }

    @AfterAll
    static void despuesDeTodos()
    {
        System.out.println("**** Terminamos con los tests *************************");
    }

    @Test
    public void testSuma()
    {
        //Calculadora calc = new Calculadora();
        assertEquals(5, calc.suma(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    public void testResta()
    {
        //Calculadora calc = new Calculadora();
        assertEquals(2, calc.resta(5, 3), "5 - 3 debería ser 2");
    }

    @Test
    public void testMultiplicacion()
    {
        //Calculadora calc = new Calculadora();
        assertEquals(6, calc.multiplicacion(2, 3), "2 * 3 debería ser 6");
    }

    @Test
    public void testDivision()
    {
        //Calculadora calc = new Calculadora();
        assertEquals(2, calc.division(6, 3), "6 / 3 debería ser 2");
    }

    @Test
    public void testDivisionPorCero()
    {
        //Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calc.division(5, 0), "Dividir por cero debería lanzar ArithmeticException");
    }
}