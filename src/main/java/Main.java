import config.DBConnection;
import model.student.Students;
import service.student.StudentService;
import service.student.StudentServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*StudentService studentService = new StudentServiceImpl();

        Students students = new Students();
        students.setId(2L);
        students.setName("Suresh Lama");
        students.setRollNumber("10010AA");
        students.setGrade("7th Semeter");

        studentService.createStudent(students);*/
//        BlobService blobService = new BlobService();
//        blobService.insertBlob();
//
        StudentService studentService = new StudentServiceImpl();
//        Students students = studentService.getStudentById(2L);
//        System.out.println(students.toString());

//        List<Students> studentsList = studentService.getAllStudents();
//
//        for(Students students1 : studentsList){
//            System.out.println(students1.toString());
//        }

        Students studentTobeUpdated = new Students();
        studentTobeUpdated.setId(1L);
        studentTobeUpdated.setName("Suresh Lama Lama");
        studentTobeUpdated.setRollNumber("1010ZZ");
        studentTobeUpdated.setGrade("7th Semeter");
        studentService.updateStudent(studentTobeUpdated);
        studentService.deleteStudentById(1L);
    }

}
