package service.employee;

import config.DBConnection;
import enums.AccountType;
import model.account.Account;
import model.employe.Employee;
import service.account.AccountService;
import service.account.AccountServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//TODO: implement EmployeeService
public class EmployeeServiceImpl implements EmployeeService{

    AccountService accountService = (AccountService) new AccountServiceImpl();
    Connection connection = DBConnection.connect();
    public Employee createEmployee(Employee employee) {

        try {
            PreparedStatement sqlQuery = connection.prepareStatement("INSERT INTO employee" +
                    "(id, employee_name, hireDate)VALUES ( ? , ? , ? ) ");
            sqlQuery.setLong(1, employee.getId());
            sqlQuery.setString(2, employee.getName());
            sqlQuery.setTimestamp(3, employee.getHireDate());
            int count = sqlQuery.executeUpdate();
            System.out.println(count + " number of data inserted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public void createNewChecking(Double startAmount, Integer employeeId) {
        accountService.createAccountByType(AccountType.CHECKING_ACCOUNT,startAmount,employeeId);

    }

    public void createNewSavings(double startAmount, Integer employeeId) {
        accountService.createAccountByType(AccountType.SAVING_ACCOUNT,startAmount,employeeId);
    }

    public void createNewRetirement(double startAmount, Integer employeeId) {
        accountService.createAccountByType(AccountType.RETIREMENT_ACCOUNT,startAmount,employeeId);
    }

    public void deposit(AccountType acctType, double amt, Integer employeeId) {
        accountService.deposit(acctType,amt,employeeId);
    }

    public boolean withdraw(AccountType acctType, double amt, Integer employeeId) {
        return false;
    }

    public String getFormattedAcctInfo(Integer employeeId) {
        try {
            PreparedStatement getSqlQuery = connection.prepareStatement("SELECT * FROM account WHERE employeeId = ? ");
            getSqlQuery.setLong(1, employeeId);

            ResultSet resultSet = getSqlQuery.executeQuery();
            if(!resultSet.next()){
                throw new RuntimeException("No record with the following id: "+employeeId);
            }
            PreparedStatement deleteQuery = connection.prepareStatement("DELETE FROM account where id = ? ");
            deleteQuery.setLong(1, employeeId);
            deleteQuery.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
