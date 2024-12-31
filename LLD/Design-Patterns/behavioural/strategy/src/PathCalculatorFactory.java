public class PathCalculatorFactory {

    public static PathCalculatorStrategy getPathCalculator(Path path) {
        if (path.name().equals("WALK"))
            return new WalkPathCalculator();
        else if (path.name().equals("BIKE")) {
            return new BikePathCalculator();
        } else
            return new CarPathCalculator();
    }
}
