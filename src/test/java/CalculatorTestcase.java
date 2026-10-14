import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.uem.Calculator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorTestcase {

    Calculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    @Test
    public void testMultiply() {  
        int calculoNormal = calculator.multiply(4, 5);
        assertEquals(20, calculoNormal);
        int calculoCero = calculator.multiply(10, 0); 
        assertEquals(0, calculoCero);
        int calculoNegativo = calculator.multiply(-4, 5);
        assertEquals(-20, calculoNegativo);
    }

    @Test
    public void testConcat() {
        String unionNormal = calculator.concat("Java", "Script");
        assertEquals("JavaScript", unionNormal);
        String unionNula = calculator.concat(null, "Script");
        assertEquals("empty", unionNula);
    }

    @Test
    public void testSum() {
        double sumaconPositivo = calculator.sum(4.2, 5.8);
        assertEquals(10.0, sumaPositiva);
        double sumaConNegativo = calculator.sum(-5.0, 8.5);
        assertEquals(3.5, sumaConNegativo);
    }

    @Test
    public void testDiscount() {
        double descuentoValido = calculator.discount(200.0, 25.0);
        assertEquals(150.0, descuentoValido);
        double sinDescuento = calculator.discount(200.0, 0.0);
        assertEquals(200.0, sinDescuento);
        double descuentoTotal = calculator.discount(200.0, 100.0);
        assertEquals(0.0, descuentoTotal);
        IllegalArgumentException excepcionExceso = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.discount(200.0, 110.0));
        assertNotNull(excepcionExceso);
        IllegalArgumentException excepcionNegativa = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.discount(200.0, -10.0));
        assertNotNull(excepcionNegativa);
    }
    @Test
    public void testCalculateTotal() {
        List<Double> precios = new ArrayList<>();
        precios.add(15.5);
        precios.add(20.0);
        precios.add(14.5);
        double totalCalculado = calculator.calculateTotal(precios);
        assertEquals(50.0, totalCalculado);
        List<Double> listaVacia = new ArrayList<>();
        double totalCero = calculator.calculateTotal(listaVacia);
        assertEquals(0.0, totalCero);
    }
}