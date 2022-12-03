import config.DBConnection;
import enums.AccountType;
import model.account.Account;
import model.employe.Employee;
import model.student.Students;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;
import service.student.StudentService;
import service.student.StudentServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        StudentService objOfStudentService = new StudentServiceImpl();
        Students objOfStudents = new Students();
        objOfStudents.setId(2L);
        objOfStudents.setName("Gyalbu Don");
        objOfStudents.setRollNumber("101");
        objOfStudents.setGrade("A+");

        objOfStudentService.createStudent(objOfStudents);
//
//        DBConnection.connect(); checking connection for first time
        Timestamp instant= Timestamp.from(Instant.now());
        EmployeeService objOfEmployeeService=new EmployeeServiceImpl();
        Employee objOfEmployee =new Employee(2,"Hari",instant);
        objOfEmployeeService.createEmployee(objOfEmployee);

    }

}
