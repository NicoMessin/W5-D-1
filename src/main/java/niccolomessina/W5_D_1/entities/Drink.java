package niccolomessina.W5_D_1.entities;

public class Drink extends Menu {
    private final String size;

    public Drink(String name, String size, int calories, double price) {
        super(name, calories, price);
        this.size = size;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
