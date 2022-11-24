package model.student;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {

    private Long id;

    private String name;

    private String rollNumber;

    private String grade;

    public Students resultSetToDto(ResultSet resultSet) throws SQLException {
        Students students = new Students();
        students.setId(resultSet.getLong("id"));
        students.setName(resultSet.getString("name"));
        students.setGrade(resultSet.getString("grade"));
        students.setRollNumber(resultSet.getString("roll_number"));
        return students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
