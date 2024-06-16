package application;


import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class Harassment_AdminController implements Initializable{


	private Stage stg;
	private Scene scn;
	

	
	@FXML
	private Label ha_caseid;
	
	@FXML
	private Button ha_return;
	
	@FXML
	private Button ha_signout;
	
	@FXML
	private Button ha_resolved;
	
	@FXML
	private Button ha_lostfound;
	
	@FXML
	private Button ha_cafeteria;
	
	@FXML
	private Button ha_academic;
	
	@FXML
	private Button ha_library;
	
	@FXML
	private Label ha_accusedname;
	
	@FXML
	private Label ha_victimname;
	
	@FXML
	private Label ha_details;
	
	@FXML
	private Label ha_statuss;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		ha_resolved.setOnAction(new EventHandler<ActionEvent>() {
			
			
		
				@Override
				public void handle(ActionEvent arg0) {
					
					ha_statuss.setText("Case Resolved, Status Updated");
					
				}
			});	

		ha_academic.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("SolveAcademicIssues.fxml"));
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

		
		
		ha_lostfound.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("LostFound_Admin.fxml"));
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

		
		

		ha_cafeteria.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("SolveCafeteria.fxml"));
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


		ha_library.setOnAction(new EventHandler<ActionEvent>() {
			
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("SolveLibrary.fxml"));
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

		ha_return.setOnAction(new EventHandler<ActionEvent>() {
				
			FXMLLoader loader;
			
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
							loader = new FXMLLoader(getClass().getResource("LostFound_Admin.fxml"));
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
	
}
