public class Maps {

    private final String fromLocation;
    private final String toLocation;
    private final Path path;

    public Maps(String fromLocation, String toLocation, Path path) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.path = path;
    }

    public void findPath() {
        PathCalculatorStrategy pathCalculatorStrategy = PathCalculatorFactory.getPathCalculator(path);
        pathCalculatorStrategy.findPath(fromLocation, toLocation);
    }
}
