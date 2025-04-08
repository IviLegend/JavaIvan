package tercertrimestre.pruebasunitarias.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import tercertrimestre.pruebasunitarias.Calculadora;

class CalculadoraTestAmpliado {
    static Calculadora calc;
    @BeforeAll
    static void antesDeTodos(){
        calc = new Calculadora();
        System.out.println("**** Empezamos con los tests *************************");
    }
    @AfterAll
    static void despuesDeTodos(){
        System.out.println("**** Terminamos con los tests *************************");
    }

/*    @BeforeEach
    void antesDeCadaTest(){
        System.out.println("**** Inicio del test *************************");
    }
    @AfterEach
    void despuesDeCadaTest(){
        System.out.println("**** Fin del test *************************");
    }
*/
    @Test
    public void testSuma() {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testSuma() *************************");
        assertEquals(5, calc.suma(2, 3), "2 + 3 debería ser 5*********************************");
    }

    @Test
    public void testResta() {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testResta() *************************");
        assertEquals(2, calc.resta(5, 3), "5 - 3 debería ser 2");
    }

    @Test
    public void testMultiplicacion() {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testMultiplicacion() *************************");
        assertEquals(6, calc.multiplicacion(2, 3), "2 * 3 debería ser 6");
    }

    @Test
    public void testDivision() {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testDivision() *************************");
        assertEquals(2, calc.division(6, 3), "6 / 3 debería ser 2");
    }

    @Test
    public void testDivisionPorCero() {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testDivisionPorCero() *************************");
        assertThrows(ArithmeticException.class, () -> calc.division(5, 0), "Dividir por cero debería lanzar ArithmeticException");
        //assertThrows(IOException.class, () -> calc.division(5, 0), "Dividir por cero debería lanzar ArithmeticException");
    }

    @ParameterizedTest
    @CsvSource({"2,2,4","100,105,205"})
    public void testSumaCSV(int a, int b, int resultadoEsperado) {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testSumaCSV() *************************");
        assertEquals(resultadoEsperado, calc.suma(a, b), a + " + " + b + " debería ser " + resultadoEsperado);
    }
    @ParameterizedTest
    @ValueSource (ints ={2,4,1000,8/2,22,100,-1})
    public void testParMultiplesNumeros(int numero) {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testParMultiplesNumeros() *************************");
        boolean resultadoEsPar =calc.esPar(numero);
        assertTrue(resultadoEsPar);
    }
    @Test
    public void testObtenerDiaSemanaNacimiento() {
        //Calculadora calc = new Calculadora();
        System.out.println("**** testObtenerDiaSemanaNacimiento() *************************");
        //String dayOfWeek="MONDAY";
        String dayOfWeek="TUESDAY";
        assertEquals(dayOfWeek, calc.obtenerDiaSemanaNacimiento("07/04/2025"), "Debería ser:"+dayOfWeek);
    }






}
