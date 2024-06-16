package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryIssues {
    private int issueID;
    private String issueDescription;
    private String issueType;
    private int complainantID;
    private String complainantPhone;
    private boolean resolved;

    // Constructors, getters, and setters

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public int getComplainantID() {
        return complainantID;
    }

    public void setComplainantID(int complainantID) {
        this.complainantID = complainantID;
    }

    public String getComplainantPhone() {
        return complainantPhone;
    }

    public void setComplainantPhone(String complainantPhone) {
        this.complainantPhone = complainantPhone;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    // Method to save issue data to the database
    public void saveLibraryIssues() {
        String mysql_url = "jdbc:mysql://localhost:3306/library";
        String mysql_username = "root";
        String mysql_password = "123456";

        try (Connection con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password)) {
            String query = "INSERT INTO Library_Issues (issueID, issueDescription, issueType, complainantID, complainantPhone, resolved) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, issueID);
                preparedStatement.setString(2, issueDescription);
                preparedStatement.setString(3, issueType);
                preparedStatement.setInt(4, complainantID);
                preparedStatement.setString(5, complainantPhone);
                preparedStatement.setBoolean(6, resolved);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.printf("Rows Affected = %d\n", rowsAffected);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public String getResolved() {
		// TODO Auto-generated method stub
		return null;
	}
}
