package service.employee;
import enums.AccountType;
import model.employe.Employee;
import config.DBConnection;
import java.sql.*;

//TODO: implement EmployeeService
public class EmployeeServiceImpl implements EmployeeService{
    Connection connect;
    PreparedStatement ps;
    ResultSet result;
    @Override
    public Employee createEmployee(Employee employee) {
        connect=DBConnection.connect();
        try{
            String query="insert into employee(employee_id,employee_name,hire_time) values(?,?,?)";
            ps=connect.prepareStatement(query);
            ps.setInt(1,employee.getId());
            ps.setString(2,employee.getName());
            ps.setString(3,employee.getHireDate().toString());
            ps.execute();
            return employee;
        }
        catch(SQLException e){
            System.out.println("Some error occured");
        }
        return null;
    }

    @Override
    public void createNewChecking(Double startAmount, Integer employeeId) {
        String name="";
        try{
            String query="select * from employee where employee_id=?";
            ps=connect.prepareStatement(query);
            ps.setInt(1,employeeId);
            result=ps.executeQuery();
            while(result.next()){
                name=result.getString("employee_name");
            }
            query="insert into account(account_type,employee_id,employee_name,balance) values(?,?,?,?)";
            ps=connect.prepareStatement(query);
            ps.setString(1,AccountType.CHECKING_ACCOUNT.toString());
            ps.setInt(2,employeeId);
            ps.setString(3,name);
            ps.setDouble(4,startAmount);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();

        }
    }

    @Override
    public void createNewSavings(double startAmount, Integer employeeId) {
        String name="";
        try{
            String query="select * from employee where employee_id=?";
            ps=connect.prepareStatement(query);
            ps.setInt(1,employeeId);
            result=ps.executeQuery();
            while(result.next()){
                name=result.getString("employee_name");
            }
            query="insert into account(account_type,employee_id,employee_name,balance) values(?,?,?,?)";
            ps=connect.prepareStatement(query);
            ps.setString(1,AccountType.SAVING_ACCOUNT.toString());
            ps.setInt(2,employeeId);
            ps.setString(3,name);
            ps.setDouble(4,startAmount);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public void createNewRetirement(double startAmount, Integer employeeId) {
        String name="";
        try{
            String query="select * from employee where employee_id=?";
            ps=connect.prepareStatement(query);
            ps.setInt(1,employeeId);
            result=ps.executeQuery();
            while(result.next()){
                name=result.getString("employee_name");
            }
            query="insert into account(account_type,employee_id,employee_name,balance) values(?,?,?,?)";
            ps=connect.prepareStatement(query);
            ps.setString(1,AccountType.RETIREMENT_ACCOUNT.toString());
            ps.setInt(2,employeeId);
            ps.setString(3,name);
            ps.setDouble(4,startAmount);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public void deposit(AccountType acctType, double amt, Integer employeeId) {
        try{
            double money=0d;
            String query="select balance from account where employee_id=?";
            ps=connect.prepareStatement(query);
            ps.setInt(1,employeeId);
            ps.execute();
            result=ps.executeQuery();

            while(result.next()){
                money=result.getDouble("balance");
            }
            String use="alter table account where account_type =? set balance=?";
            ps=connect.prepareStatement(use);
            ps.setString(1,acctType.toString());
            ps.setDouble(2,amt+money);
            ps.execute();

        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }

    @Override
    public boolean withdraw(AccountType acctType, double amt, Integer employeeId) {
        try{
            String use="select balance from account where employee_id=?";
            ps=connect.prepareStatement(use);
            ps.setInt(1,employeeId);
            ps.execute();
            result=ps.executeQuery();
            double getMoney=0;
            while (result.next()){

                getMoney=result.getDouble("balance");

            }
            if(getMoney<amt) {
                String toUse = "alter table account where employee_id=? set balance=?";
                ps = connect.prepareStatement(toUse);
                ps.setInt(1, employeeId);
                ps.setDouble(2, amt - getMoney);
                ps.execute();
            }
            else {
                System.out.println("Your money is not sufficient to withdraw");
            }

            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getFormattedAcctInfo(Integer employeeId) {
        try{
            String query="select * from account where employee_id=?";
            ps=connect.prepareStatement(query);
            ps.setInt(1,employeeId);
            result=ps.executeQuery();
            String name="",accountType="";
            int account_id=0,employee_id=0;
            double blc=0;
            while(result.next()){
                account_id=result.getInt("account_id");
                employee_id=result.getInt("employee_id");
                name=result.getString("employee_name");
                accountType=result.getString("account_type");
                blc=result.getDouble("balance");
            }
            return "Employee id: "+employee_id + " Employee name: " + name + " account id:  "+account_id+" account type: "+accountType+" balance: "+blc;

        }
        catch (SQLException e){
            e.printStackTrace();

        }
        return "";
    }
}
