/*

Need of Observer Pattern:
    The Observer design pattern is used to define a one-to-many dependency between objects so that when one object (the subject) changes state, all its dependents (observers) are automatically notified and updated.
This pattern is particularly useful in scenarios where an event-driven architecture is needed, or when multiple objects need to stay in sync with changes in another object.

Pros:
	1.	Promotes loose coupling between the subject and its observers, making the system more maintainable.
	2.	Facilitates dynamic relationships, as observers can be added or removed at runtime.
	3.	Allows multiple objects to react to state changes in a centralized and consistent manner.
	4.	Supports event-driven programming, improving responsiveness and scalability.

Cons:
	1.	Can lead to unexpected behavior if not managed properly, especially with complex observer chains.
	2.	May result in performance overhead if there are too many observers or frequent state changes.
	3.	Debugging can be challenging, as it can be hard to trace which observers are notified and how they respond.
	4.	Risk of memory leaks if observers are not properly deregistered, especially in languages without automatic garbage collection.

E.g.: Observer pattern is often used in scenarios like:
	•	GUI components reacting to user events (e.g., buttons updating multiple views).
	•	Publish-subscribe mechanisms in messaging systems.
	•	Real-time updates in stock market applications or chat applications.

*/



public class Main {
    public static void main(String[] args) {

        NewsPublisher republic = new RepublicChannel();
        NewsPublisher indiaToday = new IndiaTodayChannel();
        NewsSubscriber hawkie = new Hawkie();
        NewsSubscriber zofer = new Zofer();

        republic.addSubscriber(hawkie);
//        republic.removeSubscriber(hawkie);
        republic.addSubscriber(zofer);
        republic.publishNews("2024 is over");

        indiaToday.addSubscriber(zofer);
        indiaToday.publishNews("2025 is started");

    }
}