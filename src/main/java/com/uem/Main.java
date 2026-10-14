package com.uem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream is = Main.class.getClassLoader().getResourceAsStream("orders.json");
            if (is != null) {
                List<Order> orders = mapper.readValue(is, new TypeReference<List<Order>>() {});
                for (Order order : orders) {
                    log.debug("Loaded order: {}", order.getId());
                }
            } else {
                log.error("no se puede encontrar el fichero orders.json");
            }
        } catch (Exception e) {
            log.error("error al leer el fichero de pedidos", e);
        }
    }
}
