import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import uvg.CalculadoraPostfix;

public class CalculadoraPostfixTest {

    private CalculadoraPostfix calculadora = CalculadoraPostfix.getInstance(null, null);

    @BeforeEach
    void setUp() {
        // Obtenemos la única instancia del Singleton antes de cada prueba
        calculadora = CalculadoraPostfix.getInstance(null, null);
    }

    @Test
    void testSingletonUnicaInstancia() {
        CalculadoraPostfix otraCalculadora = CalculadoraPostfix.getInstance(null, null);
        assertSame(calculadora, otraCalculadora, "Ambas instancias deben ser la misma");
    }

    @Test
    void testEvaluarExpresionSuma() {
        int resultado = calculadora.evaluarExpresion("3 4 +");
        assertEquals(7, resultado, "La suma de 3 + 4 debe ser 7");
    }

    @Test
    void testEvaluarExpresionResta() {
        int resultado = calculadora.evaluarExpresion("10 4 -");
        assertEquals(6, resultado, "La resta de 10 - 4 debe ser 6");
    }

    @Test
    void testEvaluarExpresionMultiplicacion() {
        int resultado = calculadora.evaluarExpresion("5 6 *");
        assertEquals(30, resultado, "La multiplicación de 5 * 6 debe ser 30");
    }

    @Test
    void testEvaluarExpresionDivision() {
        int resultado = calculadora.evaluarExpresion("8 2 /");
        assertEquals(4, resultado, "La división de 8 / 2 debe ser 4");
    }

    @Test
    void testDivisionPorCero() {
        Exception excepcion = assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculadora.evaluarExpresion("5 0 /");
            }
        });
        assertEquals("División por cero", excepcion.getMessage());
    }

    @Test
    void testExpresionInvalida() {
        Exception excepcion = assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculadora.evaluarExpresion("3 4 ?");
            }
        });
        assertTrue(excepcion.getMessage().contains("Token inválido"));
    }

    @Test
    void testOperandosInsuficientes() {
        Exception excepcion = assertThrows(IllegalStateException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculadora.evaluarExpresion("3 +");
            }
        });
        assertTrue(excepcion.getMessage().contains("No hay suficientes operandos"));
    }
}
