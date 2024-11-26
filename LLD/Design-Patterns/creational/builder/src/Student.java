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

public class Student {

    private String name;
    private int age;
    private double psp;
    private String universityName;
    private int gradYear;

    public static StudentBuilder getStudentBuilder() {
        return new StudentBuilder();
    }

    private Student(StudentBuilder studentBuilder) {

        // validations start
        if (studentBuilder.getGradYear() < 2015)
            throw new IllegalArgumentException("Grad year cannot be less than 2015");
        // ....
        // ....
        // validations end

        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();
        this.gradYear = studentBuilder.getGradYear();
        this.psp = studentBuilder.getPsp();
        this.universityName = studentBuilder.getUniversityName();

        System.out.println("New student is created");
    }

    // Student Builder
    public static class StudentBuilder {

        private String name;
        private int age;
        private double psp;
        private String universityName;
        private int gradYear;

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public StudentBuilder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public StudentBuilder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

