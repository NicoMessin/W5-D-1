package niccolomessina.W5_D_1.entities;

public abstract class Menu {
    private String name;
    private int calorie;
            private double prezzo;

            public Menu (String name, int calorie, double prezzo){
                this.name=name;
                this.calorie= calorie;
                this.prezzo=prezzo;
            }

            public String getName(){
                return name ;
            }

    public int getCalorie(){
        return calorie ;

            }


    public double getPrezzo(){
        return prezzo ;
    }

    // GETTER AND SETTER

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "calorie=" + calorie +
                ", name='" + name + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
