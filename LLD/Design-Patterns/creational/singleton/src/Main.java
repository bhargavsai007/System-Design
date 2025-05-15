/*

Double-Checked Locking Singleton Implementation

When the singleton instance is accessed, the check for null is done without locking to improve performance.
Only if the instance is null, synchronization is used to prevent multiple threads from creating separate instances.
Inside the synchronized block, the instance is checked again before creating the object — ensuring only one instance is created.
So it may seem like overhead due to synchronization, but it actually avoids locking in most calls.
This is a popular approach as it combines lazy initialization with thread safety.

Need of Singleton:-
    1. When object creation is expensive.
    2. When we want immutable objects.

E.g:- DB connections, logging, caching etc

Pros:-
    Efficient resource utilisation

Cons:-
    It's hard to unit-test the Singleton classes as we can't mock the objects.
*/

public class Main {
    public static void main(String[] args) {

        // Accessing singleton
        Singleton.getInstance();
    }
}