import entities.Stipend;
import entities.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
public class App {
    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();

        Student student1 = new Student("Ivan Ivanov", "1201");
        Student student2 = new Student("Ivan Petroc", "1202");
//        Student student3 = new Student("Petrov Petroc", "1203");
        Stipend stipend1 = new Stipend(1000);
        Stipend stipend2 = new Stipend(0);
        student1.setStipend(stipend1);
        student2.setStipend(stipend2);
        System.out.println("start save");
        studentService.save(student1);
        studentService.save(student2);
//        studentService.save(student2);
//        studentService.save(student3);
        List<Student> students = studentService.findWihOutStipend();
        for (Student student : students) {
            System.out.println(student);
        }


    }

}
