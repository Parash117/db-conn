package model.account;

import enums.AccountType;
import model.employe.Employee;

import java.util.Objects;

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

    public Account() {
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account(Integer accountId, AccountType accountType, Integer employeeId) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.employeeId = employeeId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId.equals(account.accountId) &&
                accountType == account.accountType &&
                employeeId.equals(account.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountType, employeeId);
    }
}
