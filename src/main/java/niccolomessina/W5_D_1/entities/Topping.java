package niccolomessina.W5_D_1.entities;

public class Topping extends Menu {

    public Topping (String name, int calorie, double prezzo){
        super(name, calorie, prezzo);
    }


    @Override
    public String toString() {
        return "Topping{}";
    }
}

