package application;


import java.util.ResourceBundle;

import classes.LostnFound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class LostFound_AdminController implements Initializable {

	private Stage stg;
	private Scene scn;
    ObservableList<LostnFound> listt = FXCollections.observableArrayList();

   
	
	@FXML
	private Button lfa_return;
	
	@FXML
	private Button lfa_harassment;
	
	@FXML
	private Button lfa_academic;

	@FXML
	private Button lfa_library;
	
	@FXML
	private Button lfa_cafeteria;
	
	@FXML
	private Button lfa_itemfound;
	
	@FXML
	private Button lfa_signout;
	
	@FXML
	private Label lfa_desc;
	
	@FXML
	private Label lfa_item;
	
	@FXML
	private Label lfa_status;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		

		lfa_academic.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("SolveAcademicIssues.fxml"));
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

		
		
		lfa_harassment.setOnAction(new EventHandler<ActionEvent>() {
		
				@Override
				public void handle(ActionEvent arg0) {
						
					Parent root = null;

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Harassment_Admin.fxml"));
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
		
		
		lfa_itemfound.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				lfa_status.setText("Item Found, Status Updated");
				
			}
		});	

		

		lfa_return.setOnAction(new EventHandler<ActionEvent>() {
			
			
				
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
		
		
		

		lfa_cafeteria.setOnAction(new EventHandler<ActionEvent>() {
			
			
				
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
		
		

		lfa_library.setOnAction(new EventHandler<ActionEvent>() {
			
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
	
	}
	
}
