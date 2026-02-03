

package niccolomessina.W5_D_1.runners;

import niccolomessina.W5_D_1.entities.Drink;
import niccolomessina.W5_D_1.entities.Menu;
import niccolomessina.W5_D_1.entities.MenuEffettivo;
import niccolomessina.W5_D_1.entities.Order;
import niccolomessina.W5_D_1.entities.Pizza;
import niccolomessina.W5_D_1.entities.TableStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrdersRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(OrdersRunner.class);

    private final MenuEffettivo menu;
    private final Order order;
    private final Pizza hawaiianPizza;
    private final Drink water;

    @Value("${coperto.cost}")
    private double coverCharge;

    public OrdersRunner(MenuEffettivo menu, Order order, Pizza hawaiianPizza, Drink water) {
        this.menu = menu;
        this.order = order;
        this.hawaiianPizza = hawaiianPizza;
        this.water = water;
    }

    @Override
    public void run(String... args) {


        log.info("=== MENU ===");
        menu.print();


        order.getTable().setStatus(TableStatus.OCCUPATO);

        order.addItem(hawaiianPizza);
        order.addItem(water);

        double total = order.getTotal(coverCharge);

        log.info("=== ORDER ===");
        log.info("Order #{} | Status {} | Time {}",
                order.getOrderNumber(),
                order.getStatus(),
                order.getAcquiredAt()
        );

        log.info("Table #{} | Max seats {} | Table status {} | Order seats {}",
                order.getTable().getNumber(),
                order.getTable().getMaxSeats(),
                order.getTable().getStatus(),
                order.getSeats()
        );

        double itemsTotal = 0.0;
        for (Menu item : order.getItems()) {
            log.info("- {} | cal {} | €{}",
                    item.getName(),
                    item.getCalorie(),
                    item.getPrezzo()
            );
            itemsTotal += item.getPrezzo();
        }

        double coverTotal = coverCharge * order.getSeats();

        log.info("Items total: €{}", itemsTotal);
        log.info("Cover charge: €{} x {} = €{}", coverCharge, order.getSeats(), coverTotal);
        log.info("TOTAL: €{}", total);
    }
}
