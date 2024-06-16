package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolveAcademicIssuesController {

    @FXML
    private Label complaintLodgedAgainstLabel;

    @FXML
    private Label lodgedAgainstCourseLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Button resolveButton;

    public void initialize() {
        // Load data from the database
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // Prepare the SQL query to fetch all complaints
            String query = "SELECT complaintID, details, againstteacher, againstcourse FROM Academic_Issues";
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result set and display each complaint
            while (resultSet.next()) {
                String complaintLodgedAgainst = resultSet.getString("complaint_lodged_against");
                String lodgedAgainstCourse = resultSet.getString("lodged_against_course");
                String status = resultSet.getString("status");

                // Display the complaint details in the UI
                // You can decide how to display multiple complaints, e.g., appending to a text area
                String complaintDetails = "Complaint lodged against: " + complaintLodgedAgainst +
                                          ", Against Course: " + lodgedAgainstCourse +
                                          ", Status: " + status + "\n";

                // You can append the complaint details to a text area or display in any other suitable way
                // For demonstration purposes, let's append it to the labels (not recommended for multiple complaints)
                complaintLodgedAgainstLabel.setText(complaintDetails);
                lodgedAgainstCourseLabel.setText(complaintDetails);
                statusLabel.setText(complaintDetails);
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}