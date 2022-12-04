package service.account;

import enums.AccountType;

//TODO: implement AccountService here
public class AccountServiceImpl implements AccountService {
    @Override
    public void createAccountByType(AccountType accountType, Double startAmount, Integer employeeId) {

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
