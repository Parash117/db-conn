package service.student;

import config.DBConnection;
import model.student.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService{

    private Connection connection = DBConnection.connect();

    public int createStudent(Students students) {

        try {
            PreparedStatement sqlQuery = connection.prepareStatement("INSERT INTO students" +
                    "(id, name, roll_number, grade)VALUES ( ? , ? , ? , ?) ");
            sqlQuery.setLong(1, students.getId());
            sqlQuery.setString(2, students.getName());
            sqlQuery.setString(3, students.getRollNumber());
            sqlQuery.setString(4, students.getGrade());
            int count = sqlQuery.executeUpdate();
            System.out.println(count + " number of data inserted into student table.");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public Students getStudentById(Long id) {
        try {
            PreparedStatement sqlQuery = connection.prepareStatement("SELECT * FROM students WHERE id = ? ");
            sqlQuery.setLong(1, id);
            ResultSet resultSet = sqlQuery.executeQuery();
            resultSet.next();
            Students students = new Students().resultSetToDto(resultSet);
            /*students.setId(resultSet.getLong("id"));
            students.setName(resultSet.getString("name"));
            students.setGrade(resultSet.getString("grade"));
            students.setRollNumber(resultSet.getString("roll_number"));*/
            return students;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Students> getAllStudents() {
        try {
            PreparedStatement sqlQuery = connection.prepareStatement("SELECT * FROM students ");

            ResultSet resultSet = sqlQuery.executeQuery();

            List<Students> studentsList = new ArrayList<Students>();

            while(resultSet.next()) {
                Students students = new Students().resultSetToDto(resultSet);
                /*students.setId(resultSet.getLong("id"));
                students.setName(resultSet.getString("name"));
                students.setGrade(resultSet.getString("grade"));
                students.setRollNumber(resultSet.getString("roll_number"));*/
                studentsList.add(students);
            }
            return studentsList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Students updateStudent(Students students) {
        try {
            PreparedStatement getSqlQuery = connection.prepareStatement("SELECT * FROM students WHERE id = ? ");
            getSqlQuery.setLong(1, students.getId());

            ResultSet resultSet = getSqlQuery.executeQuery();
            if(!resultSet.next()){
                throw new RuntimeException("No record with the following id: "+students.getId());
            }

            PreparedStatement updateSqlQuery = connection.prepareStatement("UPDATE students" +
                    " set name = ? , roll_number = ? , grade = ? where id = ? ");
            updateSqlQuery.setString(1, students.getName());
            updateSqlQuery.setString(2, students.getRollNumber());
            updateSqlQuery.setString(3, students.getGrade());
            updateSqlQuery.setLong(4, students.getId());
            int count = updateSqlQuery.executeUpdate();
            System.out.println(count + " number of data inserted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteStudentById(Long id) {
        try {
            PreparedStatement getSqlQuery = connection.prepareStatement("SELECT * FROM students WHERE id = ? ");
            getSqlQuery.setLong(1, id);

            ResultSet resultSet = getSqlQuery.executeQuery();
            if(!resultSet.next()){
                throw new RuntimeException("No record with the following id: "+id);
            }
            PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM students where id = ? ");
            deleteQuery.setLong(1, id);
            deleteQuery.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private int ageCalculator(Date dob){
        //logic to calculate age from dob
        return 12;
    }
}
