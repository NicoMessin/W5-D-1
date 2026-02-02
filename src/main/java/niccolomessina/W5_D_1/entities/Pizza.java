package niccolomessina.W5_D_1.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Menu {

    private static final String BASE = "tomato, cheese";
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String comboName, int baseCalories, double basePrice, List<Topping> toppings) {
        super(comboName, baseCalories, basePrice);
        this.toppings.addAll(toppings);

        for (Topping t : toppings) {
            setCalorie(getCalorie() + t.getCalorie());
            setPrezzo(getPrezzo() + t.getPrezzo());
        }
    }

    @Override
    public String getName() {
        if (toppings.isEmpty()) return super.getName() + " (" + BASE + ")";
        String extra = toppings.stream()
                .map(t -> t.getName().toLowerCase())
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        return super.getName() + " (" + BASE + ", " + extra + ")";
    }
}
