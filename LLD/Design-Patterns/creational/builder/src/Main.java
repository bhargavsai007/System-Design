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