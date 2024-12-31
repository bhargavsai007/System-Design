public class Tomato implements Pizza {

    private final Pizza pizza;

    public Tomato(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Tomato";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }
}
