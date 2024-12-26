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

