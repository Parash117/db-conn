package model.account;

import enums.AccountType;
import model.employe.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {

    private Integer accountId;

    private AccountType accountType;

    private String accountTypeString;

    private Integer employeeId;

    private Employee employee;

    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(){

    }

    public Account(Integer accountId, AccountType accountType, Integer employeeId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.employeeId = employeeId;
    }
    public Account resultSetToDto(ResultSet resultSet) throws SQLException {
        Account account= new Account();
        account.setBalance(resultSet.getDouble("balance"));
        account.setAccountId(resultSet.getInt("account_id"));
        account.setAccountType(AccountType.valueOf(resultSet.getString("account_type")));
        return account;

    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getAccountTypeString() {
        return accountTypeString;
    }

    public void setAccountTypeString(String accountTypeString) {
        this.accountTypeString = accountTypeString;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
