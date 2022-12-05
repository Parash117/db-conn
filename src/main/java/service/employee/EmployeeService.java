package service.employee;

import enums.AccountType;
import model.employe.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    void createNewChecking(Double startAmount, Integer employeeId);

    void createNewSavings(double startAmount, Integer employeeId);

    void createNewRetirement(double startAmount, Integer employeeId);

    void deposit(AccountType acctType, double amt, Integer employeeId);

    boolean withdraw(AccountType acctType, double amt, Integer employeeId);

    String getFormattedAcctInfo(Integer employeeId);

}
