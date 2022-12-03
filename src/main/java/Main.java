import config.DBConnection;
import enums.AccountType;
import model.account.Account;
import model.employe.Employee;
import model.student.Students;
import service.student.StudentService;
import service.student.StudentServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

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
//        StudentService studentService = new StudentServiceImpl();
//        Students students = studentService.getStudentById(2L);
//        System.out.println(students.toString());

//        List<Students> studentsList = studentService.getAllStudents();
//
//        for(Students students1 : studentsList){
//            System.out.println(students1.toString());
//        }

//        Students studentTobeUpdated = new Students();
//        studentTobeUpdated.setId(1L);
//        studentTobeUpdated.setName("Suresh Lama Lama");
//        studentTobeUpdated.setRollNumber("1010ZZ");
//        studentTobeUpdated.setGrade("7th Semeter");
//        studentService.updateStudent(studentTobeUpdated);
//        studentService.deleteStudentById(1L);

        /*List<String> stringList = new ArrayList<String>();
        stringList.add("A");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        stringList.add("f");

        stringList.stream().forEach( (x) -> System.out.println(x));


        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);


        List<String> integerToStringList = integerList.stream().map( x -> String.valueOf(x) ).collect(Collectors.toList());

        integerList.stream().forEach( x-> {
            System.out.println(x);
            if(x instanceof Integer){
                System.out.println(x+" is a int type");
            }
        });


        List<Employee> employeeList = new ArrayList<>();

        employeeList.add( new Employee(1, "Ram", new Timestamp(new Date().getTime())) );
        employeeList.add( new Employee(2, "Sam", new Timestamp(new Date().getTime())) );
        employeeList.add( new Employee(3, "vim", new Timestamp(new Date().getTime())) );
        employeeList.add( new Employee(4, "Ubuntu", new Timestamp(new Date().getTime())) );
        employeeList.add( new Employee(5, "Duke", new Timestamp(new Date().getTime())) );
        employeeList.add( new Employee(6, "Lux", new Timestamp(new Date().getTime())) );
        employeeList.add( new Employee(7, "Gin", new Timestamp(new Date().getTime())) );

        List<String> nameList = new ArrayList<>();

        for(Employee employee : employeeList){
            nameList.add(employee.getName());
        }



        List<String> nameList2 = employeeList.stream()
                .filter(x-> x.getName().equalsIgnoreCase("lux") )
                .map( employee -> employee.getName())
                .collect(Collectors.toList());

        System.out.println();*/

        /*Integer a = 128;
        Integer b = 128;

        if(a.equals(b)){
            System.out.println("a equals to b");
        }else {
            System.out.println("a not equals to b");
        }*/

        /*Account account = new Account(20, AccountType.CHECKING_ACCOUNT, 104);
        Account account2 = new Account(20, AccountType.CHECKING_ACCOUNT, 104);


        if(account.equals(account2)){
            System.out.println("account equals to account2");
        }else {
            System.out.println("account not equals to account2");
        }

        Set<Account> accountSet = new HashSet<>();
        accountSet.add(account);
        accountSet.add(account2);


        System.out.println();*/

//        String str = "APPLE";
//        String str2 = new String("APPLE");
//        String str3 = "APPLE";
//
//        if(str == (str2)){
//            System.out.println("account equals to account2");
//        }else {
//            System.out.println("account not equals to account2");
//        }

        DBConnection.connect();
        StudentService s = new StudentServiceImpl();

        Students st = new Students();
        st.setId(2L);
        st.setName("don donis me");
        st.setGrade("third");
        st.setRollNumber("21");

        s.createStudent(st);

    }

}
