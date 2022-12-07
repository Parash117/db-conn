package service.employee;

import enums.AccountType;
import model.account.Account;
import model.employe.Employee;

import java.util.List;

public interface EmployeeService {

    int createEmployee(Employee employee);

    void createNewChecking(Double startAmount, Integer employeeId);

    void createNewSavings(double startAmount, Integer employeeId);

    void createNewRetirement(double startAmount, Integer employeeId);

    void deposit(AccountType acctType, double amt, Integer employeeId);

    boolean withdraw(AccountType acctType, double amt, Integer employeeId);

    List<Account> getFormattedAcctInfo(Integer employeeId);

}
