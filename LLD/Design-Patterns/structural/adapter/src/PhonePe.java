/*

Need of Adapter Pattern:
                        The Adapter design pattern is used to bridge the gap between two incompatible interfaces, allowing them to work together.
It acts as a translator that adapts one interface to another, enabling classes with incompatible interfaces to interact seamlessly.
This pattern is particularly useful when integrating with legacy systems or third-party libraries that cannot be modified but need to be used with your application’s current codebase.

Pros:
	1.	Promotes reusability by enabling existing classes to work together without altering their source code.
	2.	Provides a clear separation of concerns by encapsulating the conversion logic within the adapter.
	3.	Facilitates the integration of new functionalities with minimal changes to the existing codebase.
	4.	Simplifies testing and maintenance by isolating the adaptation logic in one place.

Cons:
	1.	May increase code complexity as the number of adapters grows, especially in large systems.
	2.	Can potentially impact performance if the adaptation logic is computationally expensive.
	3.	Requires a thorough understanding of the interfaces being adapted, which may not always be straightforward.

E.g.: Adapter pattern is commonly used in scenarios like:
	•	Wrapping a legacy class to make it compatible with a modern API.
	•	Converting different data formats (e.g., adapting JSON responses to an application that works with XML).
	•	Implementing third-party library interfaces to fit with your application’s structure.

*/

public class PhonePe {

    public static void main(String[] args) {
        BankAPI bankAPI = new ICICIBankAdapter();
        String tuffyAccountNumber = "123480";
        String blackieAccountNumber = "435353";
        double amount = 1322;

        bankAPI.sendMoney(tuffyAccountNumber, blackieAccountNumber, amount);
    }
}
