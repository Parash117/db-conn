package service.account;

import enums.AccountType;

public class SpecialSavingAccountServiceImpl implements AccountService{


    @Override
    public void createAccountByType(AccountType accountType, Double startAmount, Integer employeeId) {

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

    private double addBonusOnEveryDeposit(double amt){
        return 0.05D*amt;
    }
}
