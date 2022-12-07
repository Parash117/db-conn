package service.account;

import enums.AccountType;
import model.account.Account;
import model.employe.Employee;

public interface AccountService {

    Account createAccountByType(AccountType accountType, Double startAmount, Integer employeeId);

    void deposit(AccountType acctType, double amt, Integer employeeId);

    boolean withdraw(AccountType acctType, double amt, Integer employeeId);

    String getFormattedAcctInfo(Integer employeeId);

}
