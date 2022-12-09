package service.account;
import enums.AccountType;
import config.DBConnection;
import service.employee.EmployeeService;
import service.employee.EmployeeServiceImpl;

import java.sql.*;

//TODO: implement AccountService here
public class AccountServiceImpl implements AccountService {
    Connection connect;
    PreparedStatement ps;
    ResultSet result;
    final private EmployeeService employee;

    AccountServiceImpl(){
        employee=new EmployeeServiceImpl();
        connect=DBConnection.connect();
    }
    @Override
    public void createAccountByType(AccountType accountType, Double startAmount, Integer employeeId) {

        if(accountType.equals(AccountType.CHECKING_ACCOUNT)){
            employee.createNewChecking(startAmount,employeeId);
        }
        else if(accountType.equals(AccountType.SAVING_ACCOUNT)){
            employee.createNewSavings(startAmount,employeeId);
        }
        else if(accountType.equals(AccountType.RETIREMENT_ACCOUNT)){
            employee.createNewRetirement(startAmount,employeeId);
        }
        else{
            System.out.println("Please select the valid option");
        }

    }

    @Override
    public void deposit(AccountType acctType, double amt, Integer employeeId) {
        employee.deposit(acctType,amt,employeeId);

    }

    @Override
    public boolean withdraw(AccountType acctType, double amt, Integer employeeId) {
        boolean flag=false;
        if(employee.withdraw(acctType,amt,employeeId))
            flag=true;
        else
            System.out.println("Some error occurred");
        return flag;
    }

    @Override
    public String getFormattedAcctInfo(Integer employeeId) {
        return employee.getFormattedAcctInfo(employeeId);
    }
}
