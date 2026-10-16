package com.uem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Order;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = Main.class.getClassLoader().getResourceAsStream("orders.json");
            if (is != null) {
                List<Order> orders = mapper.readValue(is, new TypeReference<List<Order>>() {});
                for (Order order : orders) {
                    log.fine("Loaded order: " + order.getId());
                }
            } else {
                log.severe("no se puede encontrar el fichero orders.json");
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "error al leer el fichero de pedidos", e);
        }
    }
}
