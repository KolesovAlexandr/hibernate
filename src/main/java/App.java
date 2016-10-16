import entities.Stipend;
import entities.Student;
import org.h2.tools.RunScript;
import service.StipendService;
import service.StudentService;
import service.impl.StipendServiceImpl;
import service.impl.StudentServiceImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        generateDB();
        StudentServiceImpl studentService = new StudentServiceImpl();
        StipendServiceImpl stipendService = new StipendServiceImpl();
        Student student1 = new Student("Ivan Ivanov", "1201");
        Student student2 = new Student("Ivan Petroc", "1202");
        Stipend stipend1 = new Stipend(1000);
        Stipend stipend2 = new Stipend(0);
        student1.setStipend(stipend1);
        student2.setStipend(stipend2);
        System.out.println("start save");
        studentService.save(student1);
        studentService.save(student2);
        System.out.println("students without stipend");
        List<Student> students = studentService.findWihOutStipend();
        for (Student student : students) {
            System.out.println(student);
        }


    }

    public static void generateDB() throws ClassNotFoundException, SQLException, FileNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:./db/repository", "", "");
        RunScript.execute(conn, new FileReader("src/main/resources/database.sql"));
        conn.close();
    }

}
