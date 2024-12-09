import component.button.Button;
import component.menu.Menu;

/*

Need of Factory Design Pattern:-
           A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of the class.
           The Factory Method Pattern is also known as Virtual Constructor. A Factory returns an instance of an object based on the data supplied to it.
           The instance returned can be one of many classes that extend a common parent class or interface. ("Animal" as a parent class, then "Dog", "Cat", "Zebra" as child classes.) Create objects without exposing their instantiation logic.
           Consequences: The client is independent of the concrete object that is created (how that object is created, and which class is actually created).

Pros:-
    1. Factory Method Pattern allows the sub-classes to choose the type of objects to create.
    2. It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. That means the code
       interacts solely with the resultant interface or abstract class, so that it will work with any classes that implement that interface or that extends
       that abstract class.

Cons:-
    1. Can lead to an explosion of subclasses if there are many variations of products.
    2. Increases complexity in the codebase, especially when dealing with multiple factories and product types.
    3. May introduce runtime errors if the factory method is not implemented properly or if there are inconsistencies in product creation logic across subclasses.

E.g:- Payment Gateways
	•	Scenario: Integrating multiple payment gateways such as PayPal, Stripe, or Razorpay.
	•	Example: Based on the selected payment provider, the factory returns the correct gateway implementation.

*/

public class Main {
    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.createUIFactory(SupportedPlatform.IOS);

        Button button = uiFactory.createButton();
        button.changeSize();

        Menu menu = uiFactory.createMenu();
        menu.changeMenu();
    }
}