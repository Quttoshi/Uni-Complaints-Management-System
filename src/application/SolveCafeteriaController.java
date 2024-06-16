package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import classes.CafeteriaIssue;
import classes.GetAll_lib_issues;
import data_package.DataManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SolveCafeteriaController implements Initializable {
	
	private Stage stg;
	private Scene scn;
	
	@FXML
	private TextField IssueID;
	@FXML
	private Label viewIssue;
	
	@FXML
	private Button c_return;
	
	@FXML
	private Button c_signout;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		c_return.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound_Admin.fxml"));
						root = loader.load();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
					scn = new Scene(root);
					stg.setScene(scn);
					stg.show();
				}
			});	
		
		

		c_signout.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
						root = loader.load();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
					stg = (Stage)((Node)arg0.getSource()).getScene().getWindow();
					scn = new Scene(root);
					stg.setScene(scn);
					stg.show();
				}
			});	

	
	}
	
	
	// Event Listener on Button.onAction
	@FXML
	public void initialize() {
	    // Assuming this method is called when the controller is initialized

	    List<CafeteriaIssue> cafeteriaIssuesList = null;
	    try {
	        cafeteriaIssuesList = GetAll_lib_issues.getAllCafeteriaIssues(); // Assuming you have a method to retrieve issues for Cafeteria_Issue
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    String issueDetails = " ";
	    for (CafeteriaIssue cafeteriaIssue : cafeteriaIssuesList) {
	        System.out.println(cafeteriaIssue.getIssueID());
	        issueDetails += "Issue ID: " + cafeteriaIssue.getIssueID() + "\n" + "Description: "
	                + cafeteriaIssue.getIssueDescription() + "\n" + "Type: " + cafeteriaIssue.getIssueType() + "\n"
	                + "Complainant ID: " + cafeteriaIssue.getComplainantID() + "\n" + "Complainant Phone: "
	                + cafeteriaIssue.getComplainantPhone() + "\n" + "Suggestion: " + cafeteriaIssue.getSuggestion() + "\n"
	                + "Resolved: " + cafeteriaIssue.isResolved() + "\n\n";
	    }

	    // Append the details to the existing text in the label
	    viewIssue.setText(viewIssue.getText() + issueDetails);
	}

	
	@FXML
	public void TakeAction(ActionEvent event) {

		String id=IssueID.getText();
		int idd=Integer.parseInt(id);
		DataManager.updateIssueStatus(idd,2);
	}
	// Event Listener on Button.onAction
	@FXML
	public void refresh(ActionEvent event) {
		
		viewIssue.setText("");
	    
		List<CafeteriaIssue> cafeteriaIssuesList = null;
	    try {
	        cafeteriaIssuesList = GetAll_lib_issues.getAllCafeteriaIssues(); // Assuming you have a method to retrieve issues for Cafeteria_Issue
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    String issueDetails = " ";
	    for (CafeteriaIssue cafeteriaIssue : cafeteriaIssuesList) {
	        System.out.println(cafeteriaIssue.getIssueID());
	        issueDetails += "Issue ID: " + cafeteriaIssue.getIssueID() + "\n" + "Description: "
	                + cafeteriaIssue.getIssueDescription() + "\n" + "Type: " + cafeteriaIssue.getIssueType() + "\n"
	                + "Complainant ID: " + cafeteriaIssue.getComplainantID() + "\n" + "Complainant Phone: "
	                + cafeteriaIssue.getComplainantPhone() + "\n" + "Suggestion: " + cafeteriaIssue.getSuggestion() + "\n"
	                + "Resolved: " + cafeteriaIssue.isResolved() + "\n\n";
	    }

	    // Append the details to the existing text in the label
	    viewIssue.setText(viewIssue.getText() + issueDetails);

	}


	
}
