/*


Need of Prototype Pattern:-
                      Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time and resources, and you have a similar object already existing.
Prototype pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs. Prototype design pattern uses java cloning to copy the object.

Pros:-
   Efficient Object Creation: The Prototype pattern enables efficient object creation by allowing objects to be cloned rather than instantiated from scratch.
   This can significantly improve performance, especially when creating complex objects.

   Reduced Subclassing: Instead of creating subclasses to generate different object variations, the Prototype pattern promotes object cloning.
   This reduces the need for extensive subclassing, simplifying the class hierarchy and making the codebase more maintainable.

Cons:-
    For projects, which require few number of objects, implementing prototype patterns can be an overkill.
    When we use the Prototype Design pattern, every subclass must implement the clone() method and in some cases, this implementation can be difficult.

E.g:- Any requirement to create multiple objects of similar kind with very few modifications.

*/

public class Main {

    private static void fillRegistry(StudentRegistry studentRegistry) {
        Student nov24BatchStudent = new Student();
        nov24BatchStudent.setBatch("Nov 22 Intermediate");
        nov24BatchStudent.setBatchAvgPsp(75.0);

        studentRegistry.register("nov24Batch", nov24BatchStudent);

        IntelligentStudent nov24BatchIntelligentStudent = new IntelligentStudent();
        nov24BatchIntelligentStudent.setBatch("Nov 22 Intermediate");
        nov24BatchIntelligentStudent.setBatchAvgPsp(95.0);
        nov24BatchIntelligentStudent.setIq(150);

        studentRegistry.register("nov24BatchIntelligentStudent", nov24BatchIntelligentStudent);
    }

    public static void main(String[] args) {

        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        // Let's assume Tuffy belongs to nov24Batch
        Student tuffy = studentRegistry.get("nov24Batch").clone();
        tuffy.setName("Tuffy");
        tuffy.setAge(5);
        tuffy.setPsp(89.0);

        // Let's assume Zofer belongs to nov24Batch
        Student zofer = studentRegistry.get("nov24Batch").clone();
        zofer.setName("Zofer");
        zofer.setAge(4);
        zofer.setPsp(93.0);

        // Assume that Hawkie is an intelligent student
        Student hawkie = studentRegistry.get("nov24BatchIntelligentStudent").clone();
        hawkie.setName("Hawkie");
        hawkie.setAge(3);
        hawkie.setPsp(99.0);
    }
}