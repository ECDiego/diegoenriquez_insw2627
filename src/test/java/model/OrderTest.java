package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void comprobarCalculoTotalBruto() {
        Order miPedido = new Order();
        miPedido.setId("PED-101");

        Article item1 = new Article("Raton USB", 1, 15.0, 0.0);
        Article item2 = new Article("Teclado", 1, 35.0, 0.0);

        miPedido.addArticle(item1);
        miPedido.addArticle(item2);
        double esperado = 50.0;
        double resultado = miPedido.getGrossTotal();
        assertEquals(esperado, resultado, 0.01);
    }

    @Test
    public void comprobarCalculoTotalConDescuento() {
        Order miPedido = new Order();
        miPedido.setId("PED-102");

        /*
        ej practico:     Raton: 15 = 15€. (se le restaria 0%)
                        Teclado: 35 - 20% = 28€
                        Total esperado = 43€
        
        */
         Article item1 = new Article("Raton USB", 1, 15.0, 0.0);
        Article item2 = new Article("Teclado", 1, 35.0, 20.0);

        miPedido.addArticle(item1);
        miPedido.addArticle(item2);
        double esperado = 43.0;
        double resultado = miPedido.getDiscountedTotal();
        assertEquals(esperado, resultado, 0.01);

      
    }
}