package application;


import java.util.ResourceBundle;

import classes.Harassment;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HarassmentController implements Initializable{

	

	private Stage stg;
	private Scene scn;
	
	@FXML
	private Button h_return;
	
	@FXML
	private Button h_signout;
	
	@FXML
	private Button h_submit;
	
	@FXML
	private Button h_lostfound;
	
	@FXML
	private Button h_cafeteria;
	
	@FXML
	private Button h_academic;
	
	@FXML
	private Button h_library;
	
	@FXML
	private TextField h_accusedfirstname;
	
	@FXML
	private TextField h_accusedlastname;
	
	@FXML
	private TextField h_victimfirstname;
	
	@FXML
	private TextField h_victimlastname;
	
	@FXML
	private TextArea h_details;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		


		h_submit.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
					
					setHarassmentinfo();
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("Harassment.fxml"));
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

		
		
		

	
		h_lostfound.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
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



		h_academic.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("Academic_Issues.fxml"));
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

		

		h_cafeteria.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("Cafeteria_Issue.fxml"));
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


		h_library.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("LibraryIssue.fxml"));
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

		h_signout.setOnAction(new EventHandler<ActionEvent>() {
				
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("login.fxml"));
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
		

		

		h_return.setOnAction(new EventHandler<ActionEvent>() {
			
			
				
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("LostFound.fxml"));
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
	
	
	public void setHarassmentinfo() {
		
		Harassment obj = new Harassment();
		
		obj.setObjectID(1);
		obj.setVictim_first_name(h_victimlastname.getText());
		obj.setVictim_last_name(h_victimlastname.getText());
		obj.setAccused_first_name(h_accusedfirstname.getText());
		obj.setAccused_last_name(h_accusedlastname.getText());
		obj.setDescription(h_details.getText());
		
		
		obj.saveHarassmentIssues(obj.getObjectID(), obj.getAccused_first_name(), obj.getVictim_last_name(), obj.getAccused_first_name(), obj.getAccused_last_name(), obj.getDescription());
	}
	
	
}
