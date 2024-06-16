package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Academic_AdminController implements Initializable {

	private Stage stg;
	private Scene scn;
	

	@FXML
	private Button aa_return;
	
	@FXML
	private Button aa_harassment;
	
	@FXML
	private Button aa_lostfound;
	
	@FXML
	private Button aa_library;
	
	@FXML
	private Button aa_cafeteria;
	
	@FXML
	private Button aa_signout;
	
	@FXML
	private Button aa_resolve;
	
	@FXML
	private Label aa_teacher;
	
	@FXML
	private Label aa_course;
	
	@FXML
	private Label aa_status;
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	aa_resolve.setOnAction(new EventHandler<ActionEvent>() {	
			
		
			@Override
			public void handle(ActionEvent arg0) {
					
				aa_status.setText("*Status Updated");
				
				
			}
		});	

	aa_harassment.setOnAction(new EventHandler<ActionEvent>() {	
			
		FXMLLoader loader;
		
			@Override
			public void handle(ActionEvent arg0) {
					
				Parent root = null;

				try {
						loader = new FXMLLoader(getClass().getResource("Harassment_Admin.fxml"));
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


	

	aa_lostfound.setOnAction(new EventHandler<ActionEvent>() {	
			
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


	

	aa_signout.setOnAction(new EventHandler<ActionEvent>() {	
			
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


	aa_return.setOnAction(new EventHandler<ActionEvent>() {	
			
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
	
	
	

	aa_cafeteria.setOnAction(new EventHandler<ActionEvent>() {
		
		
			
		FXMLLoader loader;
		
			@Override
			public void handle(ActionEvent arg0) {
					
				Parent root = null;

				try {
						loader = new FXMLLoader(getClass().getResource("CafeteriaIssue.fxml"));
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
	
	

	aa_library.setOnAction(new EventHandler<ActionEvent>() {
		
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

	
	}
}
