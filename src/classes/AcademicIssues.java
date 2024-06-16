package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcademicIssues {
	
	private int complaintID;
	private String details;
	private String Againstteacher;
	private String Againstcourse;
	private Student std;
	private Admin adm;
	private Employee emp;
	
	
	
	
	public int getComplaintID() {
		return complaintID;
	}
	
	
	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}
	
	
	public String getDetails() {
		return details;
	}
	
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	public String getAgainstcourse() {
		return Againstcourse;
	}
	
	
	public void setAgainstcourse(String againstcourse) {
		Againstcourse = againstcourse;
	}
	
	
	public String getAgainstteacher() {
		return Againstteacher;
	}
	
	
	public void setAgainstteacher(String againstteacher) {
		Againstteacher = againstteacher;
	}
	
	
	public void savetodb(String course, String teacher, int id, String details) {
		

	    String mysql_url = "jdbc:mysql://localhost:3306/sda";
	    String mysql_username = "root";
	    String mysql_password = "123456";

        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

            if (con != null) {
                System.out.println("Database connected successfully");

                String query = "INSERT INTO Academic_Issues (details, againstteacher,againstcourse) VALUES (?,?,?)";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                	preparedStatement.setString(1, details);
                    preparedStatement.setString(2, teacher);
                    preparedStatement.setString(3, course);
                    
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


	public Student getStd() {
		return std;
	}


	public void setStd(Student std) {
		this.std = std;
	}


	public Admin getAdm() {
		return adm;
	}


	public void setAdm(Admin adm) {
		this.adm = adm;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}



}
