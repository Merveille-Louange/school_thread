import models.Classroom;
import models.Student;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Student student_1 = new Student();
        Classroom class_1 = new Classroom("hil", 0);
        System.out.println(student_1.sitDown());


    }
}
