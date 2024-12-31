/*

The Decorator design pattern is used to dynamically add new functionality to an object without modifying its structure.
It provides a flexible alternative to subclassing for extending functionality, allowing behavior to be added at runtime.
This pattern is particularly useful when you want to adhere to the open/closed principle, where classes are open for extension but closed for modification.

Pros:
	1.	Provides a flexible and reusable way to extend an object’s functionality without altering its structure.
	2.	Avoids creating a large hierarchy of subclasses for every possible combination of behavior.
	3.	Enhances code maintainability by keeping the responsibilities of classes focused and separated.
	4.	Allows dynamic composition of behaviors at runtime, providing great flexibility.

Cons:
	1.	Can make the code more complex and harder to understand, especially when multiple decorators are stacked.
	2.	Debugging can become challenging, as the decorated object’s behavior may involve multiple layers.
	3.	May introduce performance overhead due to the additional layers of wrapping and delegation.

E.g.: Decorator pattern is often used in scenarios like:
	•	Adding scrollbars to a graphical user interface window object dynamically.
	•	Logging, caching, or input validation in a web application pipeline.
	•	Extending the behavior of a text editor (e.g., adding syntax highlighting, spell checking).

*/


public class PizzaOrder {
    public static void main(String[] args) {

        Pizza pizza1 = new Olive(new Olive(new Paneer(new Cheese(new Tomato(new BBQChicken())))));
        System.out.println(pizza1.getCost());

        System.out.println(pizza1.getDescription());

        System.out.println("-------------------");

        Pizza pizza2 = new Olive(new Cheese(new Paneer(new Paneer(new Tomato(new Margherita())))));
        System.out.println(pizza2.getCost());

        System.out.println(pizza2.getDescription());
    }
}
