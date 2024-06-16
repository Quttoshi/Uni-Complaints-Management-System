package classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetAll_lib_issues {

    private static String mysql_url = "jdbc:mysql://localhost:3306/sda";
    private static String mysql_username = "root";
    private static String mysql_password = "123456";


    public static List<LibraryIssues> getAllLibraryIssues() {
        List<LibraryIssues> libraryIssues = new ArrayList<>();
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

            if (con != null) {
                System.out.println("getAllLibraryIssues: Database connected successfully");
                String query = "SELECT * FROM Library_Issue";

                try (PreparedStatement preparedStatement = con.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {
                        LibraryIssues libraryIssue = new LibraryIssues();
                        libraryIssue.setIssueID(resultSet.getInt("IssueID"));
                        libraryIssue.setIssueDescription(resultSet.getString("IssueDescription"));
                        libraryIssue.setIssueType(resultSet.getString("IssueType"));
                        libraryIssue.setComplainantID(resultSet.getInt("ComplainantID"));
                        libraryIssue.setComplainantPhone(resultSet.getString("ComplainantPhone"));
                        libraryIssue.setResolved(resultSet.getBoolean("Resolved")); // Set boolean value

                        libraryIssues.add(libraryIssue);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION >>> " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return libraryIssues;
    }
    
    public static List<CafeteriaIssue> getAllCafeteriaIssues() {
        List<CafeteriaIssue> cafeteriaIssues = new ArrayList<>();
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysql_url, mysql_username, mysql_password);

            if (con != null) {
                System.out.println("getAllCafeteriaIssues: Database connected successfully");
                String query = "SELECT * FROM Cafeteria_Issue";

                try (PreparedStatement preparedStatement = con.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {
                        CafeteriaIssue cafeteriaIssue = new CafeteriaIssue();
                        cafeteriaIssue.setIssueID(resultSet.getInt("IssueID"));
                        cafeteriaIssue.setIssueDescription(resultSet.getString("IssueDescription"));
                        cafeteriaIssue.setIssueType(resultSet.getString("IssueType"));
                        cafeteriaIssue.setComplainantID(resultSet.getInt("ComplainantID"));
                        cafeteriaIssue.setComplainantPhone(resultSet.getString("ComplainantPhone"));
                        cafeteriaIssue.setSuggestion(resultSet.getString("Suggestion"));
                        cafeteriaIssue.setResolved(resultSet.getBoolean("Resolved")); // Set boolean value

                        cafeteriaIssues.add(cafeteriaIssue);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION >>> " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cafeteriaIssues;
    }

    

    
}
