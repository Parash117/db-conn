package service.employee;

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




}
