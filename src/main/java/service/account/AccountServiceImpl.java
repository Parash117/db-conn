package service.account;

import config.DBConnection;
import enums.AccountType;
import model.account.Account;
import model.student.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO: implement AccountService here
public class AccountServiceImpl implements AccountService {
    private final Connection connection = DBConnection.connect();

    @Override
    public Account createAccountByType(AccountType accountType, Double startAmount, Integer employeeId) {
        Long accountId = null;
        try {
            PreparedStatement sqlQuery = connection.prepareStatement("INSERT INTO account" +
                    "(balance, account_type, employee_id)VALUES ( ? , ? , ? ) ");
            sqlQuery.setDouble(1, startAmount);
            sqlQuery.setString(2, accountType.toString());
            sqlQuery.setLong(3, employeeId);
            int count = sqlQuery.executeUpdate();
            ResultSet rs = sqlQuery.getGeneratedKeys();
            if(rs.next()){
                accountId = rs.getLong(1);
            }
            System.out.println(count + " number of data inserted");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        Account account = new Account();
        account.getAccountId();
        account.setAccountType(accountType);
        account.setBalance(startAmount);
        account.setEmployeeId(employeeId);
        return account;
    }

    @Override
    public void deposit(AccountType acctType, double amt, Integer employeeId) {
        Double balance = null;
        try {
            PreparedStatement sqlQuery = connection.prepareStatement("SELECT * FROM account WHERE employee_id = ? and account_type = ? ");
            sqlQuery.setLong(1, employeeId);
            sqlQuery.setString(2, acctType.toString());
            ResultSet resultSet = sqlQuery.executeQuery();
            if(resultSet.next()){
                balance = Double.valueOf(resultSet.getDouble("balance"));
                balance = Double.sum(balance, amt);
            }
            System.out.println("deposit Amount = "+(balance));
            /*students.setId(resultSet.getLong("id"));
            students.setName(resultSet.getString("name"));
            students.setGrade(resultSet.getString("grade"));
            students.setRollNumber(resultSet.getString("roll_number"));*/
            ;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
