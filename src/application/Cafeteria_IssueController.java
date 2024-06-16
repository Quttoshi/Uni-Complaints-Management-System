package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data_package.DataManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Cafeteria_IssueController implements Initializable{
	@FXML
	private TextField issue;
	@FXML
	private TextField IssueType;
	@FXML
	private TextField UserId;
	@FXML
	private TextField phoneNo;
	@FXML
	private TextField suggestion;

	@FXML
	private Button c_return;
	
	@FXML
	private Button c_signout;
	
	
	private Stage stg;
	private Scene scn;
	

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {

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


			
			
	}
		
		// Event Listener on Button[#submit].onAction
		@FXML
		public void submitIssue(ActionEvent event) {
			
			String issueText = issue.getText();
			String issueType = IssueType.getText();
			String UId = UserId.getText();
			String Phone = phoneNo.getText();
			String suggest=suggestion.getText();
			
			 DataManager.saveToMYSQLCafeteria(issueText, issueType, UId, Phone,suggest);
		}
		
}
