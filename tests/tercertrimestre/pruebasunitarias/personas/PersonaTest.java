package tercertrimestre.pruebasunitarias.personas;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest
{
    @BeforeAll
    static void iniciarPruebas()
    {
        System.out.println("**** Comenzando Pruebas ****");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void validarConstructor()
    {

    }

    @Test
    void esMayorDeEdad()
    {

    }

    @Test
    void puedeJubilarse()
    {

    }

    @AfterAll
    static void terminarPruebas()
    {
        System.out.println("**** Pruebas finalizadas ****");
    }
}