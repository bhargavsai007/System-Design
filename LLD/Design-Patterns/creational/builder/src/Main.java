/*

Need of Builder Pattern:-
                      The builder pattern is a popular design pattern that is used to separate the construction of an object from its representation.
It is particularly useful when the construction process is complex, or when there are multiple ways to create an object.
This can be the case when dealing with complex objects that have a large number of attributes or configurations.

Pros:-
    1. This method avoids the need for creating a large number of subclasses for all the combinations of optional attributes.
    2. This method avoids the problem of having a constructor with a large number of parameters, which is often considered a code smell.
    3. The builder pattern also avoids the telescopic constructor anti-pattern and the creation of too many constructors,
       which can make coding and maintenance difficult.

Cons:-
    The use of the builder pattern can make the code more verbose and harder to read,
    because it involves creating separate classes for the builder and the object being built.

E.g:- Requests/response entities in gRPC

*/

public class Main {
    public static void main(String[] args) {

        Student student = Student.getStudentBuilder()
                .setName("Tuffy")
                .setAge(25)
                .setPsp(99.00)
                .setUniversityName("XYZ")
                .setGradYear(2020)
                .build();

    }
}