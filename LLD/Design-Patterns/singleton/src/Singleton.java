
/*

Bill Pugh Singleton Implementation

When the singleton class is loaded, inner class is not loaded and hence doesn’t create object when loading the class.
Inner class is created only when getInstance() method is called.
So it may seem like eager initialization, but it is lazy initialization.
This is the most widely used approach as it doesn’t use synchronization.
Because The whole process of initialising a class will be synchronised by the JVM.

Need of Singleton:-
    1. When object creation is expensive.
    2. When we want immutable objects.

E.g:- DB connections, logging, caching etc

Pros:-
    Efficient resource utilisation

Cons:-
    It's hard to unit-test the Singleton classes as we can't mock the objects.
*/

public class Singleton {

    private Singleton(){
        System.out.println("Inside Singleton constructor");
    }

    private static class SingletonHelper{

        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){

        return SingletonHelper.INSTANCE;
    }
}
