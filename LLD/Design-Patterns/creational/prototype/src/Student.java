public class Student implements Prototype<Student> {

    private String name;
    private int age;
    private double psp;
    private String batch;
    private double batchAvgPsp;

//    Intentionally removed some getters
//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getAge() {
//        return age;
//    }

    public void setAge(int age) {
        this.age = age;
    }

//    public double getPsp() {
//        return psp;
//    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getBatchAvgPsp() {
        return batchAvgPsp;
    }

    public void setBatchAvgPsp(double batchAvgPsp) {
        this.batchAvgPsp = batchAvgPsp;
    }

    public Student() {
    }

    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.psp = student.psp;
        this.batchAvgPsp = student.batchAvgPsp;
        this.batch = student.batch;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }
}
