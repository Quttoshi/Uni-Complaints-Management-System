package classes;

import java.sql.*;

public class Employee extends User{

    private int Employee_ID;
    private String password;
    private String DOB;
    private String Year_of_Hiring;
    private String Name;

    @Override
    public void receivedata() {
        retrieve_data(this.usr_ID, this.password);
    }

    @Override
    public void senddata() {
        register_employee(this.Employee_ID, this.password, this.Name, this.DOB, this.Year_of_Hiring);
    }

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        Employee_ID = employee_ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    public String getYear_of_Hiring() {
        return Year_of_Hiring;
    }

    public void setYear_of_Hiring(String year_of_Hiring) {
        Year_of_Hiring = year_of_Hiring;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void register_employee(int ID, String Password, String Name, String DOB, String YearofHiring) {
        String mysql_url = "jdbc:mysql://localhost:3306/sda";
        String mysql_username = "root";
        String mysql_password = "123456"; // Replace with your actual database password

        try (Connection con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password)) {
            System.out.println("Database connected successfully");

            String query = "INSERT INTO Employee (Employee_ID, Employee_Password, Employee_DOB, Employee_YearofHiring, Employee_Name) VALUES (?,?,?,?,?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, ID);
                preparedStatement.setString(2, Password);
                preparedStatement.setString(3, DOB);
                preparedStatement.setString(4, YearofHiring);
                preparedStatement.setString(5, Name);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.printf("Rows Affected = %d\n", rowsAffected);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean retrieve_data(int id, String passs) {
        boolean flag = false;

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "123456");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Employee_Password FROM Employee WHERE Employee_ID = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String empPassword = resultSet.getString("Employee_Password");
                if (passs.equals(empPassword)) {
                    flag = true; // Credentials are correct
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public void complaints_issues() {
        // TODO Auto-generated method stub
    }

    @Override
    public void login() {
        // TODO Auto-generated method stub
    }

    @Override
    public void register() {
        // TODO Auto-generated method stub
    }

    @Override
    public void complaint_issues() {
        // TODO Auto-generated method stub
    }

    @Override
    public void recievedata() {
        // TODO Auto-generated method stub

    }
}
