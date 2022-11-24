package service.student;

import model.student.Students;

import java.util.List;

public interface StudentService {

    int createStudent(Students students);

    Students getStudentById(Long id);

    List<Students> getAllStudents();

    Students updateStudent(Students students);

    void deleteStudentById(Long id);

}
