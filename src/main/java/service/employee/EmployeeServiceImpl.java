package service.employee;

import enums.AccountType;
import model.employe.Employee;


import config.DBConnection;
import model.employe.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.valueOf;

//TODO: implement EmployeeService
public class EmployeeServiceImpl {

   private Connection connection=DBConnection.connect();


    public int createEmployee(Employee employee){

        try{
            PreparedStatement sqlQuery=connection.prepareStatement("INSERT INTO employee"+"(name , hire_date)VALUES (?,?)");
            sqlQuery.setString(1,employee.getName());
            sqlQuery.setTimestamp(2,employee.getHireDate());
            int count=sqlQuery.executeUpdate();
            System.out.println("Number of data inserted is"+ count);
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return 0;

    }

    public void createNewChecking(Double startAmount, Integer employeeId){
        try{
            PreparedStatement sqlQuery=connection.prepareStatement("INSERT INTO account"+ "(balance,account_type,employee_id)VALUES (?,?,?)");
            sqlQuery.setDouble(1,startAmount);
            sqlQuery.setString(2,"CHECKING_ACCOUNT");
            sqlQuery.setInt(3,employeeId);
            int count=sqlQuery.executeUpdate();
            System.out.println(count +"checking account is inserted in table");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createNewSavings(double startAmount, Integer employeeId){
        try{
            PreparedStatement sqlQuery=connection.prepareStatement("INSERT INTO account"+"(balance,account_type,employee_id)VALUES(?,?,?)");
            sqlQuery.setDouble(1,startAmount);
            sqlQuery.setString(2,"SAVING_ACCOUNT");
            sqlQuery.setInt(3,employeeId);
            int count=sqlQuery.executeUpdate();
            System.out.println(1 + "Savings account is inserted in table");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createNewRetirement(double startAmount, Integer employeeId){
        try {
            PreparedStatement sqlQuery = connection.prepareStatement("INSERT INTO account" + "(balance,account_type,employee_id)Values(?,?,?)");
            sqlQuery.setDouble(1, startAmount);
            sqlQuery.setString(2, "RETIREMENT_ACCOUNT");
            sqlQuery.setInt(3, employeeId);
            int count = sqlQuery.executeUpdate();
            System.out.println(1 +" RETIREMENT ACCOUNT has inserted in to account table");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deposit(AccountType acctType, double amt, Integer employeeId){

        try{
            PreparedStatement getSqlQuery= connection.prepareStatement("SELECT * FROM account WHERE employee_id= ? and account_type= ?");
            getSqlQuery.setInt(1,employeeId);
            getSqlQuery.setString(2,valueOf(acctType));


            ResultSet resultSet=getSqlQuery.executeQuery();

            if(!resultSet.next()) {
                throw new RuntimeException("No record of the given id");
            }

            PreparedStatement updateSqlQuery=connection.prepareStatement("UPDATE account"+ "set balance= ? ");
            updateSqlQuery.setDouble(1,amt);
            System.out.println(amt +" is deposited in "+ acctType );

        }
        catch(SQLException e){
            e.printStackTrace();;
        }
    }

    boolean withdraw(AccountType acctType, double amt, Integer employeeId){


    }




}
