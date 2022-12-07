package service.account;

import enums.AccountType;
import model.account.Account;

public class SpecialSavingAccountServiceImpl implements AccountService {


    @Override
    public Account createAccountByType(AccountType accountType, Double startAmount, Integer employeeId) {
        return null;
    }

    @Override
    public void deposit(AccountType acctType, double amt, Integer employeeId) {
        amt = addBonusOnEveryDeposit(amt);

    }

    @Override
    public boolean withdraw(AccountType acctType, double amt, Integer employeeId) {
        return false;
    }

    @Override
    public String getFormattedAcctInfo(Integer employeeId) {
        return null;
    }

    private double addBonusOnEveryDeposit(double amt) {
        return 0.05D * amt;
    }
}
