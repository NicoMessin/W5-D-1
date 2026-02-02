package niccolomessina.W5_D_1.entities;



import java.util.List;

public class MenuEffettivo {
    private final List<Pizza> pizzas;
    private final List<Topping> toppings;
    private final List<Drink> drinks;

    public MenuEffettivo(List<Pizza> pizzas, List<Topping> toppings, List<Drink> drinks) {
        this.pizzas = pizzas;
        this.toppings = toppings;
        this.drinks = drinks;
    }

    public void print() {
        System.out.println("== MENU ==");

        System.out.println("Pizzas");
        System.out.printf("%-55s %10s %10s%n", "", "Calories", "Price");
        for (Pizza p : pizzas) {
            System.out.printf("%-55s %10d %10.2f%n", p.getName(), p.getCalorie(), p.getPrezzo());
        }

        System.out.println("Toppings");
        System.out.printf("%-55s %10s %10s%n", "", "Calories", "Price");
        for (Topping t : toppings) {
            System.out.printf("%-55s %10d %10.2f%n", t.getName(), t.getCalorie(), t.getPrezzo());
        }

        System.out.println("Drinks");
        System.out.printf("%-55s %10s %10s%n", "", "Calories", "Price");
        for (Drink d : drinks) {
            System.out.printf("%-55s %10d %10.2f%n", d.getName(), d.getCalorie(), d.getPrezzo());
        }

        System.out.println();
    }
}