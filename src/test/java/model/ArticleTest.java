package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {

    @Test
    public void comprobarCalculoPrecioBruto() {
        /*
        
        ej practico 2 mochilas a 25 = 50€
        
        */
        Article mochila = new Article("Mochila", 2, 25.0, 10.0);
        
        double esperado = 50.0;
        double resultado = mochila.getGrossAmount();
        
        assertEquals(esperado, resultado, 0.01);
    }
    @Test
    public void comprobarCalculoPrecioConDescuento() {
        Article mochila = new Article("Mochila", 2, 25.0, 10.0);
        
        double esperado = 45.0;
        double resultado = mochila.getDiscountedAmount();
        
        assertEquals(esperado, resultado, 0.01);
    }
}