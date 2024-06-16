package classes;

import java.sql.*;

public class Admin extends User {
    
    private int Admin_ID;
    private String password;
    private String DOB;
    private String Name;
    

    @Override
    public void senddata() {
        register_admin(this.Admin_ID, this.password, this.Name, this.DOB);    
    }


    @Override
    public void receivedata1() {
        
        retrieve_data(this.Admin_ID, this.password);
    }   
    
    
    public int getAdmin_ID() {
        return Admin_ID;
    }
    
    
    public void setAdmin_ID(int admin_ID) {
        Admin_ID = admin_ID;
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
    
    
    public String getName() {
        return Name;
    }
    
    
    public void setName(String name) {
        Name = name;
    }
    

    public void register_admin(int ID, String Password, String Name, String DOB) {

        String mysql_url = "jdbc:mysql://localhost:3306/sda";
        String mysql_username = "root";
        String mysql_password = "123456";

        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

            if (con != null) {
                System.out.println("Database connected successfully");

                String query = "INSERT INTO Admin (Admin_ID, Admin_Password, Admin_DOB, Admin_Name) VALUES (?,?,?,?)";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setInt(1, ID);
                    preparedStatement.setString(2, Password);
                    preparedStatement.setString(3, DOB);
                    preparedStatement.setString(4, Name);
                    
                    
                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.printf("Rows Affected = %d\n", rowsAffected);
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }   
    
    
    
    public static boolean retrieve_data(int id, String passs) {

        Admin obj = new Admin();
        boolean flag = false;
        
        System.out.println("Reading SDA DB");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "123456");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select Admin_ID, Admin_Password from Admin;")) {

            while (resultSet.next()) {
                
                obj.setAdmin_ID(resultSet.getInt("Admin_ID"));
                obj.setPassword(resultSet.getString("Admin_Password"));    
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if(passs.compareTo(obj.getPassword()) == 0) {
            flag = true;
        }
        
        
        if(id == obj.getAdmin_ID() && flag) {
            return true;
        }
        
        return false;
    }


    @Override
    public void receivedata() {
        // TODO Auto-generated method stub
        
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


	public static Admin getInstance() {
		// TODO Auto-generated method stub
		return null;
	}



}
