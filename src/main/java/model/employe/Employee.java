package model.employe;

import model.account.Account;
import model.student.Students;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Employee {

    private Integer id;

    private String name;

    private Timestamp hireDate;

    private List<Account> accounts;

    public Employee(){

    }

    public Employee(Integer id, String name, Timestamp hireDate) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
    }

    public Employee(Integer id, String name, Timestamp hireDate, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.hireDate = hireDate;
        this.accounts = accounts;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hireDate=" + hireDate +
                ", accounts=" + accounts +
                '}';
    }
}
