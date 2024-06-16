package classes;

import java.sql.*;


public class Student extends User{

	private int Student_ID;
	private String password;
	private String DOB;
	private String Batch;
	private String Name;
	
	
	@Override
	public void senddata() {
		register_student(this.Student_ID, this.password, this.Name, this.DOB, this.Batch);
		
	}

	@Override
	public void recievedata() {
		retrieve_data(this.Student_ID, this.password);
	}


	public void printStudentinfo(int ID, String Password, String Name, String DOB, String batch) {
		
		System.out.print(ID);
		System.out.print('\n');
		System.out.print(Password);
		System.out.print('\n');
		System.out.print(Name);
		System.out.print('\n');
		System.out.print(DOB);
		System.out.print('\n');
		System.out.print(batch);
		
		
	}
	
	
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getStudent_ID() {
		return Student_ID;
	}
	
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getDOB() {
		return DOB;
	}
	
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	public String getBatch() {
		return Batch;
	}
	
	public void setBatch(String batch) {
		Batch = batch;
	}
	
	public void register_student(int ID, String Password, String Name, String DOB, String batch) {


	    String mysql_url = "jdbc:mysql://localhost:3306/sda";
	    String mysql_username = "root";
	    String mysql_password = "123456";

        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

            if (con != null) {
                System.out.println("Database connected successfully");

                String query = "INSERT INTO Students (Student_ID, Student_Password, Student_DOB, Student_Batch, Student_Name) VALUES (?,?,?,?,?)";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setInt(1, ID);
                    preparedStatement.setString(2, Password);
                    preparedStatement.setString(3, DOB);
                    preparedStatement.setString(4, batch);
                    preparedStatement.setString(5, Name);
                    
                    
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
	    System.out.println("Reading SDA DB");

	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sda", "root", "123456");
	         PreparedStatement statement = connection.prepareStatement("select Student_ID, Student_Password from Students where Student_ID = ?")) {

	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            String passwordFromDB = resultSet.getString("Student_Password");
	            if (passs.equals(passwordFromDB)) {
	                return true; // Passwords match, login successful
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; // Either student not found or password doesn't match
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
}
	
	









