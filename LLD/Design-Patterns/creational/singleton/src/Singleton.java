
/*
The volatile keyword is a modifier that ensures that an attribute's value is always the same when read from all threads.

Normally the value of an attribute may be written into a thread's local cache and not updated in the main memory for some amount of time.
In this case, other threads will see a different value for the attribute.
The volatile keyword makes sure that threads always update the value of an attribute in main memory.
*/

public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {
        System.out.println("Inside Singleton constructor");
    }

    public static Singleton getInstance() {

        if(instance==null){

            synchronized (Singleton.class){

                if(instance == null)
                    instance = new Singleton();
            }
        }

        return instance;
    }
}
