package niccolomessina.W5_D_1.config;

import com.github.javafaker.Faker;
import niccolomessina.W5_D_1.entities.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigClass {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Value("${coperto.cost}")
    private double coverCharge;

    // ===== TABLE =====
    @Bean
    public Table table1() {
        return new Table(1, 4, TableStatus.LIBERO);
    }

    // ===== ORDER =====
    @Bean
    @Scope("prototype")
    public Order order(Table table1) {
        return new Order(1, table1, 2);
    }

    // ================= TOPPINGS =================
    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 92, 0.69);
    }

    @Bean
    public Topping ham() {
        return new Topping("Ham", 35, 0.99);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 24, 0.79);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 22, 0.69);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 86, 0.99);
    }

    // ================= DRINKS =================
    @Bean
    public Drink water() {
        return new Drink("Water", "0.5l", 0, 1.29);
    }

    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade", "0.33l", 128, 1.29);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine", "0.75l, 13%", 607, 7.49);
    }

    // ================= PIZZAS =================
    @Bean
    public Pizza margherita() {
        return new Pizza("Pizza Margherita", 1008, 4.99, List.of());
    }

    @Bean
    public Pizza hawaiianPizza(Topping ham, Topping pineapple) {
        return new Pizza("Hawaiian Pizza", 1008, 4.99, List.of(ham, pineapple));
    }

    @Bean
    public Pizza salamiPizza(Topping salami) {
        return new Pizza("Salami Pizza", 1008, 4.99, List.of(salami));
    }

    @Bean
    public Pizza margheritaDoubleHam(Topping ham) {
        return new Pizza("Margherita + Double Ham", 1008, 4.99, List.of(ham, ham));
    }

    // ================= MENU =================
    @Bean
    public MenuEffettivo menu(
            Pizza margherita,
            Pizza hawaiianPizza,
            Pizza salamiPizza,
            Pizza margheritaDoubleHam,
            Topping cheese,
            Topping ham,
            Topping pineapple,
            Topping onions,
            Topping salami,
            Drink water,
            Drink lemonade,
            Drink wine
    ) {
        return new MenuEffettivo(
                List.of(margherita, hawaiianPizza, salamiPizza, margheritaDoubleHam),
                List.of(cheese, ham, pineapple, onions, salami),
                List.of(water, lemonade, wine)
        );
    }
}
