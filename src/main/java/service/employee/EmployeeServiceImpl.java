package service.employee;

import config.DBConnection;
import enums.AccountType;
import model.employe.Employee;
import model.student.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//TODO: implement EmployeeService
public class EmployeeServiceImpl implements EmployeeService{



    private Connection connection = DBConnection.connect();

    public int createEmployee(Employee employee) {

        try {
            PreparedStatement sqlQuery = connection.prepareStatement("INSERT INTO employeetable" +
                    "(empId, empName, hiredDate)VALUES ( ? , ? , ? ) ");
            sqlQuery.setLong(1, employee.getId());
            sqlQuery.setString(2, employee.getName());
            sqlQuery.setTimestamp(3, employee.getHireDate());
            int count = sqlQuery.executeUpdate();
            System.out.println(count + " number of data inserted into employee table");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public void createNewChecking(Double startAmount, Integer employeeId) {

    }

    @Override
    public void createNewSavings(double startAmount, Integer employeeId) {

    }

    @Override
    public void createNewRetirement(double startAmount, Integer employeeId) {

    }

    @Override
    public void deposit(AccountType acctType, double amt, Integer employeeId) {

    }

    @Override
    public boolean withdraw(AccountType acctType, double amt, Integer employeeId) {
        return false;
    }

    @Override
    public String getFormattedAcctInfo(Integer employeeId) {
        return null;
    }
}
