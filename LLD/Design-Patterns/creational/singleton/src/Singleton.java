public class Singleton {

    private Singleton() {
        System.out.println("Inside Singleton constructor");
    }

    private static class SingletonHelper {

        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {

        return SingletonHelper.INSTANCE;
    }
}
