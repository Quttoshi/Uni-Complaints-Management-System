package application;

import java.io.IOException;
import java.util.List;

import classes.GetAll_lib_issues;
import classes.LibraryIssues;
import data_package.DataManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SolveLibraryController {
	
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
	

	@FXML
	public void initialize() {
		// Assuming this method is called when the controller is initialized
		
		

		c_return.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
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
		

		

		List<LibraryIssues> libraryIssuesList = null;
		try {
			libraryIssuesList = GetAll_lib_issues.getAllLibraryIssues();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String issueDetails = " ";
		for (LibraryIssues libraryIssue : libraryIssuesList) {
			System.out.println(libraryIssue.getIssueID());
			issueDetails += "Issue ID: " + libraryIssue.getIssueID() + "\n" + "Description: "
					+ libraryIssue.getIssueDescription() + "\n" + "Type: " + libraryIssue.getIssueType() + "\n"
					+ "Complainant ID: " + libraryIssue.getComplainantID() + "\n" + "Complainant Phone: "
					+ libraryIssue.getComplainantPhone() + "\n"+"Resolved: "+ libraryIssue.getResolved()+ "\n\n";

		}
		// Append the details to the existing text in the label
		viewIssue.setText(viewIssue.getText() + issueDetails);

	}
	
	@FXML
	public void TakeAction()
	{
		String id=IssueID.getText();
		int idd=Integer.parseInt(id);
		DataManager.updateIssueStatus(idd,1);
		
		
	}
	
	@FXML
	public void refresh()
	{
		
		List<LibraryIssues> libraryIssuesList = null;
		try {
			libraryIssuesList = GetAll_lib_issues.getAllLibraryIssues();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String issueDetails = " ";
		for (LibraryIssues libraryIssue : libraryIssuesList) {
			System.out.println(libraryIssue.getIssueID());
			issueDetails += "Issue ID: " + libraryIssue.getIssueID() + "\n" + "Description: "
					+ libraryIssue.getIssueDescription() + "\n" + "Type: " + libraryIssue.getIssueType() + "\n"
					+ "Complainant ID: " + libraryIssue.getComplainantID() + "\n" + "Complainant Phone: "
					+ libraryIssue.getComplainantPhone() + "\n"+"Resolved: "+ libraryIssue.getResolved()+ "\n\n";

		}
		// Append the details to the existing text in the label
		viewIssue.setText(viewIssue.getText() + issueDetails);

	}
	
	

}