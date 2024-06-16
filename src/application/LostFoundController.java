package application;

import java.util.ResourceBundle;

import classes.LostnFound;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LostFoundController implements Initializable{

	private Stage stg;
	private Scene scn;
	boolean status;
	
	
	
	@FXML
	private Button lf_return;
	
	@FXML
	private Button lf_harassment;
	
	@FXML
	private Button lf_academic;
	
	@FXML
	private Button lf_library;
	
	@FXML
	private Button lf_cafeteria;
	
	@FXML
	private Button lf_signout;
	
	@FXML
	private Button lf_submit;
	
	@FXML
	private Label lf_welcome;
	
	@FXML
	private Label lf_done;
	
	@FXML
	private TextArea lf_detail;
	
	@FXML
	private TextField lf_itemname;
	
	@FXML
	private TextField lf_idd;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	lf_harassment.setOnAction(new EventHandler<ActionEvent>() {
			
		FXMLLoader loader;
		
			@Override
			public void handle(ActionEvent arg0) {
					
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
	
	
	lf_submit.setOnAction(new EventHandler<ActionEvent>() {
		
		
			
		FXMLLoader loader;
		
			@Override
			public void handle(ActionEvent arg0) {
				
				int temp;
				
				temp = Integer.parseInt(lf_idd.getText());
				
				lf_done.setText("*Item is Reported");
				
				LostnFound obj = new LostnFound();
				obj.enterindb(temp, lf_detail.getText(), lf_itemname.getText(), status);
				
					
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
		
		
	

	lf_signout.setOnAction(new EventHandler<ActionEvent>() {
		
		
			
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
	
	

	lf_academic.setOnAction(new EventHandler<ActionEvent>() {
		
		
			
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

	
	

	lf_return.setOnAction(new EventHandler<ActionEvent>() {
		
		
			
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
	
	
	
	lf_library.setOnAction(new EventHandler<ActionEvent>() {
		
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
	
		lf_cafeteria.setOnAction(new EventHandler<ActionEvent>() {
		
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
	
	
	
	
	
	}
	
}
