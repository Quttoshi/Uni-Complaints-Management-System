package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CafeteriaIssue {

    private int IssueID;
    private String IssueDescription;
    private String IssueType;
    private int ComplainantID;
    private String ComplainantPhone;
    private String Suggestion;
    private boolean Resolved;

    public CafeteriaIssue() {
    }

    public CafeteriaIssue(int IssueID, String IssueDescription, String IssueType, int ComplainantID, String ComplainantPhone, String Suggestion, boolean Resolved) {
        this.IssueID = IssueID;
        this.IssueDescription = IssueDescription;
        this.IssueType = IssueType;
        this.ComplainantID = ComplainantID;
        this.ComplainantPhone = ComplainantPhone;
        this.Suggestion = Suggestion;
        this.Resolved = Resolved;
    }

    // Getters and Setters
    public int getIssueID() {
        return IssueID;
    }

    public void setIssueID(int IssueID) {
        this.IssueID = IssueID;
    }

    public String getIssueDescription() {
        return IssueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.IssueDescription = issueDescription;
    }

    public String getIssueType() {
        return IssueType;
    }

    public void setIssueType(String issueType) {
        this.IssueType = issueType;
    }

    public int getComplainantID() {
        return ComplainantID;
    }

    public void setComplainantID(int complainantID) {
        this.ComplainantID = complainantID;
    }

    public String getComplainantPhone() {
        return ComplainantPhone;
    }

    public void setComplainantPhone(String complainantPhone) {
        this.ComplainantPhone = complainantPhone;
    }

    public String getSuggestion() {
        return Suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.Suggestion = suggestion;
    }

    public boolean isResolved() {
        return Resolved;
    }

    public void setResolved(boolean resolved) {
        this.Resolved = resolved;
    }

    // Method to save the cafeteria issue to the database
    public void saveCafeteriaIssues() {
        String mysql_url = "jdbc:mysql://localhost:3306/library";
        String mysql_username = "root";
        String mysql_password = "123456";

        try (Connection con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password)) {
            String query = "INSERT INTO Cafeteria_Issues (IssueID, IssueDescription, IssueType, ComplainantID, ComplainantPhone, Suggestion, Resolved) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, IssueID);
                preparedStatement.setString(2, IssueDescription);
                preparedStatement.setString(3, IssueType);
                preparedStatement.setInt(4, ComplainantID);
                preparedStatement.setString(5, ComplainantPhone);
                preparedStatement.setString(6, Suggestion);
                preparedStatement.setBoolean(7, Resolved);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.printf("Rows Affected = %d\n", rowsAffected);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
