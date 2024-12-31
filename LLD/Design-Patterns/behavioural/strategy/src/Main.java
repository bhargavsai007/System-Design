/*

The Strategy design pattern is used to define a family of algorithms, encapsulate each one, and make them interchangeable.
This pattern enables selecting an algorithm’s behavior at runtime without modifying the classes that use it.
It is particularly useful when multiple algorithms or behaviors need to be applied to a specific task, and these algorithms can be swapped dynamically.

Pros:
	1.	Promotes the open/closed principle by allowing new strategies to be added without modifying existing code.
	2.	Simplifies unit testing as each strategy is encapsulated in its own class.
	3.	Encourages the reuse of algorithms by separating them from the context they are used in.
	4.	Provides a clean way to handle complex conditional statements by delegating logic to different strategy implementations.

Cons:
	1.	Increases the number of classes in the system, which can add complexity.
	2.	Context objects can become more complex if they need to manage multiple strategies or dynamically change them.
	3.	Strategies can sometimes expose details about their implementation, potentially violating encapsulation.

E.g.: Strategy pattern is commonly used in scenarios like:
	•	Sorting algorithms in a collection framework (e.g., different comparators for sorting).
	•	Payment methods in e-commerce systems (e.g., credit card, PayPal, cryptocurrency).
	•	Handling different compression techniques (e.g., ZIP, RAR, GZIP).

*/



public class Main {
    public static void main(String[] args) {

        Maps maps = new Maps("Delhi", "Vijayawada", Path.BIKE);
        maps.findPath();

    }
}