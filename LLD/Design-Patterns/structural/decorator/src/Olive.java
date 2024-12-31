public class Olive implements Pizza {

    private final Pizza pizza;

    public Olive(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Olive";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }
}
