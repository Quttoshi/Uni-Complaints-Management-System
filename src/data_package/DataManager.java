package data_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import classes.CafeteriaIssue;

public class DataManager {

    private static String mysql_url = "jdbc:mysql://localhost:3306/sda";
    private static String mysql_username = "root";
    private static String mysql_password = "123456";

    public static void saveToMYSQL(String issueText, String issueType, String UId, String Phone) {
        try (Connection con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password)) {
            System.out.println("Database connected successfully");

            // Modify the query to insert data into Library_Issue table
            String query = "INSERT INTO Library_Issue (IssueDescription, IssueType, ComplainantID, ComplainantPhone) VALUES (?,?,?,?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, issueText);
                preparedStatement.setString(2, issueType);
                preparedStatement.setString(3, UId);
                preparedStatement.setString(4, Phone);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.printf("Rows Affected = %d\n", rowsAffected);
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToMYSQLCafeteria(String issueText, String issueType, String UId, String Phone, String Suggest) {
        try (Connection con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password)) {
            System.out.println("Database connected successfully");

            // Modify the query to insert data into Cafeteria_Issue table
            String query = "INSERT INTO Cafeteria_Issue (IssueDescription, IssueType, ComplainantID, ComplainantPhone, Suggestion) VALUES (?,?,?,?,?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, issueText);
                preparedStatement.setString(2, issueType);
                preparedStatement.setString(3, UId);
                preparedStatement.setString(4, Phone);
                preparedStatement.setString(5, Suggest);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.printf("Rows Affected = %d\n", rowsAffected);
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateIssueStatus(int issueID, int no) {
        try (Connection con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password)) {
            System.out.println("Database connected successfully");
            
            if(no==1)
            {
            // Modify the query to update data in the corresponding table
            String query = "UPDATE Library_Issue SET Resolved=true WHERE IssueID=?";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, issueID);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.printf("Rows Affected = %d\n", rowsAffected);
            } catch (SQLException e) {
                System.out.println(e);
            }
        } 
            else if(no==2)
            {
            	String query = "UPDATE Cafeteria_Issue SET Resolved=true WHERE IssueID=?";

                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setInt(1, issueID);

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

	public static boolean saveToMYSQLCafeteria(CafeteriaIssue issue) {
		return false;
		// TODO Auto-generated method stub
		
	}



    
}
