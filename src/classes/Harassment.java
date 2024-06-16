package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Harassment {
	
	private int ObjectID;
	private String Description;
	private String victim_first_name;
	private String victim_last_name;
	private String accused_first_name;
	private String accused_last_name;
	
	public int getObjectID() {
		return ObjectID;
	}
	
	public void setObjectID(int objectID) {
		ObjectID = objectID;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getVictim_first_name() {
		return victim_first_name;
	}
	
	public void setVictim_first_name(String victim_first_name) {
		this.victim_first_name = victim_first_name;
	}
	
	public String getVictim_last_name() {
		return victim_last_name;
	}
	
	public void setVictim_last_name(String victim_last_name) {
		this.victim_last_name = victim_last_name;
	}
	
	public String getAccused_first_name() {
		return accused_first_name;
	}
	
	public void setAccused_first_name(String accused_first_name) {
		this.accused_first_name = accused_first_name;
	}
	
	public String getAccused_last_name() {
		return accused_last_name;
	}
	
	public void setAccused_last_name(String accused_last_name) {
		this.accused_last_name = accused_last_name;
	}
	
	public void saveHarassmentIssues(int idd, String afn, String aln, String vfn, String vln, String det) {
		String mysql_url = "jdbc:mysql://localhost:3306/sda";
		String mysql_username = "root";
		String mysql_password = "123456";

		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

			if (con != null) {
				System.out.println("Database connected successfully");

				String query = "INSERT INTO Harassment_casses (accused_first_name, accused_last_name, victim_first_name, victim_last_name, descriptionn, Statuss) VALUES (?,?,?,?,?, ?)";

				try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
					preparedStatement.setString(1, afn);
					preparedStatement.setString(2, aln);
					preparedStatement.setString(3, vfn);
					preparedStatement.setString(4, vln);
					preparedStatement.setString(5, det);
					preparedStatement.setBoolean(6, false);
					
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
}
